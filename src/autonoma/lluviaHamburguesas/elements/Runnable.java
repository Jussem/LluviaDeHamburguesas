/**
 * Interfaz que define el contrato básico para elementos ejecutables en el juego
 * Lluvia de Hamburguesas. Proporciona la estructura para objetos que necesitan
 * ejecutar lógica de forma independiente o en hilos separados.
 * 
 * Las clases que implementen esta interfaz deberán proporcionar su propia
 * implementación del método run() con la lógica específica a ejecutar.
 * 
 *
 * @author Cristian Camilo Salazar Arenas, Juan Sebastian Lopez Guzman y Juan José Morales A.
 * @version 1.0
 * @since 18/05/2025
 */
package autonoma.lluviaHamburguesas.elements;

public interface Runnable {
    
    /**
     * Método que contiene la lógica a ejecutar por el objeto implementador.
     * 
     * Cuando un objeto implementa esta interfaz, debe definir específicamente
     * qué acciones realizará cuando se invoque este método.
     * 
     * 
     * @since 18/05/2025
     */
    void run();
}