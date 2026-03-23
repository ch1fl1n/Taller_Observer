# Observer Pattern – Caso Práctico

## Intención

El patrón **Observer** define una relación de uno a muchos objetos, donde cuando un objeto principal cambia su estado, todos los objetos dependientes son notificados automáticamente. Esto permite que los objetos se mantengan actualizados sin consultar constantemente si hubo cambios.

## Clasificación

- Patrón de comportamiento.

## Descripción del Caso

En este proyecto se implementa el patrón Observer mediante un sistema de configuración llamado `ConfigurationManager`. Este sistema almacena configuraciones como el formato de fecha y el formato de dinero.

Cuando alguna configuración cambia, el `ConfigurationManager` notifica automáticamente a los objetos observadores (`DateFormatObserver` y `MoneyFormatObserver`), los cuales reaccionan mostrando la información actualizada en consola.

De esta forma, los observers no necesitan estar preguntando constantemente si la configuración cambió, sino que el sistema les avisa automáticamente cuando ocurre un cambio.

## Solución sin el patrón Observer

Sin el patrón Observer, cada objeto tendría que consultar constantemente si la configuración cambió, generando mucho acoplamiento entre clases y código repetido. 

Además, cada vez que se agregara un nuevo objeto interesado en la configuración, habría que modificar varias partes del sistema.

## Solución con el patrón Observer

Con el patrón Observer, existe un objeto principal (`ConfigurationManager`) que notifica automáticamente a todos los observers cuando ocurre un cambio en la configuración. 

Esto reduce el acoplamiento entre clases y permite agregar nuevos observers sin modificar el código existente.

## Ejemplo Real

Un ejemplo real del patrón Observer son las notificaciones de un celular. Cuando llega un mensaje, el sistema notifica automáticamente a las aplicaciones interesadas sin que estas tengan que revisar constantemente si hay mensajes nuevos.

## Ejecución

El proyecto se ejecuta desde la clase `ObserverMain` o utilizando Gradle:

```bash
gradle build
gradle run
```

Al ejecutar el programa, el sistema cambia la configuración varias veces y los observers muestran en consola los cambios realizados, demostrando el funcionamiento del patrón Observer.

## Conclusión

El patrón Observer permite que varios objetos dependan de uno principal y se actualicen automáticamente cuando este cambia.

Esto facilita el mantenimiento del sistema, reduce el acoplamiento entre clases y permite que el sistema sea más flexible y escalable.
