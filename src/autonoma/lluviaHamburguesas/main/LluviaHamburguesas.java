/**
 * Clase principal que inicia la aplicación del juego Lluvia de Hamburguesas.
 * 
 * Esta clase contiene el método main que configura y muestra la ventana
 * principal del juego con los parámetros iniciales adecuados.
 *
 * @author Cristian Camilo Salazar Arenas, Juan Sebastian Lopez Guzman y Juan
 * José Morales A.
 * @version 1.0
 * @since 18/05/2025
 */
package autonoma.lluviahamburguesas.main;

import javax.swing.JFrame;
import autonoma.lluviaHamburguesas.gui.VentanaPrincipal;

public class LluviaHamburguesas {

    /**
     * Punto de entrada principal para la aplicación del juego.
     * 
     * Configura y muestra la ventana principal del juego con las siguientes
     * propiedades: - Operación de cierre: EXIT_ON_CLOSE - Título: "Lluvia de
     * Hamburguesas" - Redimensionable: false - Centrada en pantalla - Visible:
     * true
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     * @since 18/05/2025
     */
    public static void main(String[] args) {
        // Configuración de la ventana principal
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("Lluvia de Hamburguesas");
        ventana.setResizable(false);
        ventana.pack();
        ventana.setLocationRelativeTo(null);  // Centra la ventana en la pantalla
        ventana.setVisible(true);
    }
}