
# Como usar este proyecto

## Pre-requisitos

- Software Requerido
    * MySQL 5.5 o Superior
    * Java 8
    * IDE (Eclipse, Netbeans, STS, etc.)
- Software Opcional
    * Maven
    * Git

## Código

Clonar el almacen utilizando el IDE o git directamente en la rama *master* 

## Inicializacion Base de datos

Si se requiere trabajar con un esquema y usuario nuevo.
    1. Crear el un esquema de base de datos para trabajar (Se recomienda "user0")
    2. Crear el usuario de trabajo (Se recomienda "user0" tambien)
    3. Asignar permisos a las tablas
    4. Recordar la contraseña

## Configuración

Abrir el archivo [application.properties](src/main/resources/application.properties) y verificar si se requeiren modificar las propiedades siguientes
- __spring.datasource.url:__ Verificar nombre del host, puerto y esquema.
- __spring.datasource.username:__ Modificar el nombre del usuario.
- __spring.datasource.password:__ Modificar la contraseña del usuario.

Opcionalmente, si el puerto 8080 esta ocupado. Agregar la propiedad  __server.port__  con el puerto requerido

## Ejecución

### Maven 

1.  Construir construir la aplicación

    mvn clean package
2.  Ejecutar la aplicación

    java -jar [./target/user-only-0.0.1-SNAPSHOT.jar](./target/user-only-0.0.1-SNAPSHOT.jar)

### STS

Ejecutar como aplicacion spring-boot

### Eclipse

Ejecutar como maven build, indicando en goals  __clean spring-boot:run__
 
