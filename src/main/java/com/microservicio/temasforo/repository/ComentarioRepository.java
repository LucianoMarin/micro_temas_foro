package com.microservicio.temasforo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicio.temasforo.models.Comentario;

public interface ComentarioRepository extends JpaRepository <Comentario ,Long>{
    
}
