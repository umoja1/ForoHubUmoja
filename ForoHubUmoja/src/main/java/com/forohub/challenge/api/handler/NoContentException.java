package com.forohub.challenge.api.handler;

public class NoContentException extends  RuntimeException{

    public NoContentException(String mensaje){
        super(mensaje);
    }
}
