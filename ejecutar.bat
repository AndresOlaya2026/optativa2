@echo off
REM Script para ejecutar la API REST de Optativa

echo ========================================
echo API REST - Gestion de Productos
echo ========================================
echo.
echo Java 17 + Spring Boot 4.0.3
echo.
echo Iniciando la aplicacion...
echo La API estara disponible en: http://localhost:8080
echo.
echo Endpoints principales:
echo  - GET    http://localhost:8080/api/productos
echo  - POST   http://localhost:8080/api/productos
echo  - GET    http://localhost:8080/api/productos/{id}
echo  - PUT    http://localhost:8080/api/productos/{id}
echo  - DELETE http://localhost:8080/api/productos/{id}
echo.
echo Presione CTRL+C para detener la aplicacion.
echo ========================================
echo.

cd /d "%~dp0"
call mvn spring-boot:run
pause

