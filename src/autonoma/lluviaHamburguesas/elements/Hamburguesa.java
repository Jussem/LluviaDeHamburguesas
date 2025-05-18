/**
 * Clase que representa una hamburguesa que cae desde el cielo en el juego
 * Lluvia de Hamburguesas. Este elemento es beneficioso para el personaje
 * principal y debe ser recolectado.
 * 
 * Hereda de SpriteMobile para obtener capacidades de movimiento básico y
 * utiliza una imagen para su representación visual en el juego.
 * 
 *
 * @author Cristian Camilo Salazar Arenas, Juan Sebastian Lopez Guzman y Juan
 * José Morales A.
 * @version 1.0
 * @since 18/05/2025
 */
package autonoma.lluviaHamburguesas.elements;

import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Hamburguesa extends SpriteMobile {

    /**
     * Crea una nueva hamburguesa en la posición especificada.
     * 
     * Carga automáticamente la imagen de la hamburguesa desde los recursos del
     * juego. La imagen se redimensionará a 50x50 píxeles al dibujarse.
     * 
     *
     * @param x Posición horizontal inicial (en píxeles)
     * @param y Posición vertical inicial (en píxeles)
     * @since 18/05/2025
     */
    public Hamburguesa(int x, int y) {
        super(x, y);
        try {
            imagen = ImageIO.read(getClass().getResource("/autonoma/lluviaHamburguesas/images/comida.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Implementa el movimiento de caída de la hamburguesa.
     * 
     * La hamburguesa cae verticalmente a una velocidad constante de 5 píxeles
     * por actualización de frame.
     * 
     *
     * @since 18/05/2025
     */
    @Override
    public void mover() {
        y += 5;
    }

    /**
     * Dibuja la hamburguesa en el contexto gráfico especificado.
     * 
     * La imagen se dibujará en la posición actual (x,y) con un tamaño fijo de
     * 50x50 píxeles.
     * 
     *
     * @param g El contexto gráfico donde se dibujará la hamburguesa
     * @since 18/05/2025
     */
    @Override
    public void dibujar(Graphics g) {
        g.drawImage(imagen, x, y, 50, 50, null);
    }
}