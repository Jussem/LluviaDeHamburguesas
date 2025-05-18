package autonoma.lluviaHamburguesas.models;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author juanb
 */
public class Juego extends JPanel implements MouseListener {
    private List<Comida> comidas = new ArrayList<>();
    private List<Veneno> venenos = new ArrayList<>();
    private int puntuacion = 0;

    public Juego() {
        setPreferredSize(new Dimension(800, 600));
        addMouseListener(this);
        new HiloComida(comidas, this).start();
        new HiloVeneno(venenos, this).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Comida c : comidas) c.dibujar(g);
        for (Veneno v : venenos) v.dibujar(g);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Puntaje: " + puntuacion, 10, 25);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        Iterator<Comida> itC = comidas.iterator();
        while (itC.hasNext()) {
            Comida c = itC.next();
            if (c.contiene(p)) {
                puntuacion++;
                itC.remove();
                repaint();
                return;
            }
        }
        Iterator<Veneno> itV = venenos.iterator();
        while (itV.hasNext()) {
            Veneno v = itV.next();
            if (v.contiene(p)) {
                puntuacion -= 2;
                itV.remove();
                repaint();
                return;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {} 
    @Override
    public void mouseReleased(MouseEvent e) {} 
    @Override
    public void mouseEntered(MouseEvent e) {}  
    @Override
    public void mouseExited(MouseEvent e) {}   
}
