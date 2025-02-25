package com.ntt_data.service003;

import com.ntt_data.service003.model.Cuenta;
import com.ntt_data.service003.model.CuentaRequest;
import com.ntt_data.service003.model.Movimiento;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootApplication
public class Service003Application {

	public static void main(String[] args) {
		SpringApplication.run(Service003Application.class, args);
	}

}



//	@PostMapping
//	@Transactional
//	public Cuenta crearCuenta(@RequestBody CuentaRequest cuenta) {
//		// Guardamos la cuenta en la base de datos
//		//Cuenta nuevaCuenta = cuentaRepository.save(cuenta);
//
//		Cuenta newCount = new Cuenta(cuenta.getNumero_cuenta(),cuenta.getTipo(), cuenta.getSaldo_inicial(),cuenta.getEstado(),cuenta.getCliente_id());
//
//		// Retornamos el ID generado de la cuenta
//		//cuentaRepository.save(newCount);
//
//		entityManager.persist(newCount);
//
//		return newCount;
//	}


//EXCEPTIONS




