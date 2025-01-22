package resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.Map;

@Path("/api")
public class ApiResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON) // Indica que o retorno será em formato JSON
    public Map<String, Object> getApiDescription() {
        Map<String, Object> description = new HashMap<>();
        description.put("welcome", "Welcome to the Tech Mech API!");
        description.put("API status", "Running");
        description.put("description", "Below are the available routes for managing clients:");

        Map<String, Object> routes = new HashMap<>();

        routes.put("GET /api/clients", Map.of(
                "description", "Retrieve all registered clients.",
                "response", "List of clients in JSON format."
        ));

        routes.put("GET /api/clients/{cpf}", Map.of(
                "description", "Retrieve client details by CPF.",
                "pathParameter", Map.of("cpf", "Client's CPF (e.g., 12345678900)."),
                "response", "JSON object containing client details."
        ));

        routes.put("POST /api/clients", Map.of(
                "description", "Add a new client.",
                "requestBody", Map.of(
                        "name", "Client's name (String)",
                        "cpf", "Client's CPF (String)",
                        "password", "Client's password (String)",
                        "phone", "Client's phone number (String)"
                ),
                "response", "Success message with client ID."
        ));

        routes.put("PUT /api/clients/{cpf}", Map.of(
                "description", "Update existing client details.",
                "pathParameter", Map.of("cpf", "Client's CPF to update."),
                "requestBody", "JSON object with updated client data.",
                "response", "Success message indicating the update status."
        ));

        routes.put("DELETE /api/clients/{cpf}", Map.of(
                "description", "Delete a client by CPF.",
                "pathParameter", Map.of("cpf", "Client's CPF to delete."),
                "response", "Success message indicating the deletion status."
        ));

        description.put("routes", routes);
        description.put("note", "Use these endpoints to manage client information effectively. Ensure proper authentication and authorization when integrating this API.");

        return description;
    }
}
