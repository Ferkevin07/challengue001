package com.ntt_data.service003.controller;

import com.ntt_data.service003.model.Reporte;
import com.ntt_data.service003.repository.MovimientoRepository;
import com.ntt_data.service003.service.MovimientoService;
import com.ntt_data.service003.service.ReporteService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("reportes")
public class ReporteController {

//    private  ReporteRepository reporteRepository;
//
//    public ReporteController(ReporteRepository reporteRepository) {
//        this.reporteRepository = reporteRepository;
//    }

    private final ReporteService reporteService;
    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }


    @GetMapping
    public String recibirFechas(
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate inicio = LocalDate.parse(fechaInicio, formatter);
            LocalDate fin = LocalDate.parse(fechaFin, formatter);



            //return "Fecha de inicio: " + inicio + ", Fecha de fin: " + fin + " // " +reporte;
        } catch (Exception e) {
            //return "Error: Formato de fecha inválido. Use 'yyyy-MM-dd'.";
        }

        reporteService.obtenerReporte();

        return "OK";
    }

    @GetMapping("obtener")
    public String test() {
        //reporteRepository.obtenerReporte(LocalDate )
        return "test";
    }
}
