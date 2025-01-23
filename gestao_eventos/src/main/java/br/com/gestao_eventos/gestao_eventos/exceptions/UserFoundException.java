package br.com.gestao_eventos.gestao_eventos.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException(){
        super("Usuário já existe");
    }
    
}
