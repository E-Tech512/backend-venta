package com.example.backendventa.Controller;

import com.example.backendventa.Model.Producto;
import com.example.backendventa.Service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entradas")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @PostMapping("/realizar")
    public Producto realizarEntrada(@RequestParam Long productoId, @RequestParam Integer cantidad) {
        return entradaService.realizarEntrada(productoId, cantidad);
    }
}