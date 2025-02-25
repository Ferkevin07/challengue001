package com.ntt_data.service003.controller;

import com.ntt_data.service003.exception.RequestException;
import com.ntt_data.service003.model.Reporte;
import com.ntt_data.service003.model.dto.ReporteMovimientoDTO;
import com.ntt_data.service003.repository.MovimientoRepository;
import com.ntt_data.service003.service.MovimientoService;
import com.ntt_data.service003.service.ReporteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("reportes")
public class ReporteController {

    private final ReporteService reporteService;
    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    public String recibirFechas(@RequestParam String fechaInicio, @RequestParam String fechaFin) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate inicio = LocalDate.parse(fechaInicio, formatter);
            LocalDate fin = LocalDate.parse(fechaFin, formatter);
            return "Fecha de inicio: " + inicio + ", Fecha de fin: " + fin + " // ";
        } catch (Exception e) {
            return "Error: Formato de fecha inválido. Use 'yyyy-MM-dd'.";
        }
    }

    @GetMapping()
    public List<ReporteMovimientoDTO> extraerMovimientos(@RequestParam String fechaInicio, @RequestParam String fechaFin) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate inicio = LocalDate.parse(fechaInicio, formatter);
            LocalDate fin = LocalDate.parse(fechaFin, formatter);

            List<ReporteMovimientoDTO> listaMovimientos = reporteService.obtenerMovimientosRangoFechas(inicio, fin);

            return listaMovimientos;
        } catch (Exception e) {
            throw new RequestException(e.toString());
        }
    }

    @GetMapping("/cliente")
    public List<ReporteMovimientoDTO> extraerMovimientosCliente(@RequestParam String fechaInicio,
                                                                @RequestParam String fechaFin,
                                                                @RequestParam Long clienteId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate inicio = LocalDate.parse(fechaInicio, formatter);
            LocalDate fin = LocalDate.parse(fechaFin, formatter);

            List<ReporteMovimientoDTO> listaMovimientos = reporteService.obtenerMovimientosRangoFechasYCliente(inicio, fin, clienteId);

            return listaMovimientos;
        } catch (Exception e) {
            throw new RequestException(e.toString());
        }
    }

    @GetMapping("reporting")
    @ResponseStatus(HttpStatus.OK)
    public List<ReporteMovimientoDTO> reporting() {
        LocalDate today = LocalDate.of(2025,2,23);
        //reporteService.obtenerMovimientosPorFecha(today);
        //reporteService.obtenerNombreCliente(5L);
        reporteService.testing();
        List<ReporteMovimientoDTO> listaMovimientos = reporteService.obtenerMovimientosPorFecha(today);
        return listaMovimientos;
    }
}
