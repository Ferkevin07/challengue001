package com.ntt_data.service003.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "movimientos")
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movimiento_id")
    private Long movimiento_id;

    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private Double valor;
    @Column(nullable = false)
    private Double saldo;

    @Column(nullable = false)
    private Long cuenta_id;

    public Movimiento(String tipo, Date fecha, Double valor, Double saldo, Long cuenta_id) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.valor = valor;
        this.saldo = saldo;
        this.cuenta_id = cuenta_id;
    }

//    @ManyToOne
//    @JoinColumn(name = "cuenta_id")
//    private Cuenta cuenta;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "cuenta_id", nullable = false) // Clave foránea
//    private Cuenta cuenta;

}
