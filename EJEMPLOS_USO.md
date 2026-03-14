# Ejemplos de Uso de la API

## 1. cURL (Línea de Comandos)

### GET - Obtener todos los productos
```bash
curl http://localhost:8080/api/productos
```

### GET - Obtener un producto específico
```bash
curl http://localhost:8080/api/productos/1
```

### POST - Crear un nuevo producto
```bash
curl -X POST http://localhost:8080/api/productos \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Disco Duro",
    "descripcion": "Disco Duro 2TB",
    "precio": 89.99,
    "cantidad": 12
  }'
```

### PUT - Actualizar un producto
```bash
curl -X PUT http://localhost:8080/api/productos/2 \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Mouse Pro",
    "descripcion": "Mouse inalámbrico profesional",
    "precio": 35.00,
    "cantidad": 20
  }'
```

### DELETE - Eliminar un producto
```bash
curl -X DELETE http://localhost:8080/api/productos/5
```

---

## 2. JavaScript / Fetch API

```javascript
const BASE_URL = 'http://localhost:8080/api/productos';

// GET - Obtener todos
fetch(BASE_URL)
  .then(response => response.json())
  .then(data => console.log(data));

// GET - Obtener uno
fetch(`${BASE_URL}/1`)
  .then(response => response.json())
  .then(data => console.log(data));

// POST - Crear
fetch(BASE_URL, {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify({
    nombre: 'Teclado Mecánico',
    descripcion: 'Teclado RGB',
    precio: 120.00,
    cantidad: 5
  })
})
.then(response => response.json())
.then(data => console.log('Creado:', data));

// PUT - Actualizar
fetch(`${BASE_URL}/1`, {
  method: 'PUT',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify({
    nombre: 'Laptop Gaming',
    descripcion: 'Laptop para gaming',
    precio: 1499.99,
    cantidad: 2
  })
})
.then(response => response.json())
.then(data => console.log('Actualizado:', data));

// DELETE - Eliminar
fetch(`${BASE_URL}/3`, { method: 'DELETE' })
  .then(response => console.log('Eliminado'));

// GET - Buscar por nombre
fetch(`${BASE_URL}/buscar/nombre?nombre=mouse`)
  .then(response => response.json())
  .then(data => console.log('Búsqueda:', data));

// GET - Filtrar por precio
fetch(`${BASE_URL}/filtro/precio?min=50&max=200`)
  .then(response => response.json())
  .then(data => console.log('Filtrado:', data));

// GET - Disponibles
fetch(`${BASE_URL}/disponibles`)
  .then(response => response.json())
  .then(data => console.log('Disponibles:', data));
```

---

## 3. Python (Requests)

```python
import requests
import json

BASE_URL = 'http://localhost:8080/api/productos'
headers = {'Content-Type': 'application/json'}

# GET - Obtener todos
response = requests.get(BASE_URL)
print(response.json())

# GET - Obtener uno
response = requests.get(f'{BASE_URL}/1')
print(response.json())

# POST - Crear
producto = {
    'nombre': 'Monitor 144Hz',
    'descripcion': 'Monitor gaming',
    'precio': 299.99,
    'cantidad': 4
}
response = requests.post(BASE_URL, json=producto, headers=headers)
print('Creado:', response.json())

# PUT - Actualizar
producto_actualizado = {
    'nombre': 'Monitor 240Hz',
    'descripcion': 'Monitor gaming ultra rápido',
    'precio': 399.99,
    'cantidad': 3
}
response = requests.put(f'{BASE_URL}/1', json=producto_actualizado, headers=headers)
print('Actualizado:', response.json())

# DELETE - Eliminar
response = requests.delete(f'{BASE_URL}/2')
print('Estado:', response.status_code)

# GET - Buscar por nombre
response = requests.get(f'{BASE_URL}/buscar/nombre?nombre=mouse')
print('Búsqueda:', response.json())

# GET - Filtrar por precio
response = requests.get(f'{BASE_URL}/filtro/precio?min=50&max=200')
print('Filtrado:', response.json())

# GET - Disponibles
response = requests.get(f'{BASE_URL}/disponibles')
print('Disponibles:', response.json())
```

---

## 4. C# (.NET)

```csharp
using System;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json;

class Program
{
    private static readonly string BASE_URL = "http://localhost:8080/api/productos";
    private static readonly HttpClient client = new HttpClient();

    static async Task Main()
    {
        // GET - Obtener todos
        var productos = await GetTodos();
        Console.WriteLine(productos);

        // GET - Obtener uno
        var producto = await GetPorId(1);
        Console.WriteLine(producto);

        // POST - Crear
        var nuevoProducto = new
        {
            nombre = "Tablet",
            descripcion = "Tablet 10 pulgadas",
            precio = 249.99,
            cantidad = 6
        };
        var creado = await Crear(nuevoProducto);
        Console.WriteLine("Creado: " + creado);

        // PUT - Actualizar
        var actualizado = new
        {
            nombre = "Tablet Pro",
            descripcion = "Tablet profesional",
            precio = 349.99,
            cantidad = 4
        };
        var actualizado_response = await Actualizar(1, actualizado);
        Console.WriteLine("Actualizado: " + actualizado_response);

        // DELETE - Eliminar
        await Eliminar(2);
        Console.WriteLine("Eliminado");
    }

    static async Task<string> GetTodos()
    {
        var response = await client.GetAsync(BASE_URL);
        return await response.Content.ReadAsStringAsync();
    }

    static async Task<string> GetPorId(int id)
    {
        var response = await client.GetAsync($"{BASE_URL}/{id}");
        return await response.Content.ReadAsStringAsync();
    }

    static async Task<string> Crear(object producto)
    {
        var json = JsonConvert.SerializeObject(producto);
        var content = new StringContent(json, Encoding.UTF8, "application/json");
        var response = await client.PostAsync(BASE_URL, content);
        return await response.Content.ReadAsStringAsync();
    }

    static async Task<string> Actualizar(int id, object producto)
    {
        var json = JsonConvert.SerializeObject(producto);
        var content = new StringContent(json, Encoding.UTF8, "application/json");
        var response = await client.PutAsync($"{BASE_URL}/{id}", content);
        return await response.Content.ReadAsStringAsync();
    }

    static async Task Eliminar(int id)
    {
        await client.DeleteAsync($"{BASE_URL}/{id}");
    }
}
```

---

## 5. Java (HttpClient - Java 11+)

```java
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private static final String BASE_URL = "http://localhost:8080/api/productos";
    private static final HttpClient client = HttpClient.newHttpClient();

    public static void main(String[] args) throws Exception {
        // GET - Obtener todos
        obtenerTodos();

        // GET - Obtener uno
        obtenerPorId(1);

        // POST - Crear
        crearProducto();

        // PUT - Actualizar
        actualizarProducto(1);

        // DELETE - Eliminar
        eliminarProducto(2);
    }

    static void obtenerTodos() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(BASE_URL))
            .GET()
            .build();
        
        HttpResponse<String> response = client.send(request, 
            HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    static void obtenerPorId(int id) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(BASE_URL + "/" + id))
            .GET()
            .build();
        
        HttpResponse<String> response = client.send(request, 
            HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    static void crearProducto() throws Exception {
        String json = """
            {
                "nombre": "Webcam",
                "descripcion": "Webcam Full HD",
                "precio": 79.99,
                "cantidad": 8
            }
            """;

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(BASE_URL))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(json))
            .build();
        
        HttpResponse<String> response = client.send(request, 
            HttpResponse.BodyHandlers.ofString());
        System.out.println("Creado: " + response.body());
    }

    static void actualizarProducto(int id) throws Exception {
        String json = """
            {
                "nombre": "Laptop Ultra",
                "descripcion": "Laptop de última generación",
                "precio": 1599.99,
                "cantidad": 2
            }
            """;

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(BASE_URL + "/" + id))
            .header("Content-Type", "application/json")
            .PUT(HttpRequest.BodyPublishers.ofString(json))
            .build();
        
        HttpResponse<String> response = client.send(request, 
            HttpResponse.BodyHandlers.ofString());
        System.out.println("Actualizado: " + response.body());
    }

    static void eliminarProducto(int id) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(BASE_URL + "/" + id))
            .DELETE()
            .build();
        
        client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Eliminado");
    }
}
```

---

## 6. PHP

```php
<?php

$BASE_URL = 'http://localhost:8080/api/productos';

// GET - Obtener todos
$response = file_get_contents($BASE_URL);
echo json_decode($response, true);

// GET - Obtener uno
$response = file_get_contents($BASE_URL . '/1');
echo json_decode($response, true);

// POST - Crear
$producto = [
    'nombre' => 'Impresora',
    'descripcion' => 'Impresora multifunción',
    'precio' => 299.99,
    'cantidad' => 3
];

$options = [
    'http' => [
        'header' => "Content-Type: application/json\r\n",
        'method' => 'POST',
        'content' => json_encode($producto)
    ]
];

$context = stream_context_create($options);
$response = file_get_contents($BASE_URL, false, $context);
echo "Creado: " . json_decode($response, true);

// PUT - Actualizar
$productoActualizado = [
    'nombre' => 'Impresora Profesional',
    'descripcion' => 'Impresora profesional de alta velocidad',
    'precio' => 399.99,
    'cantidad' => 2
];

$options = [
    'http' => [
        'header' => "Content-Type: application/json\r\n",
        'method' => 'PUT',
        'content' => json_encode($productoActualizado)
    ]
];

$context = stream_context_create($options);
$response = file_get_contents($BASE_URL . '/1', false, $context);
echo "Actualizado: " . json_decode($response, true);

// DELETE - Eliminar
$options = [
    'http' => [
        'method' => 'DELETE'
    ]
];

$context = stream_context_create($options);
file_get_contents($BASE_URL . '/2', false, $context);
echo "Eliminado";

?>
```

---

## 7. Postman Collection

Importa esta colección en Postman copiando el siguiente JSON:

```json
{
  "info": {
    "name": "API Productos",
    "description": "Colección para probar la API de Productos"
  },
  "item": [
    {
      "name": "Obtener todos",
      "request": {
        "method": "GET",
        "url": {
          "raw": "http://localhost:8080/api/productos",
          "protocol": "http",
          "host": ["localhost"],
          "port": "8080",
          "path": ["api", "productos"]
        }
      }
    },
    {
      "name": "Crear producto",
      "request": {
        "method": "POST",
        "url": {
          "raw": "http://localhost:8080/api/productos",
          "protocol": "http",
          "host": ["localhost"],
          "port": "8080",
          "path": ["api", "productos"]
        },
        "body": {
          "mode": "raw",
          "raw": "{\n  \"nombre\": \"Producto Nuevo\",\n  \"descripcion\": \"Descripción\",\n  \"precio\": 99.99,\n  \"cantidad\": 5\n}"
        }
      }
    }
  ]
}
```

---

¡Usa los ejemplos que mejor se adapten a tu necesidad!

