# Proyecto de Inventario - Backend

## Descripción

Este es el backend para la aplicación de inventario. Se encarga de gestionar los productos, usuarios y la autenticación.

## Tabla de Contenido

- [Tecnologías Usadas](#tecnologías-usadas)
- [Arquitectura](#arquitectura)
- [Dependencias](#dependencias)
- [Instalación](#instalación)
- [Uso](#uso)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)

## Tecnologías Usadas

- Java
- Spring Boot
- Maven
- PostgreSQL

## Arquitectura

El proyecto sigue una arquitectura de 3 capas:

- **Capa de Presentación (Controller):** Expone los endpoints de la API REST.
- **Capa de Lógica de Negocio (Service):** Contiene la lógica de negocio de la aplicación.
- **Capa de Acceso a Datos (Repository):** Se encarga de la comunicación con la base de datos.

## Dependencias

Las dependencias del proyecto se gestionan con Maven y se pueden encontrar en el archivo `pom.xml`.

## Instalación

1. Clonar el repositorio: `git clone <URL_DEL_REPOSITORIO>`
2. Instalar las dependencias: `mvn install`
3. Configurar la base de datos en `src/main/resources/application.properties`
4. Ejecutar la aplicación: `mvn spring-boot:run`

## Uso

La API se puede consumir a través de los endpoints expuestos por los controladores.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, sigue las guías de contribución del proyecto.

## Licencia

Este proyecto está bajo la licencia MIT.
