package com.ntt_data.service003.service;

import com.ntt_data.service003.model.Movimiento;
import com.ntt_data.service003.model.MovimientoRequest;
import com.ntt_data.service003.model.dto.ReporteMovimientoDTO;
import com.ntt_data.service003.repository.MovimientoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
@Slf4j
public class MovimientoService {

    private final MovimientoRepository movimientoRepository;

    private RestTemplate restTemplate;

    MovimientoService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    @Transactional
    public Movimiento crearMovimiento(MovimientoRequest movimientoRequest){
        long accountId = movimientoRequest.getCuenta_id();
        long countMovements = movimientoRepository.contarMovimientosCuenta(accountId);
        double saldoFinal;
        if(countMovements == 0){
            double saldoInicial = movimientoRepository.obtenerSaldoInicial(accountId);
            log.info("Saldo Inicial: " + saldoInicial);
            saldoFinal = saldoInicial + movimientoRequest.getValor();
            log.info("Saldo Final: " + saldoFinal);

        }else{
            long lastMovementId = movimientoRepository.obtenerUltimoMovimientoId(accountId);
            Movimiento ultimoMovimiento = movimientoRepository.obtenerUltimoMovimiento(lastMovementId);
            double ultimoValor = ultimoMovimiento.getSaldo();
            saldoFinal = ultimoValor + movimientoRequest.getValor();

            log.info(String.valueOf(countMovements));
            log.info("Ultimo mov: " + ultimoMovimiento);
        }
        Movimiento movimiento = new Movimiento(
                movimientoRequest.getTipo(),
                movimientoRequest.getFecha(),
                movimientoRequest.getValor(),
                saldoFinal,
                movimientoRequest.getCuenta_id()
        );

        if(saldoFinal >= 0){
            movimientoRepository.save(movimiento);
            log.info("Movimiento creado");
        }else {
            log.info("Movimiento NO CREADO");
        }

        log.info(String.valueOf(accountId)+" Numero de movimientos");

        return movimiento;
    }

    public List<Movimiento> mostrarMovimientos(){
        return movimientoRepository.findAll();
    }

    public Optional<Movimiento> mostrarMovimiento(Long id){
        return movimientoRepository.findById(id);
    }

}
