/Tarea P1 S4
//1. ¿Qué es el Patrón de Diseño Repository y cuál es su Principal Objetivo en Aplicaciones REST?//
//El Patrón Repository es un diseño estructural que actúa como una capa de abstracción entre la lógica de negocio y la capa de acceso a datos. Su principal objetivo es desacoplar el código de negocio de la lógica de persistencia, facilitando la interacción con la base de datos mediante una interfaz simple y predefinida.//

//En aplicaciones REST, el patrón Repository permite que los controladores REST accedan a los datos sin estar directamente conectados a la base de datos. Esto proporciona flexibilidad en la implementación y mantenimiento del código, así como una arquitectura más limpia y ordenada.//

//. ¿Cómo Separar la Lógica de Negocio del Acceso a Datos al Implementar el Patrón Repository?//
//Para separar la lógica de negocio del acceso a datos al implementar el patrón Repository en Quarkus, los pasos recomendados son:

/**Definir una Clase de Entidad: Representa los datos como una clase que corresponde a una tabla de la base de datos, anotada con @Entity.//
Crear una Interfaz Repository: Define métodos CRUD (Create, Read, Update, Delete) y otros métodos específicos para acceder a los datos, anotada con @ApplicationScoped o que implemente PanacheRepository para aprovechar las funciones de Quarkus.//
Crear una Clase de Servicio: Define la lógica de negocio y utiliza el Repository para manipular los datos según sea necesario. La clase de servicio generalmente se anota con @ApplicationScoped.//
//Inyectar el Servicio en el Controlador REST: Esto encapsula la lógica de negocio y el acceso a datos, permitiendo que los controladores REST solo manejen las solicitudes y respuestas HTTP.//
// ¿Qué Técnicas se Pueden Usar para Realizar Consultas Básicas (findAll, findById) en una Clase Repository?
Quarkus //facilita el uso del patrón Repository a través de Panache. Para realizar consultas básicas, se pueden utilizar las siguientes técnicas://

//Uso de PanacheRepository o PanacheRepositoryBase: Estas interfaces proporcionan métodos predefinidos como findAll(), findById(), persist(), y delete().*/


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

/**@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
    // Métodos findAll(), findById(), persist(), delete() ya están implementados
}
//Consultas Personalizadas: Puedes definir consultas personalizadas usando PanacheRepository o PanacheEntity.//

//java

public List<User> findByName(String name) {
    return list("name", name);
}
    */
//Uso de Named Querie // Define consultas SQL personalizadas en la entidad utilizando anotaciones como @NamedQuery.//

//java//

@Entity
@NamedQuery(name = "User.findByStatus", query = "SELECT u FROM User u WHERE u.status = :status")
public class User {
    // atributos de la entidad
}
//JPA Criteria API: para consultas más complejas y dinámicas.

// ¿Cuáles son las Ventajas de Implementar el Patrón Repository en Aplicaciones REST?//
//Implementar el patrón Repository en aplicaciones REST tiene varias ventajas://

/**Desacoplamiento de Capas: Permite que la lógica de negocio esté separada del acceso a datos, mejorando la modularidad y reduciendo la dependencia entre capas.
Mantenibilidad: Facilita el mantenimiento, pruebas y cambios en la lógica de persistencia sin afectar la lógica de negocio.
Facilidad de Pruebas: Los repositorios pueden ser fácilmente simulados (mocked) en pruebas unitarias, permitiendo probar la lógica de negocio sin depender de la base de datos.
Escalabilidad y Flexibilidad: Permite cambiar o ajustar la capa de persistencia (por ejemplo, de SQL a NoSQL) sin modificar la lógica de negocio.
Simplicidad: Quarkus y Panache simplifican la implementación del patrón Repository al proporcionar métodos comunes predefinidos.*/
