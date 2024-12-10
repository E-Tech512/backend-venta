package com.example.backendventa.Controller;

import com.example.backendventa.Model.EntradaSalida;
import com.example.backendventa.Model.Producto;
import com.example.backendventa.Model.Venta;
import com.example.backendventa.Service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entradas")
@CrossOrigin(origins = "http://localhost:4200")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @PostMapping("/realizar")
    public Producto realizarEntrada(@RequestParam Long productoId, @RequestParam Integer cantidad) {
        return entradaService.realizarEntrada(productoId, cantidad);
    }

    @GetMapping("/realizar")
    public List<EntradaSalida> listarEntradas() {
        return entradaService.listarEntradas();
    }
}