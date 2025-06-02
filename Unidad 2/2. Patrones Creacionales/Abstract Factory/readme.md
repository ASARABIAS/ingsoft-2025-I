# ProductController - Spring Boot MVC

Este controlador forma parte de una aplicación web basada en Spring Boot. Su objetivo principal es gestionar la visualización de productos en la página principal (`/`) de la aplicación, adaptando dinámicamente el estilo visual (tema) según el parámetro proporcionado por el usuario.

## 📌 Objetivo

Renderizar una vista HTML (`index.html`) con una lista de productos y elementos de la interfaz de usuario ajustados al tema visual seleccionado (`DARK` o `LIGHT`).

---

## 🚀 Endpoint principal

### `GET /`

#### Parámetros

| Nombre     | Tipo     | Requerido | Valor por defecto | Descripción                                    |
|------------|----------|-----------|-------------------|------------------------------------------------|
| `theme`    | `String` | No        | `DARK`            | Tema visual de la interfaz (`LIGHT` o `DARK`) |

#### Ejemplo de uso

