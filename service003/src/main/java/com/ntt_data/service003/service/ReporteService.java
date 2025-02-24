package com.ntt_data.service003.service;

import com.ntt_data.service003.model.Reporte;
import com.ntt_data.service003.repository.MovimientoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;

@Service
//@RequiredArgsConstructor
@Slf4j
public class ReporteService {

    private final MovimientoRepository movimientoRepository;

    private final WebClient.Builder webClientBuilder;

    ReporteService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
        this.webClientBuilder = WebClient.builder();
    }

    public void obtenerReporte() {

        WebClient webClient = webClientBuilder.baseUrl("http://localhost:8085/api").build();

        String result = webClient.get()
                .uri("/clientes/nombre-cliente/5")
                //.header("Accept", "application/json")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        log.info("Solicitud HTTP: "+result);

        LocalDate fecha = LocalDate.now();
        LocalDate fechaInicio = fecha.minusDays(1);
        Reporte cuentaNum = movimientoRepository.obtenerReporte3(fechaInicio,fecha);

        log.info("Reporte: "+cuentaNum.toString());

    }
}
