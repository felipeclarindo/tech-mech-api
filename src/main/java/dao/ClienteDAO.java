package dao;

import to.ClienteTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO extends Repository{
    public ArrayList<ClienteTO> findAllClientes() {
        ArrayList<ClienteTO> clientes = new ArrayList<ClienteTO>();
        String sql = "select * from usuario order by nm_cliente";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ClienteTO cliente = new ClienteTO();
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setNome(rs.getString("nm_cliente"));
                    cliente.setTelefone(rs.getString("telefone"));
                    clientes.add(cliente);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return clientes;
    }

    public ClienteTO findByCpf(String cpf) {
        ClienteTO cliente = new ClienteTO();
        String sql = "select * from usuario where cpf = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nm_cliente"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setSenha(rs.getString("senha"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return cliente;
    }

    public ClienteTO saveCliente(ClienteTO cliente) {
        String sql = "insert into usuario(cpf, nm_cliente, telefone, senha) values(?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getSenha());
            if (ps.executeUpdate() > 0) {
                return cliente;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean deleteCliente(String cpf) {
        String sql = "delete from usuario where cpf = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, cpf);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public ClienteTO updateCliente(ClienteTO cliente) {
        String sql = "update usuario set nm_cliente=?, telefone=?, senha=? where cpf=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelefone());
            ps.setString(3, cliente.getSenha());
            ps.setString(4, cliente.getCpf());
            if (ps.executeUpdate() > 0) {
                return cliente;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: "  + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean autenticarCliente(String cpf, String senha) {
        String sql = "select * from usuario where cpf = ? and senha = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, cpf);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

}
