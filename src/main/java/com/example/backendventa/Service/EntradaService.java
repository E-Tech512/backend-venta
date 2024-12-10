package com.example.backendventa.Service;

import com.example.backendventa.Model.EntradaSalida;
import com.example.backendventa.Model.Producto;
import com.example.backendventa.Repository.EntradaSalidaRepository;
import com.example.backendventa.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EntradaService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private EntradaSalidaRepository entradaSalidaRepository;

    public Producto realizarEntrada(Long productoId, Integer cantidad) {
        Optional<Producto> productoOpt = productoRepository.findById(productoId);
        if (productoOpt.isPresent()) {
            Producto producto = productoOpt.get();
            producto.setCantidad(producto.getCantidad() + cantidad);
            productoRepository.save(producto);

            EntradaSalida entrada = new EntradaSalida(productoId, cantidad, "entrada", LocalDateTime.now());
            entradaSalidaRepository.save(entrada);

            return producto;
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }
}