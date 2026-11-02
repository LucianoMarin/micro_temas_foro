package com.microservicio.temasforo.service;

import java.util.List;


import com.microservicio.temasforo.models.Publicacion;

public interface PublicacionService {

    Publicacion crearPublicacion(Publicacion comentario);
    
    void eliminarPublicacion(Long id);

    Publicacion modificarPublicacion(Long id, Publicacion comentario);
    
    List <Publicacion> mostrarPublicaciones();

    Publicacion buscarPublicacion(Long id);

    
}
