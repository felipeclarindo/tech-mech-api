package resource;

import java.util.ArrayList;

import bo.ClienteBO;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import to.ClienteTO;

@Path("/api/clients")
public class ClienteResource {
    private ClienteBO clienteBO = new ClienteBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllClientes() {
        ArrayList<ClienteTO> resultado = clienteBO.findAllClientes();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCpf(@PathParam("cpf") String cpf) {
        ClienteTO resultado = clienteBO.findByCpf(cpf);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCliente(@Valid ClienteTO cliente) {
        ClienteTO resultado = clienteBO.saveCliente(cliente);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{cpf}")
    public Response deleteCliente(@PathParam("cpf") String cpf) {
        Response.ResponseBuilder response = null;
        if (clienteBO.deleteCliente(cpf)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{cpf}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCliente(@Valid ClienteTO cliente, @PathParam("cpf") String cpf) {
        cliente.setCpf(cpf);
        ClienteTO resultado = clienteBO.updateCliente(cliente);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(ClienteTO cliente) {
        boolean isAuthenticated = clienteBO.autenticarCliente(cliente.getCpf(), cliente.getSenha());
        if (isAuthenticated) {
            return Response.ok(true).build();
        }
        return Response.ok(false).status(400).build();
    }
}
