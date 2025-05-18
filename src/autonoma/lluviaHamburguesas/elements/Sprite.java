/**
 * Clase abstracta que representa un elemento gráfico básico en el juego
 * Lluvia de Hamburguesas. Proporciona la estructura común para todos los
 * elementos visuales del juego.
 * 
 * Esta clase define las propiedades y comportamientos básicos que comparten
 * todos los sprites del juego, como posición y capacidad de dibujado.
 * 
 *
 * @author Cristian Camilo Salazar Arenas, Juan Sebastian Lopez Guzman y Juan José Morales A.
 * @version 1.0
 * @since 18/05/2025
 */
package autonoma.lluviaHamburguesas.elements;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Sprite {

    protected int x, y;
    protected BufferedImage imagen;

    /**
     * Crea un nuevo sprite en la posición especificada.
     * 
     * @param x Coordenada horizontal inicial (en píxeles)
     * @param y Coordenada vertical inicial (en píxeles)
     * @since 18/05/2025
     */
    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Método abstracto para dibujar el sprite.
     * 
     * Las clases hijas deben implementar este método para definir
     * cómo se representa visualmente el sprite.
     * 
     * 
     * @param g El contexto gráfico donde se dibujará el sprite
     * @since 18/05/2025
     */
    public abstract void dibujar(Graphics g);

    /**
     * Verifica si el sprite contiene un punto específico.
     * 
     * Por defecto, utiliza un área rectangular de 50x50 píxeles
     * centrada en la posición del sprite para la detección.
     * 
     * 
     * @param p Punto a verificar
     * @return true si el punto está dentro del área del sprite, false en caso contrario
     * @since 18/05/2025
     */
    public boolean contiene(Point p) {
        return new Rectangle(x, y, 50, 50).contains(p);
    }

    /**
     * Obtiene la coordenada X actual del sprite.
     * 
     * @return Posición horizontal actual (en píxeles)
     * @since 18/05/2025
     */
    public int getX() {
        return x;
    }

    /**
     * Obtiene la coordenada Y actual del sprite.
     * 
     * @return Posición vertical actual (en píxeles)
     * @since 18/05/2025
     */
    public int getY() {
        return y;
    }
}