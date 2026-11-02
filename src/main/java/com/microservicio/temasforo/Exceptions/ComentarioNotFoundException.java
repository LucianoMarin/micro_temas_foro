package com.microservicio.temasforo.Exceptions;

public class ComentarioNotFoundException extends RuntimeException{

    public ComentarioNotFoundException(String msj){
        super(msj);
    }
    
}
