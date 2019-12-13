# reto
Para poder utilizar el desarrollo/fuentes se debe de realizar lo siguiente:
En el archivo de resources/application.propierties solo modificar las llaves de los codigos/mensajes por los valores que deseen
ademas de la url del datasource(spring.datasource.url) que actualmente está apuntando a un RDS de AWS.
Se adjunta el script de bd para la creacion de la misma y su respectiva tabla.
Posteriormente a las modificaciones, compilar las fuentes y ejecutar en un entorno java 8 (update 121+).

Comando a ejecutar en evironment java (jdk 8):
java -jar ${path}/retoms.1.0.0.jar

Saludos, Gian.
