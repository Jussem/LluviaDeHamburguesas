/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.lluviaHamburguesas.models;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author juanb
 */
public class HiloVeneno extends Thread {
    private final List<Veneno> venenos;
    private final JPanel panel;
    private final Random rand = new Random();

    public HiloVeneno(List<Veneno> venenos, JPanel panel) {
        this.venenos = venenos;
        this.panel = panel;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (venenos) {
                // Agregar nuevos elementos si hay menos de 4
                if (venenos.size() < 4) {
                    int x = rand.nextInt(panel.getWidth() - 50); // ancho de la imagen
                    venenos.add(new Veneno(x, 0));
                }

                // Mover los existentes hacia abajo
                for (int i = 0; i < venenos.size(); i++) {
                    Veneno v = venenos.get(i);
                    v.mover();

                    // Eliminar si sale de la pantalla
                    if (v.getY() > panel.getHeight()) {
                        venenos.remove(i);
                        i--;
                    }
                }
            }

            // Redibujar el panel
            panel.repaint();

            try {
                Thread.sleep(100); // controla la velocidad de movimiento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
