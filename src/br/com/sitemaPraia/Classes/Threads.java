/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sitemaPraia.Classes;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Threads implements Runnable{
    private String nome;
     private int tempo;
     
    public Threads(String nome, int tempo){
    this.nome = nome;
    this.tempo=tempo;
    Thread t = new Thread(this);
    t.start();
     //start();
    }

    
    
    @Override
    public void run(){
    
       
           try {
               for( int i=0; i<6; i++){
           System.out.println(nome+"contador"+i);
               Thread.sleep(tempo);
               }
           } catch (InterruptedException ex) {
               Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
           }
       
       }
    
    
    }
