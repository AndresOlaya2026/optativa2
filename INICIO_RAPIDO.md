# 🚀 GUÍA RÁPIDA DE INICIO

## ¿Qué es esto?

Una **API REST** completa con:
- ✅ Java 17
- ✅ Spring Boot 4.0.3
- ✅ Gestión de productos
- ✅ Datos en memoria
- ✅ CRUD completo (Crear, Leer, Actualizar, Eliminar)

---

## 1️⃣ EJECUTAR LA APLICACIÓN

### Opción A: Usar el script (recomendado para Windows)
```bash
doble-clic en ejecutar.bat
```

### Opción B: Usar Maven directamente
```bash
mvn spring-boot:run
```

### Opción C: Compilar y ejecutar el JAR
```bash
mvn clean package
java -jar target/optativa-0.0.1-SNAPSHOT.jar
```

**Resultado esperado:**
```
La aplicación estará disponible en: http://localhost:8080
```

---

## 2️⃣ PROBAR LA API

### Opción A: Usar el script de prueba (Windows)
```bash
doble-clic en test_api.bat
```

### Opción B: Usar cURL manualmente

**Ver todos los productos:**
```bash
curl http://localhost:8080/api/productos
```

**Crear un nuevo producto:**
```bash
curl -X POST http://localhost:8080/api/productos \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Monitor Gamer",
    "descripcion": "Monitor 144Hz",
    "precio": 299.99,
    "cantidad": 5
  }'
```

**Actualizar un producto:**
```bash
curl -X PUT http://localhost:8080/api/productos/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Laptop Actualizada",
    "descripcion": "Nueva descripción",
    "precio": 1099.99,
    "cantidad": 3
  }'
```

**Eliminar un producto:**
```bash
curl -X DELETE http://localhost:8080/api/productos/3
```

### Opción C: Usar Postman
1. Descargar Postman: https://www.postman.com/downloads/
2. Crear una nueva solicitud
3. Seleccionar el método HTTP (GET, POST, etc.)
4. Ingresar la URL: `http://localhost:8080/api/productos`
5. Para POST/PUT: Ir a "Body" → seleccionar "raw" → elegir "JSON"
6. Enviar la solicitud

---

## 3️⃣ ENDPOINTS PRINCIPALES

| Método | URL | Descripción |
|--------|-----|-------------|
| GET | `/api/productos` | Obtener todos |
| GET | `/api/productos/{id}` | Obtener uno |
| POST | `/api/productos` | Crear |
| PUT | `/api/productos/{id}` | Actualizar |
| DELETE | `/api/productos/{id}` | Eliminar |
| GET | `/api/productos/buscar/nombre?nombre=X` | Buscar por nombre |
| GET | `/api/productos/filtro/precio?min=X&max=Y` | Filtrar por precio |
| GET | `/api/productos/disponibles` | Solo disponibles |

---

## 4️⃣ DATOS INICIALES

La API viene con 5 productos pre-cargados:

```
ID | Nombre      | Precio   | Cantidad
---|-------------|----------|----------
1  | Laptop      | 999.99   | 5
2  | Mouse       | 25.50    | 15
3  | Teclado     | 89.99    | 8
4  | Monitor     | 349.99   | 3
5  | Auriculares | 199.99   | 10
```

---

## 5️⃣ ESTRUCTURA DEL PROYECTO

```
src/main/java/com/example/optativa/
├── OptativaApplication.java          ← Aplicación principal
├── model/
│   └── Producto.java                 ← Modelo de datos
├── service/
│   └── ProductoService.java          ← Lógica de negocio
└── controller/
    └── ProductoController.java       ← Endpoints REST
```

---

## 6️⃣ REQUISITOS

- ✅ Java 17 instalado
- ✅ Maven instalado
- ✅ Conexión a internet (primera ejecución descarga dependencias)

**Verificar Java:**
```bash
java -version
```

**Verificar Maven:**
```bash
mvn -version
```

---

## 7️⃣ SOLUCIÓN DE PROBLEMAS

### Error: "Puerto 8080 ya en uso"
Cambiar el puerto en `src/main/resources/application.properties`:
```properties
server.port=8081
```

### Error: "Java 17 no encontrado"
Asegúrate de tener Java 17 instalado. En Windows, verifica:
```bash
java -version
```

### Error: "Maven no encontrado"
Instala Maven desde: https://maven.apache.org/download.cgi

---

## 8️⃣ DOCUMENTACIÓN COMPLETA

Ver el archivo: **API_DOCUMENTATION.md**

---

## ❓ PREGUNTAS FRECUENTES

**P: ¿Los datos se guardan permanentemente?**
R: No, los datos se almacenan en memoria. Al reiniciar, se pierden.

**P: ¿Cómo agrego más funcionalidades?**
R: Edita `ProductoService.java` para lógica y `ProductoController.java` para endpoints.

**P: ¿Puedo usar una base de datos?**
R: Sí, puedes cambiar el servicio para usar JPA/Hibernate y una BD real.

---

**¡Listo! Ya tienes tu API REST funcionando. ¡Bienvenido! 🎉**

