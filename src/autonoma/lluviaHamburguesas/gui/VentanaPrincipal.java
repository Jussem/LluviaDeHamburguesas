package autonoma.lluviaHamburguesas.gui;

import autonoma.lluviaHamburguesas.elements.Tienda;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Clase que representa la ventana principal del juego <strong>Lluvia de Hamburguesas</strong>.
 * <p>
 * Esta clase extiende {@link javax.swing.JFrame} y es responsable de iniciar la interfaz gráfica
 * del juego, crear el entorno de dibujo y ejecutar el bucle de redibujado.
 * </p>
 *
 * <p>Contiene un panel de juego personalizado donde se dibujan los elementos visuales de la tienda,
 * y gestiona la interacción con el mouse del usuario.</p>
 * 
 * @author
 * Cristian Camilo Salazar Arenas,  
 * Juan Sebastián López Guzmán,  
 * Juan José Morales A.
 * 
 * @version 1.0
 * @since 18/05/2025
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Objeto principal del juego que contiene la lógica y los elementos visuales.
     */
    private Tienda tienda;

    /**
     * Constructor de la ventana principal. Inicializa los componentes gráficos
     * y lanza el método {@code iniciarJuego()} para comenzar el juego.
     */
    public VentanaPrincipal() {
        initComponents();
        iniciarJuego();
    }

    /**
     * Método que inicializa y configura la lógica principal del juego.
     * <ul>
     * <li>Instancia el objeto {@link Tienda}.</li>
     * <li>Crea un panel personalizado para el dibujo gráfico.</li>
     * <li>Agrega el panel al contenedor generado automáticamente.</li>
     * <li>Inicia un hilo que repinta el panel continuamente (~30 FPS).</li>
     * </ul>
     */
    private void iniciarJuego() {
        tienda = new Tienda(800, 600);

        // Panel personalizado que dibuja la tienda
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                tienda.dibujar(g); // Dibuja todos los elementos del juego
            }
        };

        panel.setBackground(new java.awt.Color(173, 216, 230)); // Azul claro
        panel.setOpaque(true);
        panel.setPreferredSize(new java.awt.Dimension(800, 600));
        panel.addMouseListener(tienda); // Se asigna la tienda como escuchador de eventos de ratón

        // Inserta el panel en el contenedor generado
        PanelJuego.setLayout(new java.awt.BorderLayout());
        PanelJuego.add(panel);

        // Bucle de redibujado en un hilo separado (~30 FPS)
        new Thread(() -> {
            while (true) {
                panel.repaint(); // Redibuja el panel
                try {
                    Thread.sleep(30); // Espera para lograr ~30 cuadros por segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Método generado automáticamente por NetBeans para inicializar los componentes gráficos.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelJuego = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelJuego.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelJuegoLayout = new javax.swing.GroupLayout(PanelJuego);
        PanelJuego.setLayout(PanelJuegoLayout);
        PanelJuegoLayout.setHorizontalGroup(
            PanelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        PanelJuegoLayout.setVerticalGroup(
            PanelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelJuego;
    // End of variables declaration//GEN-END:variables
}
