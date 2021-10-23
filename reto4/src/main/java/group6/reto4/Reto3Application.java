//1. Modelo o entidad: Donde se construye la tabla con sus columnas
//2. Interface: Donde heredamos del JPA del CrudRepository(CRUD). Este tipo nos 
//   permite heredar de otras clases.
//3. Repositorio: Donde se crean los métodos para poder utilizar el CRUD
//4. Servicios: Donde se definen los tipos de datos a través de JSON
//5. Controlador Web: Donde se crean las URL de nuestra API Rest

package group6.reto4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Reto3Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto3Application.class, args);
	}

}
