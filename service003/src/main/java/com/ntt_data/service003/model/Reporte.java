package com.ntt_data.service003.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reporte {

    //private int idReporte;
    private Date fecha;
    private String numero_cuenta;
    private String tipo_cuenta;

    private Double saldo_inicial;

    private Boolean estado;
//
    private Double movimiento;
    private Double saldo_disponible;

    //private String cliente;

    public Reporte(Date fecha, String numero_cuenta, String tipo_cuenta, Double saldo_inicial, Double movimiento) {
        this.fecha = fecha;
        this.numero_cuenta = numero_cuenta;
        this.tipo_cuenta = tipo_cuenta;
        this.saldo_inicial = saldo_inicial;
        //this.estado = estado;
        this.movimiento = movimiento;
    }

    @Override
    public String toString() {
        return fecha.toString()+"//"+numero_cuenta+"//"+tipo_cuenta+"//"+saldo_inicial+"//"+estado+"//"+movimiento+"//"+saldo_disponible;
    }

}
