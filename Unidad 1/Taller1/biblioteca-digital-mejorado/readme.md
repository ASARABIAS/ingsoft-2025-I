## README.md

```markdown
# Sistema de Biblioteca Digital - Caso de Estudio

## ⚠️ ADVERTENCIA: Código con Problemas de Diseño Intencionales

Este proyecto contiene **múltiples violaciones a principios de diseño** de forma intencional para ser utilizado como caso de estudio en cursos de patrones de diseño y arquitectura de software.

## Problemas de Diseño Identificados

### Violaciones a Principios SOLID

1. **Single Responsibility Principle (SRP)**
   - `BibliotecaService`: Maneja libros, usuarios, préstamos y reportes
   - `Usuario`: Gestiona datos, validaciones y notificaciones
   - `LibroController`: Validación, conversión y lógica de negocio

2. **Open/Closed Principle (OCP)**
   - Lógica hardcodeada para tipos de usuario
   - Sistema de notificaciones no extensible
   - Cálculo de multas con switch/case

3. **Liskov Substitution Principle (LSP)**
   - Método `generarCredencialProfesor()` no aplicable a todos los usuarios
   - Jerarquías inconsistentes

4. **Interface Segregation Principle (ISP)**
   - `LibroRepository` con métodos específicos no necesarios para todos los clientes
   - Interfaces sobrecargadas

5. **Dependency Inversion Principle (DIP)**
   - Dependencias directas de `NotificacionService`
   - Conversiones manuales DTO-Entity
   - Acoplamiento a implementaciones concretas

### Violaciones a Principios GRASP

1. **High Cohesion**: Clases con responsabilidades dispersas
2. **Low Coupling**: Alto acoplamiento entre componentes
3. **Controller**: Lógica de negocio en controladores REST  
4. **Creator**: Responsabilidades de creación mal asignadas
5. **Information Expert**: Información y comportamiento separados

## Tecnologías Utilizadas

- Java 17
- Spring Boot 3.1.5
- Spring Data JPA
- H2 Database (desarrollo)
- Maven
- Lombok

## Instalación y Ejecución

```bash
# Clonar el repositorio
git clone <repository-url>
cd biblioteca-digital

# Compilar y ejecutar
mvn clean install
mvn spring-boot:run

# Acceder a la aplicación
http://localhost:8080/biblioteca

# Console H2 (desarrollo)
http://localhost:8080/biblioteca/h2-console
```

## Endpoints de la API

### Libros
- `POST /api/libros` - Crear libro
- `GET /api/libros/buscar?criterio={criterio}` - Buscar libros (ejemplo) ##ISBN: 123456   ,  AUTOR:pascal
- `GET /api/libros/{id}` - Obtener libro
- `GET /api/libros/{id}/reporte` - Generar reporte

### Usuarios
- `POST /api/usuarios` - Registrar usuario
- `GET /api/usuarios/{id}/reporte` - Generar reporte usuario

### Préstamos
- `POST /api/prestamos?usuarioId={id}&libroId={id}` - Realizar préstamo
- `PUT /api/prestamos/{id}/devolver` - Devolver libro
- `POST /api/prestamos/enviar-recordatorios` - Enviar recordatorios

## Objetivos del Ejercicio

Los estudiantes deben:

1. **Identificar violaciones** a principios SOLID y GRASP
2. **Proponer mejoras** estructurales con justificación técnica
3. **Rediseñar el sistema** aplicando patrones de diseño apropiados
4. **Crear diagramas UML** del nuevo diseño
5. **Documentar beneficios** esperados de las mejoras

## Métricas de Calidad Actuales

- **Complejidad Ciclomática**: Alta en servicios principales
- **Acoplamiento Aferente/Eferente**: Desbalanceado
- **Cohesión**: Baja en clases principales
- **Líneas de Código por Método**: Excesivas en varios casos

## Notas para Docentes

Este código está diseñado para generar discusión y análisis crítico. Cada violación es intencional y representa problemas comunes en proyectos reales de desarrollo de software.

---
**Autor**: Sistema diseñado para fines educativos  
**Versión**: 1.0.0  
**Licencia**: Uso académico únicamente