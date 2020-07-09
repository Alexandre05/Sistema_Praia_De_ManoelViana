/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaPraia.telas;

import br.com.sistemaPraia.DAO.Conexao;
import static br.com.sistemaPraia.telas.TelaPrincipal.jPanel1;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author PC
 */
public class Reconhecimento extends javax.swing.JInternalFrame{

   private DaemonThread trend = null;
    int count = 0;
    VideoCapture webSource= null ;
    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();
    
    
     public Reconhecimento() {
        
        initComponents();
     }
    
    class DaemonThread implements Runnable{
    
    protected volatile boolean runnable = false;

    @Override
   

    public  void run()
    {
        synchronized(this)
        {
            while(runnable)
            {
                if(webSource.grab())
                {
		    	try
                        {
                            webSource.retrieve(frame);
			Imgcodecs.imencode(".bmp", frame, mem);
			    Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));

			    BufferedImage buff = (BufferedImage) im;
			    Graphics g=jPanel1.getGraphics();

			   if (g.drawImage(buff, 0, 0, 200, 200, 0, 0, buff.getWidth(), buff.getHeight(), null))
			    
			    if(runnable == false)
                            {
			    	System.out.println("Going to wait()");
			    	this.wait();
			    }
			 }
			 catch(IOException | InterruptedException ex)
                         {
			    System.out.println("Error");
                         }
                }       }
            
        
        
   
      
   

   /////////////////////////////////////////////////////////
   
   // add this line to main method
   
         // load native library of opencv
       
        } 
        
        
        }
    
   
        }
    
     
     
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneil = new javax.swing.JPanel();
        inicio = new javax.swing.JButton();
        pause = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setResizable(true);

        paneil.setPreferredSize(new java.awt.Dimension(320, 240));

        javax.swing.GroupLayout paneilLayout = new javax.swing.GroupLayout(paneil);
        paneil.setLayout(paneilLayout);
        paneilLayout.setHorizontalGroup(
            paneilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        paneilLayout.setVerticalGroup(
            paneilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        inicio.setText("Inicio");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        pause.setText("Pausa");
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });

        jMenu1.setText("Captura");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneil, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162)
                .addComponent(pause)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {inicio, pause});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(paneil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pause)
                    .addComponent(inicio))
                .addGap(0, 41, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {inicio, pause});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        // TODO add your handling code here:
        
        webSource  = new VideoCapture();
        
  trend = new DaemonThread();
  
            Thread t = new Thread(trend);
            t.setDaemon(true);
            
            trend.runnable = true;
            t.start();
			 inicio.setEnabled(false);  //start button
            pause.setEnabled(true);  // stop button
    }//GEN-LAST:event_inicioActionPerformed

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed
        // TODO add your handling code here:
        
        trend.runnable = false;
            pause.setEnabled(false);   
            inicio.setEnabled(true);
            
            webSource.release();
    }//GEN-LAST:event_pauseActionPerformed

    
   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inicio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel paneil;
    private javax.swing.JButton pause;
    // End of variables declaration//GEN-END:variables

   
    


}



