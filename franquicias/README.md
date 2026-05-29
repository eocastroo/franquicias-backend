# Franquicias Backend

## Descripción

API desarrollada con Spring Boot 3 para la gestión de franquicias, sucursales y productos.

## Funcionalidades

- CRUD Franquicias
- CRUD Sucursales
- CRUD Productos
- Consulta producto con mayor stock por sucursal

## Tecnologías

- Java 21
- Spring Boot 3
- Spring Data JPA
- MySQL
- Maven
- Docker

## Base de datos

Crear la base de datos:

```sql
CREATE DATABASE bd_franquicias;
```

## Configuración

Modificar el archivo:

```properties
src/main/resources/application.properties
```

Ejemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bd_franquicias
spring.datasource.username=root
spring.datasource.password=root
```

## Ejecutar proyecto

```bash
mvn clean install
```

```bash
mvn spring-boot:run
```

## Endpoints principales

### Franquicias

GET

```http
/api/v1/franchises
```

POST

```http
/api/v1/franchises
```

### Sucursales

GET

```http
/api/v1/branches
```

POST

```http
/api/v1/branches
```

### Productos

GET

```http
/api/v1/products
```

POST

```http
/api/v1/products
```

### Producto con mayor stock

GET

```http
/api/v1/products/top-stock/{branchId}
```

## Repositorio

Desarrollado como prueba técnica Backend.

## Autor

Edwin Orlando Castro Orjuela