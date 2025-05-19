/**
 * Clase que representa un contenedor de elementos gráficos (sprites) en el juego
 * Lluvia de Hamburguesas. Permite agrupar y gestionar múltiples elementos
 * visuales como una única entidad.
 * 
 * Hereda de Sprite para tener capacidad de dibujado y posicionamiento, e
 * implementa GraphicContainer para proveer funcionalidad de contenedor.
 * 
 *
 * @author Cristian Camilo Salazar Arenas, Juan Sebastian Lopez Guzman y Juan
 * José Morales A.
 * @version 1.0
 * @since 18/05/2025
 */
package autonoma.lluviaHamburguesas.elements;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class SpriteContainer extends Sprite implements GraphicContainer {

    /**
     * Lista que contiene los elementos gráficos agrupados en este contenedor.
     */
    protected List<Sprite> elements;

    /**
     * Crea un nuevo contenedor de sprites en la posición especificada.
     *
     * @param x Coordenada horizontal inicial (en píxeles)
     * @param y Coordenada vertical inicial (en píxeles)
     * @since 18/05/2025
     */
    public SpriteContainer(int x, int y) {
        super(x, y);
        elements = new ArrayList<>();
    }

    /**
     * Dibuja todos los elementos contenidos en este contenedor.
     * 
     * Recorre la lista de elementos y llama a su método dibujar() en orden.
     * 
     *
     * @param g El contexto gráfico donde se dibujarán los elementos
     * @since 18/05/2025
     */
    @Override
    public void dibujar(Graphics g) {
        for (Sprite element : elements) {
            element.dibujar(g);
        }
    }

    /**
     * Agrega un nuevo elemento gráfico al contenedor.
     *
     * @param element El sprite que se agregará al contenedor
     * @since 18/05/2025
     */
    public void addElement(Sprite element) {
        elements.add(element);
    }

    /**
     * Elimina un elemento gráfico del contenedor.
     *
     * @param element El sprite que se eliminará del contenedor
     * @since 18/05/2025
     */
    public void removeElement(Sprite element) {
        elements.remove(element);
    }

    /**
     * Obtiene la lista de todos los elementos contenidos.
     *
     * @return Lista inmutable con los sprites contenidos
     * @since 18/05/2025
     */
    public List<Sprite> getElements() {
        return elements;
    }

    @Override
    public void draw(Graphics g) {
        dibujar(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update() {
        for (Sprite element : elements) {
            if (element instanceof SpriteMobile) {
                ((SpriteMobile) element).mover(); 
            }
        }
    } // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}