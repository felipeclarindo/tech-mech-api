package bo;

import dao.ClienteDAO;
import to.ClienteTO;
import java.util.ArrayList;

public class ClienteBO {
    private ClienteDAO clienteDAO;

    public ArrayList<ClienteTO> findAllClientes() {
        clienteDAO = new ClienteDAO();
        return clienteDAO.findAllClientes();
    }

    public ClienteTO findByCpf(String cpf) {
        clienteDAO = new ClienteDAO();
        return clienteDAO.findByCpf(cpf);
    }

    public ClienteTO saveCliente(ClienteTO cliente) {
        clienteDAO = new ClienteDAO();
        return clienteDAO.saveCliente(cliente);
    }

    public boolean deleteCliente(String cpf) {
        clienteDAO = new ClienteDAO();
        return clienteDAO.deleteCliente(cpf);
    }

    public ClienteTO updateCliente(ClienteTO cliente) {
        clienteDAO = new ClienteDAO();
        return clienteDAO.updateCliente(cliente);
    }

    public boolean autenticarCliente(String cpf, String senha) {
        clienteDAO = new ClienteDAO();
        return clienteDAO.autenticarCliente(cpf, senha);
    }
}
