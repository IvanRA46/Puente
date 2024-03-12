/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package puente;

/**
 *
 * @author ivann
 */
import java.util.concurrent.Semaphore;

import java.util.concurrent.Semaphore;

public class Puente {

    private int cochesEnPuente = 0;
    private int cochesEste = 0;
    private int cochesOeste = 0;

    private final Semaphore semaphore = new Semaphore(1);

    public void cruzarDesdeEste() throws InterruptedException {
        semaphore.acquire();
        cochesEnPuente++;
        cochesEste++;
    }

    public void cruzarDesdeOeste() throws InterruptedException {
        semaphore.acquire();
        cochesEnPuente++;
        cochesOeste++;
    }

    public void salirPuente() {
        cochesEnPuente--;
        semaphore.release();
    }

    public int getCochesEste() {
        return cochesEste;
    }

    public int getCochesOeste() {
        return cochesOeste;
    }
}

