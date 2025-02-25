package com.ntt_data.service003.repository;

import com.ntt_data.service003.model.Movimiento;
import com.ntt_data.service003.model.Reporte;
import com.ntt_data.service003.model.dto.ReporteSinClienteNombreDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    @Query("SELECT u FROM Movimiento u")
    List<Movimiento> findAllWithClientes();

    @Query("SELECT COUNT(c) FROM Movimiento c WHERE c.cuenta_id = :cuenta_id")
    long contarMovimientosCuenta(@Param("cuenta_id") long cuenta_id);

    @Query("SELECT c.saldo_inicial FROM Cuenta c WHERE c.cuenta_id = :cuenta_id")
    Double obtenerSaldoInicial(@Param("cuenta_id") long cuenta_id);

    @Query("SELECT MAX(m.movimiento_id) FROM Movimiento m WHERE m.cuenta_id = :cuenta_id")
    long obtenerUltimoMovimientoId(@Param("cuenta_id") long cuenta_id);

    @Query("SELECT m FROM Movimiento m WHERE m.movimiento_id = :movimiento_id")
    Movimiento obtenerUltimoMovimiento(@Param("movimiento_id") long movimiento_id);

    //REPORTERIA
//    @Query("SELECT m.valor FROM Movimiento m, Cuenta c WHERE c.cuenta_id = m.movimiento_id AND c.cuenta_id = 1 AND m.fecha BETWEEN  AND '2025.02-27'")
//    String obtenerReporte();

    //@Query("SELECT new com.ntt_data.service003.model.Reporte(c.numero_cuenta, m.valor) FROM Movimiento m, Cuenta c WHERE c.cuenta_id = m.movimiento_id AND c.cuenta_id = 1 AND CAST(m.fecha AS date) BETWEEN :fechaInicio AND :fechaFin")
    //Reporte obtenerReporte2(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);

    @Query("SELECT new com.ntt_data.service003.model.Reporte(m.fecha,c.numero_cuenta,c.tipo,c.saldo_inicial,c.estado,m.valor,m.saldo) FROM Movimiento m, Cuenta c "
            +"WHERE c.cuenta_id = m.movimiento_id AND m.movimiento_id = 3 "
            +"AND CAST(m.fecha AS date) BETWEEN :inicio AND :fin")
    Reporte obtenerReporte3(@Param("inicio") LocalDate inicio, @Param("fin") LocalDate fin);

    @Query("SELECT new com.ntt_data.service003.model.dto.ReporteSinClienteNombreDTO( m.fecha, c.numero_cuenta, c.tipo, c.saldo_inicial, c.estado, m.valor, m.saldo, c.cliente_id)" +
            "FROM Movimiento m, Cuenta c WHERE c.cuenta_id = m.movimiento_id " +
            "AND CAST(m.fecha AS date) = :fecha")
    List<ReporteSinClienteNombreDTO> buscarMovimientosPorFecha(@Param("fecha") LocalDate fecha);

    @Query("SELECT new com.ntt_data.service003.model.dto.ReporteSinClienteNombreDTO( m.fecha, c.numero_cuenta, c.tipo, c.saldo_inicial, c.estado, m.valor, m.saldo, c.cliente_id)" +
            "FROM Movimiento m, Cuenta c WHERE c.cuenta_id = m.cuenta_id " +
            "AND CAST(m.fecha AS date) BETWEEN :inicio AND :fin")
    List<ReporteSinClienteNombreDTO> buscarMovimientosRangoFechas(@Param("inicio") LocalDate inicio, @Param("fin") LocalDate fin);

    @Query("SELECT new com.ntt_data.service003.model.dto.ReporteSinClienteNombreDTO( m.fecha, c.numero_cuenta, c.tipo, c.saldo_inicial, c.estado, m.valor, m.saldo, c.cliente_id)" +
            "FROM Movimiento m, Cuenta c WHERE c.cuenta_id = m.cuenta_id " +
            "AND m.cuenta_id IN :valores AND CAST(m.fecha AS date) BETWEEN :inicio AND :fin")
    List<ReporteSinClienteNombreDTO> buscarMovimientosRangoFechasYCliente(@Param("inicio") LocalDate inicio, @Param("fin") LocalDate fin, @Param("valores") List<Long> valores);

}

