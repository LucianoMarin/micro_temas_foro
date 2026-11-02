package com.microservicio.temasforo.models;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table (name="comentario")
@Getter 
@Setter 
public class Comentario {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="contenido")
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "publicacion_id")
    private Publicacion publicacion;
    
    @Column (name="fecha_publicacion")
    private LocalDate fechaPublicacion;
    

    @Column (name="usuario_id")
    private Long idUsuario;




    public Comentario(){}


    public Comentario(Long id,String contenido,Publicacion publicacion,LocalDate fechaPublicacion,Long idUsuario){

        this.id=id;
        this.contenido=contenido;
        this.publicacion=publicacion;
        this.fechaPublicacion=fechaPublicacion;
        this.idUsuario=idUsuario;


    }
    

      public Comentario(String contenido,Publicacion publicacion,LocalDate fechaPublicacion,Long idUsuario){


        this.contenido=contenido;
        this.publicacion=publicacion;
        this.fechaPublicacion=fechaPublicacion;
        this.idUsuario=idUsuario;


    }

    
}
