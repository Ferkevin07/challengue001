package com.ntt_data.service002.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Persona {
//    @Id
//    @GeneratedValue
    private int identificacion;

    //@Column(nullable = false)
    private String nombre;
    private String genero;
    private int edad;
    private String telefono;
    private String direccion;

//    public Persona(String nombre,String genero, int edad, String telefono, String direccion) {
//        this.nombre = nombre;
//        this.telefono = telefono;
//        this.genero = genero;
//        this.edad = edad;
//        this.direccion = direccion;
//    }

}
