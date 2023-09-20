/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testthreads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class ThreadSemaforo implements Runnable{
    
    private CorSemaforo cor;
    private boolean parar;
    private boolean corMudou;
    
    public ThreadSemaforo() { //construtor//
        this.cor = CorSemaforo.VERMELHO;
        this.parar = false;
        this.corMudou = false;
        
        new Thread(this).start();
    }
    
    @Override
    public void run() {
      
        while(!parar) {
            try {
           switch (this.cor) {
               case VERMELHO:
                    Thread.sleep(3000);
                   break;
                   
               case AMARELO:
                    Thread.sleep(800);
                    break;
                    
               case VERDE:
                    Thread.sleep(3000);
                    break;
                   
                   default:
                     break;
           }  
              this.mudarCor(); 
           } catch (InterruptedException e) { //MUDAR COR
                 e.printStackTrace();
              }

           }
        
        }
    
     private synchronized void mudarCor() {
         switch (this.cor) {
             case VERMELHO:
                 this.cor = CorSemaforo.VERDE;
                 break;
             
             case AMARELO:
                 this.cor = CorSemaforo.VERMELHO;
                 break;
               
             case VERDE:
                 this.cor = CorSemaforo.AMARELO;
                 break;
              
             default: 
                 break;
         }
         this.corMudou = true;
         notify();   
     }
     
     public synchronized void esperaCorMudar() {
         while(!this.corMudou) {
           try {
             wait();  
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
             
         }
         
         this.corMudou = false;
     }
     
     public synchronized void desligarSemaforo() {
         this.parar = true;
     }
     
     public CorSemaforo getCor() {
         return cor;
     }
     
    
    }
    
     
    

