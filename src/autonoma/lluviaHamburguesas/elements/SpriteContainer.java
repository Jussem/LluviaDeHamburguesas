package autonoma.lluviaHamburguesas.elements;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un contenedor de elementos gráficos (sprites) en el juego
 * <strong>Lluvia de Hamburguesas</strong>. Permite agrupar y gestionar múltiples elementos
 * visuales como una única entidad lógica.
 * <p>
 * Hereda de {@link Sprite} para tener capacidades de dibujo y posicionamiento,
 * e implementa {@link GraphicContainer} para ofrecer funcionalidad de contenedor.
 * </p>
 * 
 * Esta clase permite manejar grupos de sprites, actualizarlos en conjunto y
 * renderizarlos en una sola llamada gráfica.
 * 
 * @author Cristian Camilo Salazar Arenas,
 *         Juan Sebastian López Guzmán,
 *         Juan José Morales A.
 * @version 1.0
 * @since 18/05/2025
 */
public class SpriteContainer extends Sprite implements GraphicContainer {

    /**
     * Lista de elementos gráficos agrupados dentro de este contenedor.
     */
    protected List<Sprite> elements;

    /**
     * Constructor que inicializa el contenedor en una posición específica.
     *
     * @param x Coordenada horizontal (en píxeles) donde se ubicará el contenedor.
     * @param y Coordenada vertical (en píxeles) donde se ubicará el contenedor.
     * @since 18/05/2025
     */
    public SpriteContainer(int x, int y) {
        super(x, y);
        elements = new ArrayList<>();
    }

    /**
     * Dibuja todos los sprites contenidos en este contenedor.
     * <p>
     * Este método se encarga de recorrer la lista de elementos y llamar
     * al método {@code dibujar()} de cada sprite, en el orden en que fueron agregados.
     * </p>
     *
     * @param g Contexto gráfico sobre el cual se realizarán los dibujos.
     * @since 18/05/2025
     */
    @Override
    public void dibujar(Graphics g) {
        for (Sprite element : elements) {
            element.dibujar(g);
        }
    }

    /**
     * Agrega un nuevo sprite al contenedor.
     *
     * @param element Sprite que se desea incluir dentro del contenedor.
     * @since 18/05/2025
     */
    public void addElement(Sprite element) {
        elements.add(element);
    }

    /**
     * Elimina un sprite previamente agregado al contenedor.
     *
     * @param element Sprite que se desea eliminar del contenedor.
     * @since 18/05/2025
     */
    public void removeElement(Sprite element) {
        elements.remove(element);
    }

    /**
     * Devuelve la lista actual de sprites contenidos.
     *
     * @return Lista con los sprites que conforman el contenedor.
     * @since 18/05/2025
     */
    public List<Sprite> getElements() {
        return elements;
    }

    /**
     * Llama al método {@code dibujar(Graphics)} para mantener compatibilidad
     * con interfaces gráficas estándar.
     *
     * @param g Contexto gráfico donde se realizará el renderizado.
     */
    @Override
    public void draw(Graphics g) {
        dibujar(g);
    }

    /**
     * Actualiza el estado de los elementos contenidos.
     * <p>
     * Este método recorre todos los sprites y, si alguno es instancia de
     * {@link SpriteMobile}, llama a su método {@code mover()} para actualizar su posición.
     * </p>
     *
     * @since 18/05/2025
     */
    @Override
    public void update() {
        for (Sprite element : elements) {
            if (element instanceof SpriteMobile) {
                ((SpriteMobile) element).mover();
            }
        }
    }
}
