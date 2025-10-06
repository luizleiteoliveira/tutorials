package org.acme;

public class ReturnGraphQL {
    private String nome;
    private String email;
    private String token;
    private String tipo;
    
    public ReturnGraphQL(String nome, String email, String token, String tipo) {
        this.nome = nome;
        this.email = email;
        this.token = token;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }
}
