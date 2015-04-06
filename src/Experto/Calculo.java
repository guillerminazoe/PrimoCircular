/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 
 */
package Experto;

import java.util.concurrent.Callable;

/**
 *
 * @author Tochi
 */
public class Calculo implements Callable<Integer> {

    private int numero;

    public Calculo(int i) {
        this.numero = i;
    }

    public boolean esPrimo(int num) {

        boolean primo = true;
        if (numero == 0) {
            return false;
        }
        
        int divisor = 2;
        while (primo && divisor < num) {
            if (num % divisor == 0) {
                primo = false;
            } else {
                divisor++;
            }
        }
        return primo;
    }

    public boolean esPrimoCircular(int numero) {
        int[] numArray = this.convertirArray(numero);
        int num;
        for (int j = 0; j < numArray.length - 1; j++) {
            num = this.rotar(numArray);
            if (!esPrimo(num)) {
                return false;
            }
        }
        return true;
    }

    public int rotar(int[] numero) {

        String strRet = "";
        int primero = numero[0];
        int x = 0;
        for (x = 0; x < numero.length - 1; x++) {
            numero[x] = numero[x + 1];
        }
        numero[x] = primero;
        for (int i : numero) {
            strRet += Integer.toString(i);
        }
        return Integer.parseInt(strRet);
    }

    public int[] convertirArray(int numero) {
        String temp = Integer.toString(numero);
        String temp2;
        int[] numArray = new int[temp.length()];
        for (int i = 0; i <= temp.length() - 1; i++) {
            if (i != temp.length()) {
                temp2 = temp.substring(i, i + 1);
            } else {
                temp2 = temp.substring(i);
            }
            int temp3 = Integer.parseInt(temp2);
            numArray[i] = temp3;
        }
        return numArray;
    }

    @Override
    public Integer call() throws Exception {
        boolean primo = this.esPrimo(numero);
        if (primo) {
            if (esPrimoCircular(numero)) {
                System.out.println("Primo circular" + "=" + numero);
                
                return numero;
            }
        }
        return 0;
    }
}