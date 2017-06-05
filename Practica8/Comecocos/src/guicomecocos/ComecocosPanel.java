/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guicomecocos;

import data.*;
import java.awt.*;

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
    * Cada celda puede estar ocupada por BLOQUE (muro exterior) o PIEZA
    * (elemento de una Figura)
    * @param g Graphics donde se dibujara el laberinto
    */
    public void dibujaRejilla(java.awt.Graphics g){
        int i,j;
        Laberinto laberinto=frame.getLaberinto();
        int xoffset=    (getWidth()-laberinto.getAnchura()*anchoCelda)/2;
                        //0;
        
        for(i=0;i<laberinto.getAnchura();i++){
            for(j=0;j<laberinto.getAltura();j++){
                if(laberinto.getTipoCelda(j,i) == Laberinto.BLOQUE){
                    g.setColor(Color.BLUE);
                    g.fillRect(xoffset+i*anchoCelda,j*anchoCelda,anchoCelda,
                    anchoCelda);
                } else if(laberinto.getTipoCelda(j,i) == Laberinto.PEQUENA){
                    g.setColor(Color.BLACK);
                    g.fillRect(xoffset+i*anchoCelda + anchoCelda/2,j*anchoCelda + anchoCelda/2,anchoCelda/4,
                    anchoCelda/4);
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.GRANDE){
                    g.setColor(Color.BLACK);
                    g.fillRect(xoffset+i*anchoCelda + anchoCelda/4,j*anchoCelda + anchoCelda/4,anchoCelda/2,
                    anchoCelda/2);
                    
                }   else if(laberinto.getTipoCelda(j,i) == Laberinto.PUERTA){
                        g.setColor(Color.BLACK);
                        g.drawLine(xoffset+i*anchoCelda ,j*anchoCelda,xoffset+i*anchoCelda + anchoCelda,
                        j*anchoCelda);
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
        dibujaFigura(frame.getComecocos(),g);
    }
    
    /**
    * Dibuja la Figura fig en el Graphics g pasado como par´ametro
    * (normalmente el asociado a este Canvas)
    * @param fig la Figura a dibujar
    * @param el Graphics donde se dibujar´a
    */
    void dibujaFigura(Comecocos fig,java.awt.Graphics g){
        if (fig!=null){
            Elemento elemento;
            Laberinto laberinto=frame.getLaberinto();
            int xoffset=(getWidth()-laberinto.getAnchura()*anchoCelda)/
            2+fig.getX()*anchoCelda;
            int yoffset=fig.getY()*anchoCelda;
                
                g.setColor(Color.YELLOW);
                g.fillRect(xoffset+fig.getX()*anchoCelda,
                yoffset+fig.getY()*anchoCelda,anchoCelda,anchoCelda);
                //g.setColor(Color.BLACK);
                //g.drawRect(xoffset+elemento.getColumna()*anchoCelda,
                //yoffset+elemento.getFila()*anchoCelda, anchoCelda,anchoCelda);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
