package com.example.backendventa.Service;

import com.example.backendventa.Model.Producto;
import com.example.backendventa.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto crearProducto(Producto producto) {
        // Verificar si el producto ya existe por nombre o algún otro campo único
        if (productoRepository.existsByNombre(producto.getNombre())) {
            throw new RuntimeException("Producto ya existe");
        }

        return productoRepository.save(producto);
    }
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public void eliminarProducto(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }
}