# 📚 Sistema de Gestión de Libros (Hibernate + Panache)

Proyecto simple desarrollado en Java utilizando **Quarkus** y **Hibernate ORM con Panache**, sobre una base de datos MySQL. Permite realizar operaciones básicas de gestión de libros: insertar, buscar, eliminar y listar. La persistencia se maneja mediante entidades Panache, simplificando el acceso a datos sin necesidad de DAOs explícitos.

- 🎥 Video con la explicación del código:  
https://www.youtube.com/watch?v=rZs01_rvTeI

---

## 🚀 Tecnologías

- **Java 21**
- **Quarkus**
- **Hibernate ORM con Panache**
- **MySQL**
- **Maven**

---

## 📂 Estructura del Proyecto

```
sistema-libros-panache/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── santi/
│       │           └── sistemalibrospanache/
│       │               ├── App.java
│       │               └── entities/
│       │                   └── Libro.java
│       └── resources/
│           └── application.properties
└── pom.xml
```

---

## 🧠 Funcionalidades

- Insertar libros
- Buscar libro por ID
- Buscar libros por título (usando `LIKE`)
- Eliminar libros por ID
- Listar todos los libros
- Confirmar cada operación por consola

---

## 🛠️ Configuración de la base de datos

1. Crear la base de datos en MySQL:

```sql
CREATE DATABASE tienda_libros;
USE tienda_libros;

CREATE TABLE libro (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL
);
```

2. Editar `src/main/resources/application.properties`:

```properties
quarkus.datasource.db-kind=mysql
quarkus.datasource.username=root
quarkus.datasource.password=
quarkus.datasource.jdbc.url=jdbc:mysql://localhost:3306/tienda_libros

quarkus.hibernate-orm.schema-management.strategy=update

quarkus.hibernate-orm.log.sql=false

quarkus.console.enabled=false
```

---

## ▶️ Ejecución

1. Iniciar en modo desarrollo (con consola activa):

```bash
quarkus dev
```

2. Resultado esperado (resumen):

```
Libro 'Cien Años de Soledad' insertado con ID: 1
Libro 'Rayuela' insertado con ID: 2

Listado de libros:
 - ID: 1, Título: Cien Años de Soledad
 - ID: 2, Título: Rayuela

Búsqueda por ID:
 - ID: 1, Título: Cien Años de Soledad

Búsqueda por título que contenga 'Soledad':
 - ID: 1, Título: Cien Años de Soledad

Libro 'Rayuela' eliminado: true

Listado tras eliminación:
 - ID: 1, Título: Cien Años de Soledad

Libro 'Cien Años de Soledad' eliminado: true

Listado final de libros:
No hay libros en la base de datos.
```

---

## 🧑‍💻 Autor

Santiago Civalero – Proyecto académico para práctica de Hibernate con Quarkus Panache y MySQL.
