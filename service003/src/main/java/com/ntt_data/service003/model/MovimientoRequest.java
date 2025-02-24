package com.ntt_data.service003.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoRequest {

    private String tipo;
    private Date fecha;
    private Double valor;
    //private Double saldo;
    private Long cuenta_id;

}
