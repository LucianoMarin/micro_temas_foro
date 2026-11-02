package com.microservicio.temasforo.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table (name="publicacion")
@Getter 
@Setter 

public class Publicacion {

@Id 
@GeneratedValue (strategy = GenerationType.IDENTITY)    
private Long id;

@Column (name="titulo")
private String titulo;

@Column (name="contenido")
private String contenido;

@Column (name="fecha_publicacion")
private Date fecha_publicacion;

@Column (name="estado")
private String estado;

@Column (name="usuario_id")
private Long id_usuario;



public Publicacion(){}


public Publicacion(Long id,String titulo,String contenido,Date fecha_publicacion,String estado,Long id_usuario){

    this.id=id;
    this.titulo=titulo;
    this.contenido=contenido;
    this.fecha_publicacion=fecha_publicacion;
    this.estado=estado;
    this.id_usuario=id_usuario;


}




}
