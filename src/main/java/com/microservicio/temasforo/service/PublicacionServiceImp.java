package com.microservicio.temasforo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.microservicio.temasforo.models.Publicacion;
import com.microservicio.temasforo.repository.PublicacionRepository;

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
        if (publicacion.getFecha_publicacion() != null) {

            modificar.setFecha_publicacion(publicacion.getFecha_publicacion());
        }

        if (publicacion.getEstado() != null && !publicacion.getEstado().isBlank()) {

            modificar.setEstado(publicacion.getEstado());
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
