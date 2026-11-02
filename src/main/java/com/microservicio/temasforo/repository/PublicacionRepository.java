package com.microservicio.temasforo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicio.temasforo.models.Publicacion;

public interface PublicacionRepository extends  JpaRepository <Publicacion,Long>{

     boolean existsByTitulo(String titulo);
     Publicacion findByTitulo(String titulo);
    
    
}
