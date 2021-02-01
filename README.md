Para utilizar los recursos, se debe levantar el proyecto a través de un IDE como Eclipse o con el comando: mvn spring-boot:run

Luego, se puede acceder a Swagger a través de la URL: http://localhost:8080/swagger-ui.html#/

Y allí se podrán probar los recursos. Otra opción es utilizar directamente Postman

En la carpeta postman del proyecto se encuentra un archivo que se puede importar en Postman y así poder probar los recursos

En la carpeta uml se encuentra una imagen con el diagrama UML

Hay test para ejecutar en la clase que se encuentra en el path: src/test/java y el paquete: com.geometria.test

Se puede acceder a la base de datos h2 con la url: http://localhost:8080/h2-console/login.jsp

Con los datos:

Driver class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
User Name: sa

En el proyecto se utilizó segregación de interfaces, porque no me gustaba la idea de que por ejemplo una figura como un Circulo se viese obligada a
tener que implementar un método como por ejemplo: getBase(). Ya que no tiene ningún sentido. O por ejemplo que un triangulo implemente un método
como: getDiametro(), ya que tampoco tiene sentido. 