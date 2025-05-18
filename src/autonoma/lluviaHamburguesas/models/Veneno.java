/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.lluviaHamburguesas.models;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author juanb
 */
public class Veneno {
    private int x, y;
    private BufferedImage imagen;

    public Veneno(int x, int y) {
        this.x = x;
        this.y = y;
        try {
            imagen = ImageIO.read(getClass().getResource("/autonoma/lluviaHamburguesas/images/veneno.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mover() {
        y += 5; // Velocidad de caída
    }

    public void dibujar(Graphics g) {
        g.drawImage(imagen, x, y, 50, 50, null);
    }

    public boolean contiene(Point p) {
        return new Rectangle(x, y, 50, 50).contains(p);
    }

    public int getY() {
        return y;
    }
}
