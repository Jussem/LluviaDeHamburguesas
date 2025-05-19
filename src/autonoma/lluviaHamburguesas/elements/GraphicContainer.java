package autonoma.lluviaHamburguesas.elements;

import java.awt.Graphics;

public interface GraphicContainer {
/**
     * Método para dibujar los elementos gráficos en el contenedor.
     */
    public void draw(Graphics g);

    /**
     * Método para actualizar el estado de los elementos gráficos del contenedor.
     */
    public void update();
}
