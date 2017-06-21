/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guicomecocos;

import data.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author david
 */
public class ComecocosPanel extends javax.swing.JPanel {
    
    private ComecocosFrame frame;
    
    private int anchoCelda = -1;
    
    //nuevo constructor
    public ComecocosPanel(ComecocosFrame fr) {
        this();
        frame = fr;
    }
    /**
     * Creates new form ComecocosPanel
     */
    public ComecocosPanel() {
        initComponents();
    }
    
    
    
    /**
    * Dibuja cada una de las celdas de la matriz bidimensional de la Rejilla.
    * Cada celda tendra distintos valores, y se dibujara de una manera diferente
    * @param g Graphics donde se dibujara el laberinto
    */
    public void dibujaRejilla(java.awt.Graphics g){
        int i,j;
        Laberinto laberinto=frame.getLaberinto();
        int xoffset=    (getWidth()-laberinto.getAnchura()*anchoCelda)/2;
                        //0;
        
        for(i=0;i<laberinto.getAnchura();i++){
            for(j=0;j<laberinto.getAltura();j++){
                g.setColor(Color.red);
                g.drawLine(0, 0, 0, anchoCelda);
                //para cada objeto dibujamos uno distinto
                if(laberinto.getTipoCelda(j,i) == Laberinto.VACIA){
                    //no hay nada
                } else if(laberinto.getTipoCelda(j,i) == Laberinto.PEQUENA){
                    g.setColor(Color.BLACK);
                    g.fillRect(xoffset+i*anchoCelda + anchoCelda/2,
                            j*anchoCelda + anchoCelda/2,anchoCelda/4, anchoCelda/4);
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.GRANDE){
                    g.setColor(Color.BLACK);
                    g.fillOval(xoffset+i*anchoCelda + anchoCelda/4,j*anchoCelda + anchoCelda/4,
                            anchoCelda/2, anchoCelda/2);
                    
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.PUERTA){
                        g.setColor(Color.BLACK);
                        g.drawLine(xoffset+i*anchoCelda ,j*anchoCelda + anchoCelda/2,
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda/2);
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.B){
                        g.setColor(Color.BLUE);
                        g.drawLine(xoffset+i*anchoCelda ,j*anchoCelda + anchoCelda/2,
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda/2);
                        g.drawLine(xoffset+i*anchoCelda ,j*anchoCelda + anchoCelda,
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda);                     
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.A){
                    g.setColor(Color.BLUE);
                        g.drawLine(xoffset+i*anchoCelda ,j*anchoCelda + anchoCelda/2,
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda/2);
                        g.drawLine(xoffset+i*anchoCelda ,j*anchoCelda,
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda);   
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.a || laberinto.getTipoCelda(j,i) == Laberinto.b){
                        g.setColor(Color.BLUE);
                        g.drawLine(xoffset+i*anchoCelda ,j*anchoCelda + anchoCelda/2,
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda/2);
                                             
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.I){
                        g.setColor(Color.BLUE);
                        g.drawLine(xoffset+i*anchoCelda, j*anchoCelda, 
                                xoffset+i*anchoCelda, j*anchoCelda + anchoCelda);
                        g.drawLine(xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda, 
                                xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda + anchoCelda);
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.D){
                        g.setColor(Color.BLUE);
                        g.drawLine(xoffset+i*anchoCelda + anchoCelda, j*anchoCelda, 
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda);
                        g.drawLine(xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda, 
                                xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda + anchoCelda);
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.d ||laberinto.getTipoCelda(j,i) == Laberinto.i){
                        g.setColor(Color.BLUE);
                        g.drawLine(xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda, 
                                xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda + anchoCelda);
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.UNO){
                        g.setColor(Color.BLUE);
                        //borde superior
                        g.drawLine(xoffset+i*anchoCelda ,j*anchoCelda,
                                    xoffset+i*anchoCelda + anchoCelda, j*anchoCelda);
                        //borde izquierda
                        g.drawLine(xoffset+i*anchoCelda, j*anchoCelda, 
                                xoffset+i*anchoCelda, j*anchoCelda + anchoCelda);
                        //diagonal
                        g.drawLine(xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda + anchoCelda, 
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda/2);    
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.DOS){
                        g.setColor(Color.BLUE);
                        //borde superior
                        g.drawLine(xoffset+i*anchoCelda ,j*anchoCelda,
                                    xoffset+i*anchoCelda + anchoCelda, j*anchoCelda);
                        //borde derecha
                        g.drawLine(xoffset+i*anchoCelda + anchoCelda, j*anchoCelda, 
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda);
                        //diagonal
                        g.drawLine(xoffset+i*anchoCelda, j*anchoCelda + anchoCelda/2, 
                                xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda + anchoCelda);
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.TRES){
                        g.setColor(Color.BLUE);
                        //borde inferior
                        g.drawLine(xoffset+i*anchoCelda ,j*anchoCelda + anchoCelda,
                                    xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda);
                        //borde izquierda
                        g.drawLine(xoffset+i*anchoCelda, j*anchoCelda, 
                                xoffset+i*anchoCelda, j*anchoCelda + anchoCelda);
                        //diagonal
                        g.drawLine(xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda, 
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda/2);
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.CUATRO){
                        g.setColor(Color.BLUE);
                        //borde inferior
                        g.drawLine(xoffset+i*anchoCelda ,j*anchoCelda + anchoCelda,
                                    xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda);
                        //borde derecha
                        g.drawLine(xoffset+i*anchoCelda + anchoCelda, j*anchoCelda, 
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda);
                        //diagonal
                        g.drawLine(xoffset+i*anchoCelda, j*anchoCelda + anchoCelda/2, 
                                xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda);
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.CINCO){
                        g.setColor(Color.BLUE);
                        //diagonal de UNO
                        g.drawLine(xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda + anchoCelda, 
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda/2); 
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.SEIS){
                        g.setColor(Color.BLUE);
                        //diagonal de dos
                        g.drawLine(xoffset+i*anchoCelda, j*anchoCelda + anchoCelda/2, 
                                xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda + anchoCelda);
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.SIETE){
                        g.setColor(Color.BLUE);
                        //diagonal de tres
                        g.drawLine(xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda, 
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda/2);
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.OCHO){
                        g.setColor(Color.BLUE);
                        //diagonal de CUATRO
                        g.drawLine(xoffset+i*anchoCelda, j*anchoCelda + anchoCelda/2, 
                                xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda);
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.e){
                        g.setColor(Color.BLUE);
                        //diagonal de UNO
                        g.drawLine(xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda + anchoCelda, 
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda/2); 
                        //borde superior
                        g.drawLine(xoffset+i*anchoCelda ,j*anchoCelda,
                                    xoffset+i*anchoCelda + anchoCelda, j*anchoCelda);
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.f){
                        g.setColor(Color.BLUE);
                        //diagonal de dos
                        g.drawLine(xoffset+i*anchoCelda, j*anchoCelda + anchoCelda/2, 
                                xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda + anchoCelda);
                        //borde superior
                        g.drawLine(xoffset+i*anchoCelda ,j*anchoCelda,
                                    xoffset+i*anchoCelda + anchoCelda, j*anchoCelda);
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.g){
                        g.setColor(Color.BLUE);
                        //diagonal de tres
                        g.drawLine(xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda, 
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda/2);
                        //borde izquierda
                        g.drawLine(xoffset+i*anchoCelda, j*anchoCelda, 
                                xoffset+i*anchoCelda, j*anchoCelda + anchoCelda);
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.h){
                        g.setColor(Color.BLUE);
                        //diagonal de UNO
                        g.drawLine(xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda + anchoCelda, 
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda/2);
                        //borde izquierda
                        g.drawLine(xoffset+i*anchoCelda, j*anchoCelda, 
                                xoffset+i*anchoCelda, j*anchoCelda + anchoCelda);
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.m){
                        g.setColor(Color.BLUE);
                        //diagonal de CUATRO
                        g.drawLine(xoffset+i*anchoCelda, j*anchoCelda + anchoCelda/2, 
                                xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda);
                        //borde derecha
                        g.drawLine(xoffset+i*anchoCelda + anchoCelda, j*anchoCelda, 
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda);
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.n){
                        g.setColor(Color.BLUE);
                        //diagonal de dos
                        g.drawLine(xoffset+i*anchoCelda, j*anchoCelda + anchoCelda/2, 
                                xoffset+i*anchoCelda + anchoCelda/2, j*anchoCelda + anchoCelda);
                        //borde derecha
                        g.drawLine(xoffset+i*anchoCelda + anchoCelda, j*anchoCelda, 
                                xoffset+i*anchoCelda + anchoCelda, j*anchoCelda + anchoCelda);
                }
                
                
            }
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        if(frame==null || frame.getLaberinto()==null)
            return;
        if(anchoCelda==-1){
            anchoCelda=Math.min(getWidth()/frame.getLaberinto().getAnchura(),
            (getHeight()-10)/frame.getLaberinto().getAltura());
        }
        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(),getHeight());
        dibujaRejilla(g);
        dibujaCoco(frame.getComecocos(),g);
    }
    
    /**
    * Dibuja la Figura coco en el Graphics g pasado como par´ametro 
    * (normalmente el asociado a este Canvas)
    * @param coco la Figura a dibujar
    * @param el Graphics donde se dibujaría
    */
    void dibujaCoco(Comecocos coco,java.awt.Graphics g){
        if (coco!=null){
            Elemento elemento;
            Laberinto laberinto=frame.getLaberinto();
            int xoffset=(getWidth()-laberinto.getAnchura()*anchoCelda)/2;
                
            g.setColor(Color.YELLOW);
            g.fillOval(xoffset + coco.getX() * anchoCelda, coco.getY() * anchoCelda, 
                       anchoCelda, anchoCelda);
            
            //dibujamos la boca
            if(coco.getDireccion() == -1){
                g.setColor(Color.BLACK);
                g.drawLine(xoffset + coco.getX()*anchoCelda + anchoCelda/2, coco.getY()*anchoCelda + anchoCelda/2,
                        xoffset + coco.getX()*anchoCelda + anchoCelda, coco.getY()*anchoCelda + anchoCelda/2);
            }
            
            else if(coco.getDireccion() == Comecocos.ABAJO){
                if(coco.getBoca()){
                    g.setColor(Color.BLACK);
                    int xPoints[]={xoffset+coco.getX()*anchoCelda + anchoCelda/2,
                            xoffset + coco.getX()*anchoCelda + anchoCelda/2,
                            xoffset + coco.getX()*anchoCelda + anchoCelda/2 + anchoCelda/4};
                    int yPoints[]={coco.getY()*anchoCelda + anchoCelda/2,
                            coco.getY()*anchoCelda+anchoCelda,
                            coco.getY()*anchoCelda+anchoCelda - anchoCelda/6};
                    g.fillPolygon(xPoints, yPoints, 3);
                    coco.setBoca(false);
                }else{
                    g.setColor(Color.BLACK);
                    g.drawLine(xoffset+coco.getX()*anchoCelda + anchoCelda/2, coco.getY()*anchoCelda + anchoCelda/2,
                            xoffset + coco.getX()*anchoCelda + anchoCelda/2, coco.getY()*anchoCelda+anchoCelda);
                    coco.setBoca(true);
                }
            }
                
                
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(28, 31));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ComecocosPanel.this.mouseEntered(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComecocosPanel.this.keyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void keyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyPressed
       
        if (evt.getKeyCode() == KeyEvent.VK_W) {
            if(!frame.getLaberinto().seChoca(frame.getComecocos(), Comecocos.ARRIBA))
            frame.getComecocos().setDireccion(Comecocos.ARRIBA);
        } else if (evt.getKeyCode() == KeyEvent.VK_S) {
            if(!frame.getLaberinto().seChoca(frame.getComecocos(), Comecocos.ABAJO))
            frame.getComecocos().setDireccion(Comecocos.ABAJO);
        } else if (evt.getKeyCode() == KeyEvent.VK_D) {
            if(!frame.getLaberinto().seChoca(frame.getComecocos(), Comecocos.DERECHA))
            frame.getComecocos().setDireccion(Comecocos.DERECHA);
        }else if (evt.getKeyCode() == KeyEvent.VK_A) {
            if(!frame.getLaberinto().seChoca(frame.getComecocos(), Comecocos.IZQUIERDA))
            frame.getComecocos().setDireccion(Comecocos.IZQUIERDA);
        } 
    }//GEN-LAST:event_keyPressed

    private void mouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseEntered
        requestFocus();
    }//GEN-LAST:event_mouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
