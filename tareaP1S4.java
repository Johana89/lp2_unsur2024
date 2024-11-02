
       // 1. Pasos para crear un recurso REST en Quarkus//

//1.Configura tu proyecto//
//Usa el [Quarkus CLI](https://quarkus.io/guides/getting-started#quarkus-cli) o el [maven archetype](https://quarkus.io/guides/getting-started#creating-a-quarkus-project) para crear un nuevo proyecto.//

//Asegúrate de incluir la extensión `resteasy` en tu configuración.//

//2.Crea un recurso REST//

//3.Define métodos de manejo:a una nueva clase Java en el paquete adecuado (por ejemplo, `com.example`). Esta clase debe estar anotada con `@Path`.//

//   - Añade métodos que manejen las solicitudes HTTP, anotándolos con `@GET`, `@POST`, `@PUT`, etc. //


//    4.Configura tu aplicación //

// Modifica el archivo `application.properties` si necesitas configurar propiedades específicas.//
//5. Ejecuta tu aplicación//
  // - Usa `./mvnw quarkus:dev` para iniciar tu aplicación en modo de desarrollo.//
  //2. Configuración de una ruta de endpoint utilizando la anotación @Path//

//la anotación `@Path` se utiliza para definir la ruta base de un recurso REST. Por ejemplo://


import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloResource {
    @GET
    public String hello() {
        return "Hello, World!";

     }
}

//En este ejemplo, la ruta del endpoint es /hello, y el método hello() se invoca cuando se realiza una solicitud HTTP GET a esa ruta.//


//3. Inyección de dependencias (CDI) en Quarkus//

//La inyección de dependencias (CDI, Contexts and Dependency Injection) en Quarkus permite gestionar la creación y el ciclo de vida de los objetos, facilitando la desacoplación de componentes en tu aplicación. Es importante porque://
//Promueve la reutilización del código.//
//Facilita las pruebas unitarias mediante la inyección de mocks.//
//Mejora la mantenibilidad al reducir el acoplamiento entre clases.//
//Puedes utilizar la anotación @Inject para inyectar dependencias en tu recurso REST://
import javax.inject.Inject;

@Path("/greet")
public class GreetingResource {

    @Inject
    GreetingService greetingService;

    @GET
    public String greet() {
        return greetingService.getGreeting();
    }



    //Ejemplo de GreetingService//
    
    import javax.enterprise.context.ApplicationScoped;
    
    @ApplicationScoped
    public class GreetingService {
        public String getGreeting() {
            return "Hello from the Service!";
        }

        //  4. Uso de @Produces y @Consumes para Definir el Tipo de Datos en una API REST//
//@Produces: Especifica el tipo de contenido que el recurso REST devuelve al cliente.// Los tipos más comunes son MediaType.APPLICATION_JSON para JSON y MediaType.TEXT_PLAIN para texto.//

//Ejemplo de @Produces:  //
@GET
@Produces(MediaType.APPLICATION_JSON)
public Response getGreeting() {
    return Response.ok(new Greeting("Hello")).build();
}
//@Consumes: Define el tipo de contenido que el recurso REST acepta en las solicitudes del cliente. Por ejemplo, si deseas que el método acepte JSON, utiliza MediaType.APPLICATION_JSON.//

//Ejemplo de @Consumes://
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response createGreeting(Greeting greeting) {
    // lógica para crear un saludo
    return Response.ok(greeting).build();
}
//5. Concepto de Controlador en un Servicio REST y su Función//
//Un controlador en un servicio REST (también llamado recurso o recurso REST) es la clase que gestiona las solicitudes HTTP y determina cómo deben manejarse. Su función principal es recibir solicitudes, procesarlas, y devolver una respuesta adecuada (por ejemplo, un objeto JSON, texto, o código de estado HTTP).//

//El controlador define las rutas, métodos HTTP, y tipos de datos admitidos por la API. Cada método en el controlador suele representar una operación específica (por ejemplo, GET, POST, PUT, o DELETE) en un recurso de la API.//

//En Quarkus, el controlador es simplemente una clase anotada con @Path y métodos anotados con los verbos HTTP como @GET o @POST, que son los puntos de entrada a tu servicio REST.//
