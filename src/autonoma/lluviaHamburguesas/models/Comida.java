/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.lluviaHamburguesas.models;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author juanb
 */
public class Comida {
    private int x, y;
    BufferedImage imagen;
    
    public Comida(int x, int y){
        this.x=x;
        this.y=y;
        try {
            imagen=ImageIO.read(getClass().getResource("/autonoma/lluviaHamburguesas/images/comida.png"));
        } catch (Exception e) {
        }       
}
    public void mover() {
        y += 5;
    }

    public void dibujar(Graphics g) {
        g.drawImage(imagen, x, y, 50, 50, null);
    }

    public boolean contiene(Point p) {
        return new Rectangle(x, y, 50, 50).contains(p);
    }
}
