package com.ntt_data.service003.controller;

import com.ntt_data.service003.exception.*;
import com.ntt_data.service003.model.Movimiento;
import com.ntt_data.service003.model.MovimientoRequest;
import com.ntt_data.service003.repository.MovimientoRepository;
import com.ntt_data.service003.service.MovimientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("movimientos")
public class MovimientoController {

//    private MovimientoRepository movimientoRepository;
//
//    MovimientoController(MovimientoRepository movimientoRepository) {
//        this.movimientoRepository = movimientoRepository;
//    }

    private final MovimientoService movimientoService;
    MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @GetMapping("test")
    public String test() {
        return "test";
    }

    @GetMapping
    public List<Movimiento> test2(){
//        List<Movimiento> movimientos = movimientoRepository.count();
//        System.out.println("Usuarios en la BD: " + movimientos.size());
//        movimientos.forEach(System.out::println);
        return movimientoService.mostrarMovimientos();
    }

    @GetMapping("/{id}")
    public Optional<Movimiento> getClienteById(@PathVariable Long id) {
        return movimientoService.mostrarMovimiento(id);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Movimiento> crearMovimiento(@RequestBody MovimientoRequest movimientoRequest) {
        Movimiento m = movimientoService.crearMovimiento(movimientoRequest);
        if (m.getSaldo() < 0) {
            throw new MovimientoException("Saldo no disponible");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(m);
    }

//    @PutMapping("/{id}")
//    public Movimiento updateCliente(@PathVariable String id, @RequestBody Movimiento movimiento) {
//        movimiento.setMovimiento_id(id);
//        return movimientoRepository.save(movimiento);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteCliente(@PathVariable String id) {
//        movimientoRepository.deleteById(id);
//    }
}
