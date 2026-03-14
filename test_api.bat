@echo off
REM Script de prueba de la API REST
REM Asegúrate de que la API esté ejecutándose antes de correr este script

setlocal enabledelayedexpansion
set BASE_URL=http://localhost:8080/api/productos

echo ======================================
echo PRUEBAS DE LA API REST
echo ======================================
echo.

REM Esperar a que el usuario inicie la API
echo Asegúrate de que la API esté ejecutándose en http://localhost:8080
echo Presiona Enter para continuar...
pause

echo.
echo 1. Obtener todos los productos
echo ======================================
curl %BASE_URL%
echo.
echo.

echo 2. Obtener producto con ID 1
echo ======================================
curl %BASE_URL%/1
echo.
echo.

echo 3. Obtener productos disponibles
echo ======================================
curl %BASE_URL%/disponibles
echo.
echo.

echo 4. Buscar productos por nombre (Mouse)
echo ======================================
curl "%BASE_URL%/buscar/nombre?nombre=mouse"
echo.
echo.

echo 5. Filtrar por rango de precio (50-200)
echo ======================================
curl "%BASE_URL%/filtro/precio?min=50^&max=200"
echo.
echo.

echo 6. Crear nuevo producto
echo ======================================
echo Creando: Webcam 1080p por $49.99...
curl -X POST %BASE_URL% ^
  -H "Content-Type: application/json" ^
  -d "{\"nombre\":\"Webcam\",\"descripcion\":\"Webcam 1080p\",\"precio\":49.99,\"cantidad\":7}"
echo.
echo.

echo 7. Obtener todos los productos (después de crear)
echo ======================================
curl %BASE_URL%
echo.
echo.

echo 8. Actualizar producto ID 1
echo ======================================
echo Actualizando Laptop a $1299.99...
curl -X PUT %BASE_URL%/1 ^
  -H "Content-Type: application/json" ^
  -d "{\"nombre\":\"Laptop Pro\",\"descripcion\":\"Laptop profesional de alto rendimiento\",\"precio\":1299.99,\"cantidad\":4}"
echo.
echo.

echo 9. Obtener producto actualizado
echo ======================================
curl %BASE_URL%/1
echo.
echo.

echo 10. Eliminar producto ID 5
echo ======================================
echo Eliminando Auriculares...
curl -X DELETE %BASE_URL%/5
echo.
echo.

echo 11. Obtener todos (después de eliminar)
echo ======================================
curl %BASE_URL%
echo.
echo.

echo ======================================
echo Pruebas completadas
echo ======================================
pause

