package com.ntt_data.service003.repository;

import com.ntt_data.service003.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    @Query("SELECT c.cuenta_id FROM Cuenta c WHERE c.cliente_id = :cliente_id")
    List<Long> obtenerCuentasCliente(@Param("cliente_id") long cliente_id);
}

