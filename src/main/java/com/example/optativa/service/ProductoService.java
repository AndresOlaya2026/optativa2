package com.example.optativa.service;

import com.example.optativa.model.Producto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class ProductoService {
    
    private final Map<Long, Producto> productos = new ConcurrentHashMap<>();
    private Long idCounter = 1L;
    
    public ProductoService() {
        // Inicializar con datos de ejemplo
        agregarProductoInicial();
    }
    
    private void agregarProductoInicial() {
        productos.put(1L, new Producto(1L, "Laptop", "Laptop de alto rendimiento", 999.99, 5));
        productos.put(2L, new Producto(2L, "Mouse", "Mouse inalámbrico", 25.50, 15));
        productos.put(3L, new Producto(3L, "Teclado", "Teclado mecánico RGB", 89.99, 8));
        productos.put(4L, new Producto(4L, "Monitor", "Monitor 4K 27 pulgadas", 349.99, 3));
        productos.put(5L, new Producto(5L, "Auriculares", "Auriculares noise cancelling", 199.99, 10));
        idCounter = 6L;
    }
    
    // Obtener todos los productos
    public List<Producto> obtenerTodos() {
        return new ArrayList<>(productos.values());
    }
    
    // Obtener un producto por ID
    public Producto obtenerPorId(Long id) {
        return productos.get(id);
    }
    
    // Crear nuevo producto
    public Producto crear(Producto producto) {
        producto.setId(idCounter++);
        productos.put(producto.getId(), producto);
        return producto;
    }
    
    // Actualizar producto
    public Producto actualizar(Long id, Producto productoActualizado) {
        if (productos.containsKey(id)) {
            productoActualizado.setId(id);
            productos.put(id, productoActualizado);
            return productoActualizado;
        }
        return null;
    }
    
    // Eliminar producto
    public boolean eliminar(Long id) {
        return productos.remove(id) != null;
    }
    
    // Búsqueda por nombre (contiene)
    public List<Producto> buscarPorNombre(String nombre) {
        return productos.values().stream()
                .filter(p -> p.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    // Obtener productos por rango de precio
    public List<Producto> obtenerPorRangoPrecio(Double precioMin, Double precioMax) {
        return productos.values().stream()
                .filter(p -> p.getPrecio() >= precioMin && p.getPrecio() <= precioMax)
                .collect(Collectors.toList());
    }
    
    // Obtener productos disponibles (cantidad > 0)
    public List<Producto> obtenerDisponibles() {
        return productos.values().stream()
                .filter(p -> p.getCantidad() > 0)
                .collect(Collectors.toList());
    }
}

