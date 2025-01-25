package br.com.gestao_eventos.layers.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException(){
        super("Usuário já existe");
    }
    
}
