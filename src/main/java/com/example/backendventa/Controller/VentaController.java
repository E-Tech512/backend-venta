package com.example.backendventa.Controller;

import com.example.backendventa.Model.Venta;
import com.example.backendventa.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = "http://localhost:4200")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping("/realizar")
    public Venta realizarVenta(@RequestParam Long productoId, @RequestParam Integer cantidad) {
        return ventaService.realizarVenta(productoId, cantidad);
    }

    @GetMapping("/realizar")
    public List<Venta> listarVentas() {
        return ventaService.listarVentas();
    }
}