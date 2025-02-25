package com.ntt_data.service003.service;

import com.ntt_data.service003.model.dto.ReporteMovimientoDTO;
import com.ntt_data.service003.model.dto.ReporteSinClienteNombreDTO;
import com.ntt_data.service003.repository.CuentaRepository;
import com.ntt_data.service003.repository.MovimientoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
//@RequiredArgsConstructor
@Slf4j
public class ReporteService {

    private final MovimientoRepository movimientoRepository;
    private final WebClient.Builder webClientBuilder;
    private final CuentaRepository cuentaRepository;

    ReporteService(MovimientoRepository movimientoRepository, CuentaRepository cuentaRepository) {
        this.movimientoRepository = movimientoRepository;
        this.webClientBuilder = WebClient.builder();
        this.cuentaRepository = cuentaRepository;
    }

    public List<ReporteMovimientoDTO> obtenerMovimientosPorFecha(LocalDate fecha) {
        List<ReporteSinClienteNombreDTO> movimientos = movimientoRepository.buscarMovimientosPorFecha(fecha);

        log.info("Movimientos: {}", movimientos.get(0));
        log.info("Movimientos: {}", movimientos.get(1));

        List<ReporteMovimientoDTO> reporte = new ArrayList<>();

        for ( ReporteSinClienteNombreDTO reporteDTO : movimientos ) {
            Long clienteId = reporteDTO.getClienta_id();
            // Llamada al servicio de clientes para obtener el nombre
            String nombreCliente = obtenerNombreCliente(clienteId);

            ReporteMovimientoDTO dto = new ReporteMovimientoDTO(
                    reporteDTO.getFecha(),  // Fecha
                    nombreCliente,          //Nombre
                    reporteDTO.getNumeroCuenta(),     // Número de cuenta
                    reporteDTO.getTipo(),     // Tipo de cuenta
                    reporteDTO.getSaldoInicial(), // Saldo inicial
                    reporteDTO.getEstado(),     // Estado
                    reporteDTO.getValor(), // Valor
                    reporteDTO.getSaldo()// Saldo
            );

            reporte.add(dto);
            log.info("Mov"+dto);
        }

        return reporte;
    }

//    private String obtenerNombreCliente(Long clienteId) {
//        try {
//            ClienteDTO clienteDto = restTemplate.getForObject(
//                    "http://localhost:8081/clientes/" + clienteId + "/nombre",
//                    ClienteDTO.class
//            );
//            return clienteDto != null ? clienteDto.getNombre_cliente() : "Desconocido";
//        } catch (Exception e) {
//            return "Desconocido";
//        }
//    }

    public List<ReporteMovimientoDTO> obtenerMovimientosRangoFechas(LocalDate inicio, LocalDate fin) {
        List<ReporteSinClienteNombreDTO> movimientos = movimientoRepository.buscarMovimientosRangoFechas(inicio, fin);

        log.info("Movimientos: {}", movimientos.get(0));
        log.info("Movimientos: {}", movimientos.get(1));
        //log.info("Movimientos: {}", movimientos.get(2));
        log.info("Movimientos: {}", movimientos.size());

        List<ReporteMovimientoDTO> reporte = new ArrayList<>();

        for ( ReporteSinClienteNombreDTO reporteDTO : movimientos ) {
            Long clienteId = reporteDTO.getClienta_id();
            // Llamada al servicio de clientes para obtener el nombre
            String nombreCliente = obtenerNombreCliente(clienteId);

            ReporteMovimientoDTO dto = new ReporteMovimientoDTO(
                    reporteDTO.getFecha(),  // Fecha
                    nombreCliente,          //Nombre
                    reporteDTO.getNumeroCuenta(),     // Número de cuenta
                    reporteDTO.getTipo(),     // Tipo de cuenta
                    reporteDTO.getSaldoInicial(), // Saldo inicial
                    reporteDTO.getEstado(),     // Estado
                    reporteDTO.getValor(), // Valor
                    reporteDTO.getSaldo()// Saldo
            );

            reporte.add(dto);
            log.info("Mov"+dto);
        }

        return reporte;
    }

    public String obtenerNombreCliente(Long id) {
        WebClient webClient = webClientBuilder.baseUrl("http://localhost:8085/api").build();

        Map clienteDto = webClient.get()
                .uri("/clientes/nombre-cliente/"+id)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        log.info("Solicitud HTTP: "+clienteDto.get("nombre"));

        return clienteDto.get("nombre").toString();
    }

    public void testing(){
        LocalDate today = LocalDate.now();
        LocalDate todayIn = LocalDate.of(2025,2,23);
        log.info("Today: "+today);
        log.info("TodayIn: "+todayIn);
    }

    public List<ReporteMovimientoDTO> obtenerMovimientosRangoFechasYCliente(LocalDate inicio, LocalDate fin, Long id) {

        List<Long> cuentas = cuentaRepository.obtenerCuentasCliente(id);

        List<ReporteSinClienteNombreDTO> movimientos = movimientoRepository.buscarMovimientosRangoFechasYCliente(inicio, fin, cuentas);

        //log.info("Movimientos: {}", movimientos.get(0));
        //log.info("Movimientos: {}", movimientos.get(1));
        log.info("Movimientos: {}", movimientos.size());

        List<ReporteMovimientoDTO> reporte = new ArrayList<>();

        for ( ReporteSinClienteNombreDTO reporteDTO : movimientos ) {
            Long clienteId = reporteDTO.getClienta_id();
            // Llamada al servicio de clientes para obtener el nombre
            String nombreCliente = obtenerNombreCliente(clienteId);

            ReporteMovimientoDTO dto = new ReporteMovimientoDTO(
                    reporteDTO.getFecha(),  // Fecha
                    nombreCliente,          //Nombre
                    reporteDTO.getNumeroCuenta(),     // Número de cuenta
                    reporteDTO.getTipo(),     // Tipo de cuenta
                    reporteDTO.getSaldoInicial(), // Saldo inicial
                    reporteDTO.getEstado(),     // Estado
                    reporteDTO.getValor(), // Valor
                    reporteDTO.getSaldo()// Saldo
            );

            reporte.add(dto);
            log.info("Mov"+dto);
        }

        return reporte;
    }

}
