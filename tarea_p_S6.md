//Conceptos Cliente-Servidor (Parte 2)
// ¿Cómo se Realiza la Autenticación y Autorización en un Sistema Cliente-Servidor Basado en REST?
/**En sistemas REST, la autenticación y autorización se implementan generalmente a través de tokens o credenciales enviadas en cada solicitud, permitiendo validar al usuario sin mantener un estado. Los métodos comunes son:*/

/**Tokens de Autenticación (JWT): El cliente envía un token JWT en el encabezado Authorization en cada solicitud. El servidor verifica la autenticidad del token y, si es válido, permite el acceso.

API Keys: En algunos sistemas, se usa una clave de API como forma de autenticación, especialmente en servicios públicos o de terceros.

OAuth: Permite a los usuarios otorgar acceso limitado a sus recursos en una aplicación sin compartir sus credenciales.

La autorización implica verificar si el usuario autenticado tiene los permisos necesarios para realizar una acción específica. Los roles y permisos se suelen definir en el servidor y se validan con cada solicitud para permitir o restringir el acceso a los recursos.

2. ¿Cuál es el Papel de los Códigos de Estado HTTP en la Comunicación entre Cliente y Servidor?
Los códigos de estado HTTP son fundamentales para la comunicación en sistemas REST. Proveen al cliente una respuesta estándar sobre el resultado de cada solicitud, lo que permite comprender el estado de la operación. Algunos códigos comunes incluyen:

200 OK: Solicitud exitosa.
201 Created: Un nuevo recurso fue creado exitosamente.
400 Bad Request: La solicitud tiene un error de sintaxis o formato incorrecto.
401 Unauthorized: Falta autenticación o es incorrecta.
403 Forbidden: El cliente no tiene permisos para acceder al recurso.
404 Not Found: El recurso no existe.
500 Internal Server Error: Error en el servidor.
Estos códigos permiten al cliente manejar respuestas de manera eficiente, identificar problemas rápidamente y ajustar sus operaciones en función de las respuestas.

3. ¿Por Qué es Fundamental Devolver el Código Adecuado y Cómo Afecta la Experiencia del Cliente?
Devolver el código de estado adecuado es esencial para que el cliente pueda interpretar correctamente la respuesta del servidor. Un código incorrecto puede inducir al cliente a errores en el manejo de la respuesta o a fallas en su lógica de programación. Por ejemplo, si el servidor devuelve un 200 OK en lugar de 404 Not Found, el cliente asumirá que el recurso existe, lo cual afectará la integridad de su procesamiento.

Un manejo preciso de los códigos de estado mejora la experiencia del cliente, al permitirle manejar errores y excepciones con claridad y predecibilidad, facilitando una interacción confiable con el servicio.

4. ¿Cómo se Define un Recurso y Por Qué es Importante Mantenerlo como una Entidad Distinta?
En REST, un recurso es cualquier entidad identificable de la cual se pueden obtener datos o a la cual se puede acceder en el sistema. Ejemplos de recursos son usuarios, productos, pedidos, etc. Cada recurso es accesible mediante una URI específica.

Mantener el recurso como una entidad distinta es crucial porque permite a los desarrolladores estructurar la API de forma modular y escalable. Al definir recursos de manera clara, se facilitan las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y se asegura que cada entidad mantenga una funcionalidad específica y coherente.

5. ¿Qué Ventajas Ofrece la Comunicación sin Estado (Stateless) en un Servicio REST Desde la Perspectiva del Cliente?
La comunicación sin estado (stateless) en REST significa que el servidor no mantiene información sobre el estado de las solicitudes previas. Esto implica que cada solicitud es independiente y contiene toda la información necesaria para procesarla. Las ventajas desde la perspectiva del cliente incluyen:

Escalabilidad: Facilita que el sistema escale horizontalmente, ya que cada solicitud puede ser atendida por cualquier instancia del servidor sin requerir contexto previo.
Simplicidad en el Cliente: El cliente puede realizar solicitudes sin depender de estados anteriores, lo que simplifica la implementación y el manejo de la sesión.
Mayor Confiabilidad: Al no depender de un estado en el servidor, las fallas en la comunicación o la interrupción de la sesión tienen menor impacto en la interacción con el servicio.
6. ¿Por Qué es Importante la Idempotencia en las Operaciones de un Servicio REST?
La idempotencia es una propiedad que asegura que una operación aplicada varias veces tenga el mismo efecto que si se aplicara solo una vez. En servicios REST, la idempotencia es importante porque permite que los clientes repitan solicitudes sin preocuparse por duplicar acciones (por ejemplo, en caso de fallas de red o problemas de comunicación).

Las operaciones como GET, PUT, y DELETE son naturalmente idempotentes en REST, mientras que POST no lo es. La idempotencia mejora la confiabilidad del sistema y permite una experiencia más predecible y controlada para el cliente, especialmente en redes donde pueden ocurrir interrupciones o fallas intermitentes.*/
