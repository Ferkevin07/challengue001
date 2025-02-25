package com.ntt_data.service003.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ReporteSinClienteNombreDTO {
    private Date fecha;
    private String numeroCuenta;
    private String tipo;
    private Double saldoInicial;
    private Boolean estado;
    private Double valor;
    private Double saldo;
    private Long clienta_id;
}
