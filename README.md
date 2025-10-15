# Sistema de Batallas de Criaturas

Proyecto de ejemplo en Java que modela un sistema sencillo de combates entre criaturas (guerreros, magos, dragones). Incluye clases básicas para representar armas, criaturas y comportamientos especiales (volar, magia) y una clase `Main` que simula batallas entre instancias.

## Contenido

- `src/main/java/juego` — paquete principal con la clase `Main` que ejecuta simulaciones.
- `src/main/java/juego/modelo` — modelos de dominio:
	- `Criatura` (abstracta): atributos comunes (nombre, salud, fuerza) y métodos base.
	- `Arma`: representa un arma con daño adicional.
	- `Guerrero`: criatura cuerpo a cuerpo que usa `Arma`.
	- `Mago`: criatura mágica que implementa la interfaz `Magico`.
	- `Dragon`: criatura que implementa `Volador` y tiene daño aumentado.
	- `Magico` (interface): define comportamiento mágico.
	- `Volador` (interface): define comportamiento de vuelo.

## Objetivo

Servir como ejemplo educativo de diseño orientado a objetos en Java: herencia, interfaces, polimorfismo y simple simulación por turnos.

## Contrato y comportamiento (resumen)

- Criatura:
	- Constructor: `Criatura(String nombre, int salud, int fuerza)`.
	- Métodos clave: `void atacar(Criatura objetivo)`, `void defender(int daño)`, `boolean estaViva()`, getters para nombre, salud y fuerza.

- Arma:
	- Constructor: `Arma(String nombre, int dañoAdicional)`.
	- Método: `int getDañoAdicional()` y `String getNombre()`.

- Guerrero:
	- Usa un `Arma` para aumentar su daño en `atacar`.

- Mago:
	- Implementa `Magico` con métodos `lanzarHechizo` y `aprenderHechizo`.
	- Usa también un `Arma` (por ejemplo, bastón) y su ataque combina fuerza + daño del arma.

- Dragon:
	- Implementa `Volador`.
	- Su ataque multiplica la fuerza y suma daño del arma si la tiene.
	- `defender` aplica una reducción de daño (ej. 10% por las escamas).

## Ejemplo de uso (lo que hace `Main`)

En `Main.main` se crean ejemplos:

- `Arma espada = new Arma("espada legendaria", 10);`
- `Guerrero guerrero = new Guerrero("Gaia el caballero feroz", 100, 15, espada);`
- `Dragon dragon = new Dragon("Dragón negro de ojos rojos", 120, 20, "negras", garra);`
- `Mago mago = new Mago("Mago oscuro", 80, 18, "bola de fuego", new Arma("bastón mágico", 6));`

Luego `Main.simularBatalla(guerrero, dragon)` y `Main.simularBatalla(mago, dragon)` ejecutan simulaciones por turnos mostrando la salida por consola con el progreso de la batalla y el vencedor.

## Cómo compilar y ejecutar (Windows, cmd.exe)

Requisitos:

- Java JDK (8+). Verifica con `java -version` y `mvn -v` si usas Maven.
- Maven (el proyecto contiene `pom.xml`).

Compilar el proyecto con Maven (en la raíz del proyecto):

```cmd
mvn clean package
```

Esto generará los artefactos en la carpeta `target/`, incluyendo un JAR con dependencias (`-jar-with-dependencies.jar`).

Ejecutar la aplicación desde la línea de comandos:

```cmd
java -jar target\sistema-batallas-criaturas-1.0-SNAPSHOT-jar-with-dependencies.jar
```

O ejecutar directamente la clase Main sin empaquetar (si está el classpath correcto):

```cmd
mvn exec:java -Dexec.mainClass="juego.Main"
```

Nota: si `mvn exec:java` no está configurado en el `pom.xml`, empaqueta primero con `mvn package` y luego ejecuta el JAR.

## Ejecutar tests

El proyecto ya contiene tests bajo `test/`. Ejecuta:

```cmd
mvn test
```

Los reportes se generarán en `target/surefire-reports/`.

## Ejemplo de salida esperada (resumen)

La ejecución imprime por consola los turnos de la batalla, ataques, defensa, salud restante y el resultado final indicando qué criatura ganó.

Fragmento de ejemplo:

```
=== ¡Comienza la batalla entre Gaia el caballero feroz y el Dragón negro de ojos rojos! ===

Turno 1

--- Gaia el caballero feroz ---
Gaia el caballero feroz ataca con su espada legendaria causando 25 de daño!
Dragón negro de ojos rojos usa sus escamas negras para reducir el daño. Salud restante: 95

--- Dragón negro de ojos rojos ---
Dragón negro de ojos rojos lanza fuego con sus escamas negras a Gaia el caballero feroz, causando 40 de daño!
Gaia el caballero feroz recibe 40 de daño. Salud restante: 60

... (turnos siguientes) ...

Gaia el caballero feroz ha ganado la batalla!
```

## Extensiones y mejoras sugeridas

- Añadir más tipos de habilidades y hechizos con efectos (curación, daño por turno, aturdimiento).
- Sistemizar estadísticas y críticos (probabilidades, resistencias por tipo).
- Añadir interfaz gráfica o web para visualizar las batallas.


