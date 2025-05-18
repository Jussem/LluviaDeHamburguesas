/**
 * Clase abstracta que representa un elemento gráfico con movimiento en el juego
 * Lluvia de Hamburguesas. Extiende la funcionalidad básica de Sprite añadiendo
 * capacidades de movimiento y ejecución en hilos independientes.
 * 
 * Proporciona la estructura base para todos los elementos móviles del juego,
 * implementando la interfaz Runnable para permitir movimiento autónomo.
 * 
 *
 * @author Cristian Camilo Salazar Arenas, Juan Sebastian Lopez Guzman y Juan
 * José Morales A.
 * @version 1.0
 * @since 18/05/2025
 */
package autonoma.lluviaHamburguesas.elements;

public abstract class SpriteMobile extends Sprite implements Runnable {

    /**
     * Velocidad base de movimiento del sprite (en píxeles por actualización)
     */
    protected int velocidad;

    /**
     * Crea un nuevo sprite móvil en la posición especificada.
     * 
     * Inicializa el sprite con una velocidad base de 5 píxeles por movimiento.
     * 
     *
     * @param x Coordenada horizontal inicial (en píxeles)
     * @param y Coordenada vertical inicial (en píxeles)
     * @since 18/05/2025
     */
    public SpriteMobile(int x, int y) {
        super(x, y);
        this.velocidad = 5;
    }

    /**
     * Implementación del método run() de la interfaz Runnable.
     * 
     * Ejecuta el movimiento del sprite cuando se opera en un hilo
     * independiente. Las clases concretas deben implementar la lógica
     * específica de movimiento.
     * 
     *
     * @since 18/05/2025
     */
    @Override
    public void run() {
        mover();
    }

    /**
     * Método abstracto que define el patrón de movimiento del sprite.
     * 
     * Cada clase concreta debe implementar su propia lógica de movimiento,
     * actualizando las coordenadas x e y según sea necesario.
     *
     * @since 18/05/2025
     */
    public abstract void mover();
}