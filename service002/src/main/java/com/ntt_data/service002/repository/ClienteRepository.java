package com.ntt_data.service002.repository;

import com.ntt_data.service002.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c.nombre FROM Cliente c WHERE c.cliente_id = :cliente_id")
    String obtenerNombreCliente(@Param("cliente_id") long cliente_id);

    @Query("SELECT c FROM Cliente c WHERE c.cliente_id = :cliente_id")
    String obtenerCuentasCliente(@Param("cliente_id") long cliente_id);
}