package br.com.gestao_eventos.back_end.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException(){
        super("Usuário já existe");
    }
    
}
