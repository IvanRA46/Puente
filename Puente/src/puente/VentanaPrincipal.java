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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    private Puente puente;
    private PanelPuente panelPuente;

    public VentanaPrincipal(Puente puente) {
        this.puente = puente;

        setTitle("Simulación de Puente");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelPuente = new PanelPuente(puente);

        JButton btnEste = new JButton("Añadir Coche Este");
        btnEste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPuente.addCoche("Este");
            }
        });

        JButton btnOeste = new JButton("Añadir Coche Oeste");
        btnOeste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPuente.addCoche("Oeste");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnEste);
        buttonPanel.add(btnOeste);

        add(panelPuente, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Puente puente = new Puente();
        SwingUtilities.invokeLater(() -> new VentanaPrincipal(puente));
    }
}

