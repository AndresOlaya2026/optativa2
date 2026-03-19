package com.example.optativa.service;

import com.example.optativa.model.Producto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoServiceTest {

    @Test
    void testCrearProducto() {
        ProductoService service = new ProductoService();

        Producto nuevo = new Producto(null, "Celular", "Celular gama alta", 1200.0, 10);

        Producto esperado = new Producto(6L, "Celular", "Celular gama alta", 1200.0, 10);
        Producto actual = service.crear(nuevo);

        // Validaciones
        assertNotNull(actual.getId()); // se asigna ID
        assertEquals(esperado, actual);
    }

    @Test
    void testObtenerPorId() {
        ProductoService service = new ProductoService();

        Producto producto = service.obtenerPorId(1L);

        assertNotNull(producto);
        assertEquals("Laptop", producto.getNombre());
    }

    @Test
    void testEliminarProducto() {
        ProductoService service = new ProductoService();

        boolean eliminado = service.eliminar(1L);

        assertTrue(eliminado);
        assertNull(service.obtenerPorId(1L)); // ya no existe
    }

    @Test
    void testBuscarPorNombre() {
        ProductoService service = new ProductoService();

        List<Producto> resultados = service.buscarPorNombre("lap");

        assertFalse(resultados.isEmpty());
        assertEquals("Laptop", resultados.get(0).getNombre());
    }

    @Test
    void testObtenerDisponibles() {
        ProductoService service = new ProductoService();

        List<Producto> disponibles = service.obtenerDisponibles();

        assertFalse(disponibles.isEmpty());

        // todos deben tener cantidad > 0
        for (Producto p : disponibles) {
            assertTrue(p.getCantidad() > 0);
        }
    }

    @Test
    void testActualizarProducto() {
        ProductoService service = new ProductoService();

        Producto actualizado = new Producto(null, "Laptop Pro", "Mejorada", 1500.0, 3);

        Producto resultado = service.actualizar(1L, actualizado);

        assertNotNull(resultado);
        assertEquals("Laptop Pro", resultado.getNombre());
        assertEquals(1500.0, resultado.getPrecio());
    }

    @Test
    void testObtenerPorRangoPrecio() {
        ProductoService service = new ProductoService();

        List<Producto> productos = service.obtenerPorRangoPrecio(50.0, 1000.0);

        assertFalse(productos.isEmpty());

        for (Producto p : productos) {
            assertTrue(p.getPrecio() >= 50.0 && p.getPrecio() <= 1000.0);
        }
    }
}