/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Experto;

import Fabrica.FabricaHiloCalculador;
import java.util.ArrayList;

/**
 *
 * @author Tochi
 */
public class ExpertoCalculo {
    
    private FabricaHiloCalculador fabrica = new FabricaHiloCalculador();
  
    public ExpertoCalculo(){
      
    }
    
    public ArrayList crearHilos(String desde, String hasta){
        
       ArrayList arreglo = fabrica.ejecutar(desde,hasta);
       
       return arreglo;
    }
}