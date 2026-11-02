package com.microservicio.temasforo.Exceptions;

public class PublicacionAlreadyExistException extends RuntimeException {
    
    public PublicacionAlreadyExistException(String msj){

        super(msj);
    }
}
