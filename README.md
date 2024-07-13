# `Foro-Hub-Challenge-Backend-ONE`
🏁 Desafio de la formación Java y Spring Boot del grupo G6 del curso ONE - Oracle Next Education

## 📋 Descripción del desafío:
Crear la API de un foro en donde todos los usuarios de una plataforma puedan plantear sus preguntas respecto a determinádos tópicos y otros usuarios les ayuden a responderlas.

El objetivo con este challenge es implementar una API REST con las siguientes funcionalidades:
- [x] API con rutas implementadas siguiendo las mejores prácticas del modelo REST
- [x] Validaciones realizadas según las reglas de negocio
- [x] Implementación de una base de datos relacional para la persistencia de la información
- [x] Servicio de autenticación/autorización para restringir el acceso a la información

## Funcionalidades de la API:

- Login mediante credenciales válidas para generar un JSON Web Token que será requerido para acceder a las siguientes funcionalidades
  
![1](https://github.com/user-attachments/assets/5d381f70-a9e4-4f48-a7b1-fbcef76a04bf)
![2](https://github.com/user-attachments/assets/270c0aa7-035e-45b8-9978-5cfbae7d09c7)

- Crear un nuevo tópico
  
![3](https://github.com/user-attachments/assets/a5553af2-096e-4555-8762-2257ad48a24c)

- Mostrar todos los tópicos creados
  
![4](https://github.com/user-attachments/assets/e1b1a377-a84b-4e59-a0ce-075e14bb5155)

- Detallar un tópico específico
 
![5](https://github.com/user-attachments/assets/341cd131-0fb1-4685-928b-5f057928dddc)

- Actualizar un tópico
  
![6](https://github.com/user-attachments/assets/bf8a918b-facb-43d9-8d58-0472340393a0)

- Responder a un tópico

![respuesta](https://github.com/user-attachments/assets/d35fa393-8982-4693-bfd3-ec6c6913ee5d)


- Eliminar un tópico

## Video de funcionamiento 

https://github.com/user-attachments/assets/ca85989b-caea-4b00-a0d6-7b5dcd90fa67




## 🛠️ Configuración al crear el proyecto con Spring Initializr:
- Java (versión 17 en adelante)
- Maven (Initializr utiliza la versión 4)
- Spring Boot: versión 3 en adelante
- Proyecto en formato JAR

### Variables de Entorno

Se requiere configurar las siguientes variables de entorno:

<table border="1">
    <tr style="text-align: center;">
        <td>*VARIABLE*</td>
        <td>*DESCRIPCIÓN*</td>
    </tr>
    <tr>
        <td>DB_HOST</td>
        <td>Ruta y puerto de la base de datos</td>
    </tr>
    <tr>
        <td>DB_NAME</td>
        <td>Nombre de la base de datos</td>
    </tr>
    <tr>
        <td>DB_USER</td>
        <td>Usuario de la base de datos</td>
    </tr>
    <tr>
        <td>DB_PASSWORD</td>
        <td>Contraseña de acceso a la base de datos</td>
    </tr>
</table>

## 🖥️ Dependencias para agregar al crear el proyecto con Spring Initializr:
- Lombok
- Spring Web
- Spring Boot DevTools
- Spring Data JPA
- Flyway Migration
- MySQL Driver
- Validation
- Spring Security
