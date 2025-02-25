package com.ntt_data.service003.service;

import com.ntt_data.service003.model.Cuenta;
import com.ntt_data.service003.repository.CuentaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public List<Long> obtenerCuentasCliente(Long id) {
        List<Long> cuentas = cuentaRepository.obtenerCuentasCliente(id);
        return cuentas;
    }
}
