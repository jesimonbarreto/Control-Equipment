/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerente;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import presentation.ALayerShape;

/**
 *
 * @author Geral
 */
public class NewShape extends MyALayerShape {

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
}
