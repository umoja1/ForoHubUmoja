package com.forohub.challenge.api.handler;

public class IllegalArgumentException extends RuntimeException{
    public IllegalArgumentException(String mensaje) {
        super(mensaje);
    }
}
