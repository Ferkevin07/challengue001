package com.ntt_data.service002.repository;

import com.ntt_data.service002.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Cliente cliente = new Cliente(
                1252852568,"Kevin Benavides","M",27,"099-874-8264","La Argelia","123",true);
        entityManager.persist(cliente);
    }

    @Test
    public void seGenerarClienteSinProblema(){
        Optional<Cliente> cliente = clienteRepository.findById(1L);
        assertEquals(cliente.get().getNombre(), "Kevin Benavides" );
    }
}