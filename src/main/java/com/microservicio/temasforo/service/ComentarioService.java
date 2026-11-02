package com.microservicio.temasforo.service;

import java.util.List;

import com.microservicio.temasforo.models.Comentario;

public interface ComentarioService {


    Comentario crearComentario(Comentario comentario);
    
    void eliminarComentario(Long id);

    Comentario modificarComentario(Long id, Comentario comentario);
    
    List <Comentario> mostrarComentarios();

    Comentario buscarcComentario(Long id);

}
