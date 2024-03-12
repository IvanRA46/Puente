/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puente;

/**
 *
 * @author ivann
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelPuente extends JPanel {

    private Puente puente;
    private List<CocheGrafico> cochesGraficos;

    public PanelPuente(Puente puente) {
        this.puente = puente;
        this.cochesGraficos = new ArrayList<>();
    }

    public void addCoche(String extremo) {
        CocheGrafico coche = new CocheGrafico(extremo);
        cochesGraficos.add(coche);
        new Thread(coche).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GRAY);
        g.fillRect(0, 150, getWidth(), 100);  // Puente

        for (CocheGrafico coche : cochesGraficos) {
            coche.dibujar(g);
        }
    }

    private class CocheGrafico implements Runnable {
        private String extremo;
        private int x;
        private int y;  // Nueva variable para la posición vertical

        public CocheGrafico(String extremo) {
            this.extremo = extremo;
            if (extremo.equals("Este")) {
                this.x = 0;
                this.y = 160; 
            } else {
                this.x = getWidth();
                this.y = 190;
            }
 
        }

        @Override
        public void run() {
            try {
                if (extremo.equals("Este")) {
                    puente.cruzarDesdeEste();
                    x += 5;  // Mover hacia la derecha
                } else {
                    puente.cruzarDesdeOeste();
                    x -= 5;  // Mover hacia la izquierda
                }

                while (true) {
                    if (extremo.equals("Este")) {
                        if (x > getWidth()) {
                            break;
                        }
                    } else {
                        if (x < -30) {
                            break;
                        }
                    }

                    repaint();
                    Thread.sleep(50);

                    if (extremo.equals("Este")) {
                        x += 5;  // Mover hacia la derecha
                    } else {
                        x -= 5;  // Mover hacia la izquierda
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                puente.salirPuente();
                cochesGraficos.remove(this);
            }
        }

        public void dibujar(Graphics g) {
            if (extremo.equals("Este")) {
                g.setColor(Color.RED);  
            } else {
                g.setColor(Color.BLUE);
            }
            g.fillRect(x, y, 30, 20);
        }
    }
}





