/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica;

import Experto.Calculo;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Tochi
 */
public class FabricaHiloCalculador {

    private ThreadPoolExecutor executor;
    private ArrayList<Future<Integer>> a = new ArrayList<Future<Integer>>();

    public FabricaHiloCalculador() {
    }

    public ArrayList<Future<Integer>> ejecutar(String desde, String hasta) {

        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        int d = Integer.parseInt(desde);
        int h = Integer.parseInt(hasta);

        for (int i = d; i <= h; i++) {
            Calculo calculador = new Calculo(i);
            Future<Integer> b = executor.submit(calculador);
            try {
                if (!(b.get() == 0)) {
                    a.add(b);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        while (executor.getCompletedTaskCount() <h) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return a;
    }
}
//int cores = Runtime.getRuntime().availableProcessors();

