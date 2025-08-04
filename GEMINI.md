# Contexto del Proyecto

Este proyecto es un backend de inventario desarrollado con Spring Boot. Incluye funcionalidades para la gestión de productos, autenticación y autorización.

## Estructura del Proyecto

El proyecto sigue una estructura estándar de Spring Boot, con paquetes para:
- `config`: Configuraciones de seguridad, CORS y OpenAPI.
- `controller`: Endpoints REST para la gestión de productos.
- `dto`: Objetos de transferencia de datos.
- `entity`: Entidades de base de datos (Product, User).
- `repository`: Interfaces de repositorio para la persistencia de datos.
- `service`: Lógica de negocio para la gestión de productos.

## Autenticación y Autorización

El proyecto utiliza Spring Security con JWT para la autenticación y autorización. La validación del token JWT se realiza con un secreto de Supabase.

## Documentación OpenAPI

La API está documentada con OpenAPI (Swagger UI), accesible en la ruta `/swagger-ui.html`.

# Hoja de Ruta: Gestión de Roles con Supabase

La siguiente tarea principal es implementar la gestión de roles basada en los metadatos del token JWT de Supabase.

## Tareas a Realizar

1.  **Investigar la estructura del token JWT de Supabase:**
    *   Identificar la claim específica donde Supabase almacena la información de los roles (ej., `app_metadata.roles`, `roles`, `user_metadata.roles`).
    *   Determinar el formato de esta claim (ej., array de strings, string separado por comas).

2.  **Modificar `SecurityConfig.java`:**
    *   Implementar un `JwtAuthenticationConverter` personalizado.
    *   Este convertidor debe extraer la claim de roles del token JWT.
    *   Mapear los roles extraídos a objetos `SimpleGrantedAuthority` de Spring Security.
    *   Configurar el `JwtAuthenticationConverter` en el `JwtDecoder` para que Spring Security utilice estos roles para la autorización.

3.  **Probar la autorización basada en roles:**
    *   Crear o modificar tests de integración para verificar que las anotaciones `@PreAuthorize` funcionan correctamente con los roles extraídos del token de Supabase.
    *   Realizar pruebas manuales con tokens JWT que contengan diferentes roles para asegurar que los endpoints están protegidos según lo esperado.

4.  **Documentar el proceso:**
    *   Actualizar la documentación interna (si existe) con los detalles de cómo se manejan los roles desde Supabase.
    *   Añadir cualquier configuración necesaria en Supabase para la inclusión de roles en el token.
