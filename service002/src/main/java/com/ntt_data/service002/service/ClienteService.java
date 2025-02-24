package com.ntt_data.service002.service;

import com.ntt_data.service002.model.Cliente;
import com.ntt_data.service002.model.dto.ClienteRequest;
import com.ntt_data.service002.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ClienteService {

    private final ClienteRepository clienteRepository;

    ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente crearCliente(ClienteRequest clienteRequest){
        Cliente cliente = new Cliente(
                clienteRequest.getIdentificacion(),
                clienteRequest.getNombre(),
                clienteRequest.getGenero(),
                clienteRequest.getEdad(),
                clienteRequest.getTelefono(),
                clienteRequest.getDireccion(),
                clienteRequest.getContrasena(),
                clienteRequest.getEstado()
        );

        log.info("Creando Cliente"+cliente.getIdentificacion());
        log.info("Creando Cliente"+cliente.getCliente_id());
        log.info("Creando Cliente"+clienteRequest);

        clienteRepository.save(cliente);

        return cliente;
    }

    @Transactional
    public Cliente actualizarCliente(Long id,ClienteRequest clienteRequest){
        Cliente cliente = new Cliente(
                clienteRequest.getIdentificacion(),
                clienteRequest.getNombre(),
                clienteRequest.getGenero(),
                clienteRequest.getEdad(),
                clienteRequest.getTelefono(),
                clienteRequest.getDireccion(),
                clienteRequest.getContrasena(),
                clienteRequest.getEstado()
        );
        cliente.setCliente_id(id);

        log.info("Creando Cliente"+cliente.getIdentificacion());
        log.info("Creando Cliente"+cliente.getCliente_id());
        log.info("Creando Cliente"+clienteRequest);

        clienteRepository.save(cliente);

        return cliente;
    }

    @Transactional
    public void borrarCliente(Long id){
        log.info("Borrado Cliente"+id);
        clienteRepository.deleteById(id);
    }

    @Transactional
    public String other(Long id){
        String nombreCliente = clienteRepository.obtenerNombreCliente(id);
        log.info("Borrado Cliente"+nombreCliente);
        Optional<Cliente> cliente = clienteRepository.findById(id);
        log.info("Borrado Cliente"+cliente.get().getNombre());
        String nombre = cliente.get().getNombre();
        return nombre;
    }
}
