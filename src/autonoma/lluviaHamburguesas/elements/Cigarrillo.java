// Este es el paquete donde se encuentra la clase Cigarrillo.
package autonoma.lluviaHamburguesas.elements;

// Importamos las clases necesarias
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Clase que representa un cigarrillo que cae desde el cielo en el juego Lluvia
 * de Hamburguesas. Este elemento es dañino para el personaje principal y debe
 * ser evitado.
 * 
 * Extiende de SpriteMobile para heredar capacidades de movimiento y utiliza una
 * imagen visual para su representación gráfica.
 * 
 *
 * @author Cristian Camilo Salazar Arenas, Juan Sebastian Lopez Guzman y Juan
 * José Morales A.
 * @version 1.0
 * @since 18/05/2025
 */
public class Cigarrillo extends SpriteMobile {

    /**
     * Crea un nuevo cigarrillo en la posición especificada.
     * 
     * Carga automáticamente la imagen del cigarrillo desde los recursos del
     * juego. La imagen se redimensiona a 50x50 píxeles al dibujarse.
     * 
     *
     * @param x Posición horizontal inicial del cigarrillo
     * @param y Posición vertical inicial del cigarrillo
     * @since 18/05/2025
     */
    public Cigarrillo(int x, int y) {
        super(x, y);
        try {
            imagen = ImageIO.read(getClass().getResource("/autonoma/lluviaHamburguesas/images/veneno.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Implementa el movimiento del cigarrillo, haciéndolo caer verticalmente a
     * una velocidad constante de 5 píxeles por actualización.
     *
     * @since 18/05/2025
     */
    @Override
    public void mover() {
        y += 5;
    }

    /**
     * Dibuja el cigarrillo en el contexto gráfico proporcionado.
     * <p>
     * La imagen se dibuja en la posición actual (x,y) con un tamaño fijo de
     * 50x50 píxeles.
     * </p>
     *
     * @param g El contexto gráfico donde se dibujará el cigarrillo
     * @since 18/05/2025
     */
    @Override
    public void dibujar(Graphics g) {
        g.drawImage(imagen, x, y, 50, 50, null);
    }
}