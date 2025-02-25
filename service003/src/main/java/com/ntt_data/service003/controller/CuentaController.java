package com.ntt_data.service003.controller;

import com.ntt_data.service003.model.Cuenta;
import com.ntt_data.service003.model.CuentaRequest;
import com.ntt_data.service003.repository.CuentaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cuentas")
public class CuentaController {

    private final CuentaRepository cuentaRepository;

//    @Autowired
//    private EntityManager entityManager;

    CuentaController(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @GetMapping
    public List<Cuenta> test() {
        return cuentaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cuenta crearCuenta(@RequestBody CuentaRequest cuentaRequest) {
        Cuenta cuenta = new Cuenta(cuentaRequest.getNumero_cuenta(), cuentaRequest.getTipo(), cuentaRequest.getSaldo_inicial(), cuentaRequest.getEstado(), cuentaRequest.getCliente_id());
        //cuentaRepository.save(cuenta);
        cuentaRepository.save(cuenta);

        return cuenta;
    }

}
