/**
 * Clase que representa la tienda/escenario principal del juego Lluvia de Hamburguesas.
 * Gestiona la generación, movimiento y colisión de los elementos del juego (hamburguesas y cigarrillos).
 * Implementa MouseListener para detectar interacciones del jugador.
 *
 * @author Cristian Camilo Salazar Arenas, Juan Sebastian Lopez Guzman y Juan José Morales A.
 * @version 1.0
 * @since 18/05/2025
 */
package autonoma.lluviaHamburguesas.elements;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Tienda extends SpriteContainer implements MouseListener {

    private List<Hamburguesa> comidas;
    private List<Cigarrillo> venenos;
    private int puntuacion;
    private Random random;
    private int maxElementos;
    private int width;
    private int height;

    /**
     * Crea una nueva tienda con las dimensiones especificadas.
     *
     * @param width Ancho del área de juego
     * @param height Alto del área de juego
     */
    public Tienda(int width, int height) {
        super(0, 0);
        this.width = width;
        this.height = height;
        comidas = new ArrayList<>();
        venenos = new ArrayList<>();
        puntuacion = 0;
        random = new Random();
        maxElementos = 4;

        iniciarHilos();
    }

    /**
     * Inicia los hilos para generación y movimiento de elementos.
     */
    private void iniciarHilos() {
        new Thread(new HiloGenerador()).start();
        new Thread(new HiloMovimiento()).start();
    }

    /**
     * Hilo encargado de generar nuevos elementos cada 2 segundos.
     */
    private class HiloGenerador implements java.lang.Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2000);
                    generarElemento();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Hilo encargado de mover los elementos cada 100ms.
     */
    private class HiloMovimiento implements java.lang.Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    moverElementos();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Genera un nuevo elemento aleatorio (hamburguesa o cigarrillo) si no se ha
     * alcanzado el máximo.
     */
    private void generarElemento() {
        if (comidas.size() + venenos.size() < maxElementos) {
            int x = random.nextInt(width - 50);
            if (random.nextBoolean()) {
                Hamburguesa hamburguesa = new Hamburguesa(x, 0);
                comidas.add(hamburguesa);
                addElement(hamburguesa);
            } else {
                Cigarrillo cigarrillo = new Cigarrillo(x, 0);
                venenos.add(cigarrillo);
                addElement(cigarrillo);
            }
        }
    }

    /**
     * Mueve todos los elementos y elimina los que salen del área visible.
     */
    private void moverElementos() {
        // Mueve y gestiona hamburguesas
        Iterator<Hamburguesa> itComidas = comidas.iterator();
        while (itComidas.hasNext()) {
            Hamburguesa hamburguesa = itComidas.next();
            hamburguesa.run();
            if (hamburguesa.getY() > height) {
                itComidas.remove();
                removeElement(hamburguesa);
            }
        }

        // Mueve y gestiona cigarrillos
        Iterator<Cigarrillo> itVenenos = venenos.iterator();
        while (itVenenos.hasNext()) {
            Cigarrillo cigarrillo = itVenenos.next();
            cigarrillo.run();
            if (cigarrillo.getY() > height) {
                itVenenos.remove();
                removeElement(cigarrillo);
            }
        }
    }

    @Override
    public void dibujar(Graphics g) {
        super.dibujar(g);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Puntaje: " + puntuacion, 10, 25);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();

        // Verifica clic en hamburguesas
        Iterator<Hamburguesa> itC = comidas.iterator();
        while (itC.hasNext()) {
            Hamburguesa c = itC.next();
            if (c.contiene(p)) {
                puntuacion++;
                itC.remove();
                removeElement(c);
                return;
            }
        }

        // Verifica clic en cigarrillos
        Iterator<Cigarrillo> itV = venenos.iterator();
        while (itV.hasNext()) {
            Cigarrillo v = itV.next();
            if (v.contiene(p)) {
                puntuacion -= 2;
                itV.remove();
                removeElement(v);
                return;
            }
        }
    }

    // Métodos no utilizados de MouseListener
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}