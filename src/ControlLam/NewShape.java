/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlLam;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 *
 * @author JB
 */
public class NewShape extends MyALayerShape {

    public NewShape() throws Exception {
    }
    ImageObserver imagemOb;
    BufferedImage image = null;

    public NewShape(BufferedImage image, ImageObserver thi) throws Exception {
        this.imagemOb = thi;
        this.image = image;
    }

    @Override
    public void draw(Graphics grphcs) {
        grphcs.drawImage(image, this.getPoint(0).x, this.getPoint(0).y, (this.getPoint(1).x - this.getPoint(0).x), (this.getPoint(1).y - this.getPoint(0).y), imagemOb);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean Contain(Point ponto) {
        boolean contem = false;
        if (ponto.getX() > this.getPoint(0).x && ponto.getY() > this.getPoint(0).y) {
            if (ponto.getX() < (this.getPoint(0).x + (this.getPoint(1).x - this.getPoint(0).x)) && ponto.getY() < (this.getPoint(0).y + (this.getPoint(1).y - this.getPoint(0).y))) {
                contem = true;
            }
        }
        return contem;
    }

    @Override
    public void action(int ledAcender, PortControl cp) {
       if(ledAcender==2){
           cp.enviaDados('1');
       }else{
          cp.enviaDados('3'); 
       }
    }
    @Override
    public void stopAction(int ledApagar,PortControl cp) {
       
        if(ledApagar==2){
            cp.enviaDados('2');
        }else{
            cp.enviaDados('4');
        }
    }
}
