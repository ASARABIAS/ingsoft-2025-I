# 📧 Aplicación de Notificaciones - Spring Boot

Una aplicación robusta desarrollada en Java con Spring Boot que permite enviar notificaciones a través de múltiples canales: **Email**, **SMS** y **WhatsApp**. Implementa una arquitectura por capas limpia y utiliza el patrón Factory Method para la creación de diferentes tipos de notificaciones.

## 🚀 Características Principales

✅ **Arquitectura por capas** bien definida  
✅ **Factory Method** para crear notificaciones  
✅ **Inyección de dependencias** con Spring  
✅ **Validaciones** de datos de entrada  
✅ **Logging** para seguimiento  
✅ **Manejo de errores** robusto  
✅ **API REST** con endpoints claros  

## 🏗️ Arquitectura del Sistema

### 1. **Capa de Dominio (Domain Layer)**

La capa de dominio contiene las entidades principales y las reglas de negocio:

- **`Notification`** (interfaz base): Define el contrato común para todas las notificaciones
- **`NotificationType`** (enumeración): Define los tipos de notificación disponibles (EMAIL, SMS, WHATSAPP)
- **DTOs**:
  - `NotificationRequest`: Objeto de transferencia para las solicitudes de notificación
  - `NotificationResponse`: Objeto de transferencia para las respuestas del sistema
- **Implementaciones concretas**:
  - `EmailNotification`: Implementación específica para envío de emails
  - `SmsNotification`: Implementación específica para envío de SMS
  - `WhatsAppNotification`: Implementación específica para envío de WhatsApp

### 2. **Patrón Factory Method**

Implementa el patrón de diseño Factory Method para la creación de objetos:

- **`NotificationFactory`** (interfaz): Define el método para crear notificaciones
- **`NotificationFactoryImpl`** (implementación): Crea los tipos específicos de notificación según el tipo solicitado

### 3. **Capa de Servicio (Service Layer)**

Contiene la lógica de negocio y orquesta las operaciones:

- **`NotificationService`** (interfaz): Define los servicios disponibles
- **`NotificationServiceImpl`** (implementación): 
  - Lógica de negocio principal
  - Validaciones de datos de entrada
  - Manejo de errores y excepciones
  - Integración con el Factory Method

### 4. **Capa de Controlador (Controller Layer)**

Expone los endpoints REST para interactuar con la aplicación:

- **`NotificationController`**: Maneja las peticiones HTTP y coordina las respuestas

## 📋 Endpoints Disponibles

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/notifications/send` | Enviar una notificación |
| `GET` | `/api/notifications/health` | Verificar el estado del servicio |

## 🛠️ Instalación y Configuración

### Prerrequisitos

- Java 17 o superior
- Maven 3.6+
- Spring Boot 3.2.0

### Pasos para ejecutar

1. **Clona o descarga el proyecto**
   ```bash
   git clone <repository-url>
   cd notification-service
   ```

2. **Compila el proyecto**
   ```bash
   mvn clean install
   ```

3. **Ejecuta la aplicación**
   ```bash
   mvn spring-boot:run
   ```

4. **Accede a la aplicación**
   ```
   La aplicación estará disponible en: http://localhost:8080
   ```

## 📨 Ejemplos de Uso

### Enviar Email
```bash
curl -X POST http://localhost:8080/api/notifications/send \
  -H "Content-Type: application/json" \
  -d '{
    "type": "EMAIL",
    "recipient": "usuario@example.com",
    "message": "Este es un mensaje de prueba por email"
  }'
```

### Enviar SMS
```bash
curl -X POST http://localhost:8080/api/notifications/send \
  -H "Content-Type: application/json" \
  -d '{
    "type": "SMS",
    "recipient": "+1234567890",
    "message": "Este es un mensaje de prueba por SMS"
  }'
```

### Enviar WhatsApp
```bash
curl -X POST http://localhost:8080/api/notifications/send \
  -H "Content-Type: application/json" \
  -d '{
    "type": "WHATSAPP",
    "recipient": "+1234567890",
    "message": "Este es un mensaje de prueba por WhatsApp"
  }'
```

### Verificar Estado del Servicio
```bash
curl -X GET http://localhost:8080/api/notifications/health
```

## 📝 Formato de Request

```json
{
  "type": "EMAIL|SMS|WHATSAPP",
  "recipient": "destinatario@example.com o +1234567890",
  "message": "Tu mensaje aquí"
}
```

## 📄 Formato de Response

### Respuesta Exitosa
```json
{
  "success": true,
  "message": "Notificación enviada exitosamente",
  "type": "EMAIL"
}
```

### Respuesta de Error
```json
{
  "success": false,
  "message": "El destinatario es requerido",
  "type": "EMAIL"
}
```

## 🔧 Configuración

La aplicación utiliza el archivo `application.yml` para su configuración:

```yaml
server:
  port: 8080

spring:
  application:
    name: notification-service

logging:
  level:
    com.notification: INFO
    org.springframework: WARN
```

## 📦 Dependencias Principales

- **Spring Boot Starter Web**: Para crear APIs REST
- **Spring Boot Starter Validation**: Para validación de datos
- **Spring Boot Starter Test**: Para pruebas unitarias
- **SLF4J**: Para logging

## 🚀 Extensibilidad

El sistema está diseñado para ser fácilmente extensible:

1. **Agregar nuevos tipos de notificación**:
   - Crear nueva implementación de `Notification`
   - Agregar el tipo al enum `NotificationType`
   - Actualizar el `NotificationFactoryImpl`

2. **Integrar APIs reales**:
   - **Email**: JavaMailSender, SendGrid, etc.
   - **SMS**: Twilio, AWS SNS, etc.
   - **WhatsApp**: WhatsApp Business API

## 🧪 Testing

```bash
# Ejecutar todas las pruebas
mvn test

# Ejecutar con reporte de cobertura
mvn clean test jacoco:report
```

## 📊 Logs

La aplicación genera logs detallados para el seguimiento de operaciones:

- Información de procesamiento de notificaciones
- Errores y excepciones
- Tiempo de respuesta simulado

## 🤝 Contribución

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE.md](LICENSE.md) para más detalles.

## 👥 Autores

- **Tu Nombre** - *Desarrollo inicial* - [TuGitHub](https://github.com/tuusuario)

## 🙏 Agradecimientos

- Spring Boot Team por el excelente framework
- Comunidad Java por las mejores prácticas
- Patrones de diseño que hacen el código más mantenible