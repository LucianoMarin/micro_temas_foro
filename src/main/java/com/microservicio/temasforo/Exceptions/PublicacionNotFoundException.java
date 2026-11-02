package com.microservicio.temasforo.Exceptions;

public class PublicacionNotFoundException extends RuntimeException{

    public PublicacionNotFoundException(String msj){
        super(msj);
    }
    
}
