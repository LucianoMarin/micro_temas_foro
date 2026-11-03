package com.microservicio.temasforo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.temasforo.models.Comentario;
import com.microservicio.temasforo.service.ComentarioService;



@RestController 
@RequestMapping("/comentarios")
public class ControllerComentario{
    

@Autowired 
ComentarioService comentarioService;



@GetMapping
public List <Comentario> mostrarComentarios(){

    return comentarioService.mostrarComentarios();
    
}


@GetMapping ("/{id}")
public Comentario buscarComentario(@PathVariable Long id){

    return  comentarioService.buscarcComentario(id);

}


@PostMapping 
public Comentario creaComentario(@RequestBody Comentario comentario){

    return comentarioService.crearComentario(comentario);

}


@DeleteMapping("/{id}") 
public void eliminarComentario(@PathVariable Long id){

    comentarioService.eliminarComentario(id);
}


@PutMapping("/{id}") 
public Comentario modificarComentario(@PathVariable Long id, @RequestBody Comentario comentario){


    return comentarioService.modificarComentario(id, comentario);
}

}
