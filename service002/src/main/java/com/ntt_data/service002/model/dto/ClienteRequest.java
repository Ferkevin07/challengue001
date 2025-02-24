package com.ntt_data.service002.model.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

    private int identificacion;
    private String contrasena;
    private Boolean estado;
    private String nombre;
    private String genero;
    private int edad;
    private String telefono;
    private String direccion;

}
