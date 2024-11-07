package to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClienteTO {
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 dígitos.")
    private String cpf;
    @NotBlank
    private String nome;
    @NotBlank
    @Size(min = 11, max = 11, message = "O telefone deve ter 11 dígitos!")
    private String telefone;
    @NotBlank
    @Size(min = 8, message = "A senha deve ter pelo menos 8 dígitos.")
    private String senha;

    // Construtores
    public ClienteTO() {
    }

    public ClienteTO(@Size(min = 11, max = 11, message = "O CPF deve ter 11 dígitos.") String cpf, @NotBlank String nome, @NotBlank @Size(min = 11, max = 11, message = "O telefone deve ter 11 dígitos!") String telefone, @NotBlank @Size(min = 8, message = "A senha deve ter pelo menos 8 dígitos.") String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
    }

    // Getters e setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
