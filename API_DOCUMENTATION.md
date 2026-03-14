# API REST - Gestión de Productos

API REST construida con **Java 17** y **Spring Boot 4.0.3** que gestiona productos con datos almacenados en memoria.

## Características

✅ CRUD completo (Crear, Leer, Actualizar, Eliminar)
✅ Datos almacenados en memoria (ConcurrentHashMap)
✅ Búsqueda por nombre
✅ Filtrado por rango de precio
✅ Listado de productos disponibles
✅ Respuestas JSON

## Tecnologías

- **Java 17**
- **Spring Boot 4.0.3**
- **Spring Web MVC**
- **Lombok** (para reducir código boilerplate)
- **Maven**

## Instalación y Ejecución

### Compilar el proyecto
```bash
mvn clean compile
```

### Ejecutar la aplicación
```bash
mvn spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

## Endpoints de la API

### 1. Obtener todos los productos
**Método:** `GET`
**URL:** `/api/productos`
**Respuesta:** Lista de todos los productos

```bash
curl http://localhost:8080/api/productos
```

### 2. Obtener un producto por ID
**Método:** `GET`
**URL:** `/api/productos/{id}`
**Parámetros:** 
- `id` (en la URL): ID del producto

```bash
curl http://localhost:8080/api/productos/1
```

### 3. Crear un nuevo producto
**Método:** `POST`
**URL:** `/api/productos`
**Body (JSON):**
```json
{
  "nombre": "Producto Nuevo",
  "descripcion": "Descripción del producto",
  "precio": 99.99,
  "cantidad": 10
}
```

```bash
curl -X POST http://localhost:8080/api/productos \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Webcam",
    "descripcion": "Webcam 1080p",
    "precio": 49.99,
    "cantidad": 7
  }'
```

### 4. Actualizar un producto
**Método:** `PUT`
**URL:** `/api/productos/{id}`
**Parámetros:**
- `id` (en la URL): ID del producto a actualizar
**Body (JSON):** Datos del producto actualizado

```bash
curl -X PUT http://localhost:8080/api/productos/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Laptop Actualizada",
    "descripcion": "Laptop de alto rendimiento mejorada",
    "precio": 1099.99,
    "cantidad": 4
  }'
```

### 5. Eliminar un producto
**Método:** `DELETE`
**URL:** `/api/productos/{id}`
**Parámetros:**
- `id` (en la URL): ID del producto a eliminar

```bash
curl -X DELETE http://localhost:8080/api/productos/3
```

### 6. Buscar productos por nombre
**Método:** `GET`
**URL:** `/api/productos/buscar/nombre?nombre={nombre}`
**Parámetros:**
- `nombre`: Parte del nombre a buscar (búsqueda parcial, no sensible a mayúsculas)

```bash
curl "http://localhost:8080/api/productos/buscar/nombre?nombre=mouse"
```

### 7. Filtrar por rango de precio
**Método:** `GET`
**URL:** `/api/productos/filtro/precio?min={min}&max={max}`
**Parámetros:**
- `min`: Precio mínimo
- `max`: Precio máximo

```bash
curl "http://localhost:8080/api/productos/filtro/precio?min=50&max=200"
```

### 8. Obtener productos disponibles
**Método:** `GET`
**URL:** `/api/productos/disponibles`
**Respuesta:** Lista de productos con cantidad > 0

```bash
curl http://localhost:8080/api/productos/disponibles
```

## Datos de Ejemplo (Iniciales)

La API viene precargada con 5 productos:

| ID | Nombre | Descripción | Precio | Cantidad |
|----|--------|-------------|--------|----------|
| 1 | Laptop | Laptop de alto rendimiento | 999.99 | 5 |
| 2 | Mouse | Mouse inalámbrico | 25.50 | 15 |
| 3 | Teclado | Teclado mecánico RGB | 89.99 | 8 |
| 4 | Monitor | Monitor 4K 27 pulgadas | 349.99 | 3 |
| 5 | Auriculares | Auriculares noise cancelling | 199.99 | 10 |

## Estructura del Proyecto

```
src/main/java/com/example/optativa/
├── OptativaApplication.java          # Clase principal
├── model/
│   └── Producto.java                 # Entidad Producto
├── service/
│   └── ProductoService.java          # Lógica de negocio
└── controller/
    └── ProductoController.java       # Endpoints REST
```

## Códigos de Estado HTTP

| Código | Significado |
|--------|-------------|
| 200 | OK - Solicitud exitosa |
| 201 | Created - Recurso creado exitosamente |
| 204 | No Content - Recurso eliminado exitosamente |
| 400 | Bad Request - Solicitud inválida |
| 404 | Not Found - Recurso no encontrado |
| 500 | Internal Server Error - Error en el servidor |

## Notas Importantes

- **Datos en Memoria:** Los datos se almacenan en memoria, por lo que se pierden cuando se reinicia la aplicación.
- **Thread-Safe:** Se utiliza `ConcurrentHashMap` para garantizar seguridad en entornos multihilo.
- **Generación de IDs:** Los IDs se generan automáticamente de forma secuencial.
- **CORS Habilitado:** La API permite solicitudes desde cualquier origen.

## Ejemplo de Uso Completo

```bash
# 1. Obtener todos los productos
curl http://localhost:8080/api/productos

# 2. Obtener un producto específico
curl http://localhost:8080/api/productos/1

# 3. Crear un nuevo producto
curl -X POST http://localhost:8080/api/productos \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "SSD",
    "descripcion": "Disco SSD 1TB",
    "precio": 129.99,
    "cantidad": 12
  }'

# 4. Buscar productos
curl "http://localhost:8080/api/productos/buscar/nombre?nombre=disco"

# 5. Filtrar por precio
curl "http://localhost:8080/api/productos/filtro/precio?min=100&max=500"

# 6. Ver disponibles
curl http://localhost:8080/api/productos/disponibles

# 7. Actualizar producto
curl -X PUT http://localhost:8080/api/productos/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Laptop Pro",
    "descripcion": "Laptop profesional",
    "precio": 1299.99,
    "cantidad": 3
  }'

# 8. Eliminar producto
curl -X DELETE http://localhost:8080/api/productos/6
```

## Uso en Postman

1. Importa los endpoints en Postman
2. Configura las solicitudes con los métodos HTTP adecuados
3. Establece los headers necesarios (`Content-Type: application/json` para POST/PUT)
4. Prueba la API

## Desarrollo Futuro

Posibles mejoras:
- Persistencia en base de datos (JPA/Hibernate)
- Autenticación y autorización
- Validación de datos más robusta
- Documentación Swagger/OpenAPI
- Pruebas unitarias e integración
- Manejo de excepciones personalizado
- Paginación en listados

---

**Autor:** Optativa 2 - Calidad de Software
**Versión:** 1.0.0
**Fecha:** 2026-03-12

