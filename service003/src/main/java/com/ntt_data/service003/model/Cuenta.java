package com.ntt_data.service003.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "cuentas")
@NoArgsConstructor
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuenta_id")
    private Long cuenta_id;

    @Column
    private String numero_cuenta;
    @Column
    private String tipo;
    @Column
    private Double saldo_inicial;
    @Column
    private Boolean estado;
    @Column
    private Long cliente_id;

    public Cuenta(String numero_cuenta, String tipo, Double saldo_inicial, Boolean estado, Long cliente_id) {
        //this.cuenta_id = cuenta_id;
        this.numero_cuenta = numero_cuenta;
        this.tipo = tipo;
        this.saldo_inicial = saldo_inicial;
        this.estado = estado;
        this.cliente_id = cliente_id;
    }


//     @OneToMany(mappedBy = "cuentas", cascade = CascadeType.ALL)
//    private List<Movimiento> movimientos;
    //@OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
//    @JsonManagedReference
    //private List<Movimiento> movimientos;
}
