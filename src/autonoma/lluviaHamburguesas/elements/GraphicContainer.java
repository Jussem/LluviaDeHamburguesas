package autonoma.lluviaHamburguesas.elements;

import java.awt.Graphics;

/**
 * Interfaz que define el comportamiento básico de un contenedor gráfico en el
 * juego <strong>Lluvia de Hamburguesas</strong>.
 * <p>
 * Cualquier clase que implemente esta interfaz debe ser capaz de
 * representar gráficamente sus elementos y actualizar su estado
 * de forma periódica (por ejemplo, en cada fotograma del juego).
 * </p>
 *
 * @author
 * Cristian Camilo Salazar Arenas,  
 * Juan Sebastian López Guzmán,  
 * Juan José Morales A.
 * 
 * @version 1.0
 * @since 18/05/2025
 */
public interface GraphicContainer {

    /**
     * Dibuja todos los elementos gráficos contenidos en el contenedor.
     * <p>
     * Este método recibe el contexto gráfico sobre el cual se deben renderizar
     * los elementos. Su implementación específica dependerá de cada clase que
     * implemente esta interfaz.
     * </p>
     *
     * @param g Objeto {@link Graphics} proporcionado por el sistema para realizar dibujos en pantalla.
     */
    public void draw(Graphics g);

    /**
     * Actualiza el estado de los elementos gráficos del contenedor.
     * <p>
     * Este método se llama típicamente en cada ciclo de actualización del juego
     * para mover o modificar elementos según la lógica definida.
     * </p>
     */
    public void update();
}
