/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testthreads;

//SIMULADOR DE SEMAFORO

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestThreads {

    public static void main(String[] args) {
        
      ThreadSemaforo semaforo = new ThreadSemaforo();  
        
      for (int i=0; i<7; i++) {
          System.out.println(semaforo.getCor());
          semaforo.esperaCorMudar();
      }
        
      semaforo.desligarSemaforo();
    }
}
