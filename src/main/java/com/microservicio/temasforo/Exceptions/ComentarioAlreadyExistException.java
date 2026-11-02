package com.microservicio.temasforo.Exceptions;

public class ComentarioAlreadyExistException extends RuntimeException {
    
    public ComentarioAlreadyExistException(String msj){

        super(msj);
    }
}
