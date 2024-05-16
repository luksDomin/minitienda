Este proyecto es una minitienda basica basada en servlets.

Los requisitos para poder ejecutarlo son:

1. Tener TOMCAT instalado.
2. Tener una base de datos POSTGRESQL que tendras que configurar por tu cuenta. En este caso en la clase ConexionDB.java hay un metodo que contiene la url de mi base de datos, asi como el username y contraseña de la misma. Deberás cambiar esto.

Lo unico que necesitas para ejecutar el proyecto es desplegar el war en tu TOMCAT pero ten en cuenta lo anterior, así como que necesitarás compilar la clase java que has modificado de la siguiente forma:

1. Para compilar las clases de java teniendo esta misma estructura de ficheros deberás situarte en el directorio classes y  utilizar el siguiente comando: javac -d . controlador/*.java modelo/*.java
2. Para crear un nuevo fichero war tendrás que colocarte en el directorio raiz de la aplicación y ejecutar lo siguiente: jar -cvf nombreWar.war .
