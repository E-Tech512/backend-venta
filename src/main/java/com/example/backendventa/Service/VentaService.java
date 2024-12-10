package com.example.backendventa.Service;

import com.example.backendventa.Model.EntradaSalida;
import com.example.backendventa.Model.Producto;
import com.example.backendventa.Model.Venta;
import com.example.backendventa.Repository.EntradaSalidaRepository;
import com.example.backendventa.Repository.ProductoRepository;
import com.example.backendventa.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private EntradaSalidaRepository entradaSalidaRepository;

    public Venta realizarVenta(Long productoId, Integer cantidad) {
        Optional<Producto> productoOpt = productoRepository.findById(productoId);
        if (productoOpt.isPresent()) {
            Producto producto = productoOpt.get();
            if (producto.getCantidad() >= cantidad) {
                producto.setCantidad(producto.getCantidad() - cantidad);
                productoRepository.save(producto);

                Venta venta = new Venta(productoId, cantidad, LocalDateTime.now());
                ventaRepository.save(venta);

                EntradaSalida entradaSalida = new EntradaSalida(productoId, cantidad, "salida", LocalDateTime.now());
                entradaSalidaRepository.save(entradaSalida);

                return venta;
            } else {
                throw new RuntimeException("Stock insuficiente");
            }
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }

    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

}