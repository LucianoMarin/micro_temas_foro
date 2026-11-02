package com.microservicio.temasforo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.temasforo.models.Comentario;
import com.microservicio.temasforo.repository.ComentarioRepository;


@Service 
public class ComentarioServiceImp implements ComentarioService {
    
    @Autowired 
    ComentarioRepository comentarioRepository;

    

    @Override
    public Comentario buscarcComentario(Long id) {
        
        return comentarioRepository.findById(id).orElseThrow();
    }


    @Override
    public Comentario crearComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }



    @Override
    public void eliminarComentario(Long id) {

        comentarioRepository.deleteById(id);

    }



    @Override
    public Comentario modificarComentario(Long id, Comentario comentario) {

        Comentario modificar=comentarioRepository.findById(id).orElseThrow();

        if(comentario.getContenido()!=null && !comentario.getContenido().isBlank()){

            modificar.setContenido(comentario.getContenido());

        }

        if(comentario.getFechaPublicacion()!=null ){

            modificar.setFechaPublicacion(comentario.getFechaPublicacion());
        }

        if(comentario.getIdUsuario()!=null){

            modificar.setIdUsuario(comentario.getIdUsuario());

        }

        if(comentario.getPublicacion()!=null){

            modificar.setPublicacion(comentario.getPublicacion());
        }


        return comentarioRepository.save(modificar);
    }





    @Override
    public List<Comentario> mostrarComentarios() {

        return comentarioRepository.findAll();
    }

}
