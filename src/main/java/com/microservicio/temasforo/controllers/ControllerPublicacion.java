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

import com.microservicio.temasforo.models.Publicacion;
import com.microservicio.temasforo.service.PublicacionService;



@RestController 
@RequestMapping ("/publicaciones")
public class ControllerPublicacion {
    



@Autowired 
PublicacionService publicacionService;



@GetMapping
public List <Publicacion> mostrarPublicaciones(){

    return publicacionService.mostrarPublicaciones();
    
}


@GetMapping ("/{id}")
public Publicacion buscarPublicacion(@PathVariable Long id){

    return  publicacionService.buscarPublicacion(id);

}


@PostMapping 
public Publicacion crearPublicacion(@RequestBody Publicacion publicacion){

    return publicacionService.crearPublicacion(publicacion);

}


@DeleteMapping ("/{id}")
public void elimianrPublicacion(@PathVariable Long id){

    publicacionService.eliminarPublicacion(id);
}


@PutMapping 
public Publicacion modificarPublicacion(@PathVariable Long id, @RequestBody Publicacion publicacion){


    return publicacionService.modificarPublicacion(id, publicacion);
}





}
