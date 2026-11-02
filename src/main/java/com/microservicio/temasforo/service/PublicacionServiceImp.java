package com.microservicio.temasforo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.temasforo.Exceptions.PublicacionNotFoundException;
import com.microservicio.temasforo.models.Publicacion;
import com.microservicio.temasforo.repository.PublicacionRepository;


@Service 
public class PublicacionServiceImp implements PublicacionService {

    @Autowired
    PublicacionRepository publicacionRepository;


    

    @Override
    public Publicacion buscarPublicacion(Long id) {

        return publicacionRepository.findById(id).orElseThrow();
    }

    @Override
    public Publicacion crearPublicacion(Publicacion publicacion) {

        return publicacionRepository.save(publicacion);
    }

    @Override
    public void eliminarPublicacion(Long id) {

        if(!publicacionRepository.existsById(id)){

            throw new PublicacionNotFoundException("ID NO VALIDO, NO SE PUEDE ELIMINAR PUBLICACION");
        }

        publicacionRepository.deleteById(id);
    }

    @Override
    public Publicacion modificarPublicacion(Long id, Publicacion publicacion) {
        Publicacion modificar = publicacionRepository.findById(id).orElseThrow();

        if (publicacion.getTitulo() != null && !publicacion.getTitulo().isBlank()) {

            modificar.setTitulo(publicacion.getTitulo());

        }
        if (publicacion.getContenido() != null && !publicacion.getContenido().isBlank()) {

            modificar.setContenido(publicacion.getContenido());

        }
        if (publicacion.getFechaPublicacion() != null) {

            modificar.setFechaPublicacion(publicacion.getFechaPublicacion());
        }

        if (publicacion.isEstado()) {

            modificar.setEstado(publicacion.isEstado());
        }
        if (publicacion.getId_usuario() != null) {

            modificar.setId_usuario(publicacion.getId_usuario());
        }

           return publicacionRepository.save(modificar);

    }

    @Override
    public List<Publicacion> mostrarPublicaciones() {
        return publicacionRepository.findAll();
    }

}
