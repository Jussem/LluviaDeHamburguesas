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
public class HiloComida extends Thread {
    private List<Comida> comidas;
    private JPanel panel;

    public HiloComida(List<Comida> comidas, JPanel panel) {
        this.comidas = comidas;
        this.panel = panel;
    }

    public void run() {
        while (true) {
            if (comidas.size() < 4)
                comidas.add(new Comida(new Random().nextInt(750), 0));
            for (Comida c : comidas)
                c.mover();
            panel.repaint();
            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }
    }
}

