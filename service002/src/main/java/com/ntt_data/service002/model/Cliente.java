package com.ntt_data.service002.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
public class Cliente extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long cliente_id;

    @Column(nullable = false)
    private String contrasena;
    @Column(nullable = false)
    private Boolean estado;

    public Cliente(int identificacion, String nombre,String genero, int edad, String telefono, String direccion, String contrasena, Boolean estado) {
        super(identificacion,nombre,genero,edad,telefono,direccion);
        this.contrasena = contrasena;
        this.estado = estado;
    }


}