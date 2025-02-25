package com.ntt_data.service003.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaRequest {

    private String numero_cuenta;
    private String tipo;
    private Double saldo_inicial;
    private Boolean estado;
    private Long cliente_id;
}