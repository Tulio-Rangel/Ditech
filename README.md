# Backend User Service

Este es un servicio RESTful simple para la gestión de usuarios, construido con Spring Boot.

## Descripción General

El servicio expone una API para realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre entidades de usuario. Utiliza una base de datos en memoria H2 para la persistencia de datos.

## Características

- **API RESTful** para la gestión de usuarios.
- **Validación de entrada** en los endpoints de creación y actualización.
- **Manejo de excepciones global** y centralizado.
- **Pruebas unitarias y de integración** con JUnit 5 y Mockito.
- **Métricas de la aplicación** expuestas con Spring Boot Actuator y Prometheus.

## Cómo Empezar

### Prerrequisitos

- Java 11 o superior
- Maven 3.2+

### Ejecución de la Aplicación

1. Clona este repositorio:
   ```sh
   git clone <url-del-repositorio>
   cd backend-user-service
   ```

2. Ejecuta la aplicación usando el wrapper de Maven:
   ```sh
   ./mvnw spring-boot:run
   ```

La aplicación se iniciará en `http://localhost:8080`.

### Detener la Aplicación

Para detener la aplicación, presiona `Ctrl+C` en la terminal donde se está ejecutando.

## Pruebas

### Ejecución de Pruebas

Para ejecutar el conjunto completo de pruebas (unitarias y de integración), ejecuta el siguiente comando:

```sh
./mvnw test
```

### Colección de Postman

Se ha creado una colección de Postman para probar fácilmente los endpoints de la API. Puedes descargarla desde el siguiente enlace e importarla en tu cliente Postman:

[Descargar Colección de Postman](<https://github.com/Tulio-Rangel/Ditech.git>)

## Monitorización


### Métricas de Prometheus

Las métricas en formato Prometheus están disponibles en el siguiente endpoint. Puedes configurar una instancia de Prometheus para recolectar estas métricas.

- **Endpoint de Prometheus:** `http://localhost:8080/actuator/prometheus`
