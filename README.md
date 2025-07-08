
# 📘 API REST - Gestión de Libros con Java y MapStruct

Este proyecto es una **API REST básica desarrollada en Java con Spring Boot**, enfocada en el uso de **MapStruct** para mapear entidades a DTOs. Permite realizar operaciones CRUD sobre libros, separando claramente las capas del sistema.

## 🛠 Tecnologías utilizadas

- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- MapStruct  
- MySQL  
- Maven

## ✨ Funcionalidades principales

- CRUD completo de libros
- Uso de DTOs para exponer datos al cliente
- Mapeo automático entre entidades y DTOs con MapStruct
- Persistencia de datos en base de datos relacional (MySQL)

## 🚀 Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/JoahanCarlo/libro_mapstruct.git

2. Configura tu base de datos en application.properties:
   spring.datasource.url=jdbc:mysql://localhost:3306/libros_db
   spring.datasource.username=root
   spring.datasource.password=tu_contraseña

3. Ejecutar la aplicación:
   ./mvnw spring-boot:run

👨‍💻 Autor
Joahan Carlo Nuñez
GitHub
LinkedIn
