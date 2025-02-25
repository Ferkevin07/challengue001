package com.ntt_data.service002.controller;

import com.ntt_data.service002.model.Cliente;
import com.ntt_data.service002.model.dto.ClienteRequest;
import com.ntt_data.service002.repository.ClienteRepository;
import com.ntt_data.service002.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private final ClienteRepository clienteRepository;
    private final ClienteService clienteService;

    ClienteController(ClienteRepository clienteRepository, ClienteService clienteService) {
        this.clienteRepository = clienteRepository;
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> obtenerTodosClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/nombre-cliente/{id}")
    public ResponseEntity<Map<String, String>> obtenerNombreCliente(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(cliente -> ResponseEntity.ok(Collections.singletonMap("nombre", cliente.getNombre())))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Collections.singletonMap("error", "Cliente no encontrado")));
    }

    @GetMapping("/cuentas-cliente/{id}")
    public ResponseEntity<Map<String, String>> obtenerCuentasCliente(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(cliente -> ResponseEntity.ok(Collections.singletonMap("nombre", cliente.getNombre())))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Collections.singletonMap("error", "Cliente no encontrado")));
    }

//    @GetMapping("/conseguir/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public String conseguirClienteNombre(@PathVariable Long id) {
//        String nombre = clienteService.obtenerNombreCliente(id);
//        return "OK";
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente guardarCliente(@RequestBody ClienteRequest clienteRequest) {
        Cliente nuevoCliente = clienteService.crearCliente(clienteRequest);
        return nuevoCliente;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteRequest actualizarCliente(@PathVariable Long id, @RequestBody ClienteRequest clienteRequest) {
        Cliente cliente = clienteService.actualizarCliente(id, clienteRequest);
        return clienteRequest;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void borrarCliente(@PathVariable Long id) {
        clienteService.borrarCliente(id);
    }
}
