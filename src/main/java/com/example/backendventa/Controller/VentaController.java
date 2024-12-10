package com.example.backendventa.Controller;

import com.example.backendventa.Model.Venta;
import com.example.backendventa.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping("/realizar")
    public Venta realizarVenta(@RequestParam Long productoId, @RequestParam Integer cantidad) {
        return ventaService.realizarVenta(productoId, cantidad);
    }
}