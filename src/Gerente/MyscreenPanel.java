/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerente;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Vector;
import presentation.ALayerShape;
import presentation.impl.KinectMotionCapture.layers.ScreenPanel;

/**
 *
 * @author Geral
 */
public abstract class MyscreenPanel extends ScreenPanel {

    Vector shapes = new Vector();
    public BufferedImage[] imagem = new BufferedImage[10];
    private int shapePositionv = 0;

    public int setShapePositionv(int shapePosition) {
        this.shapePositionv = shapePosition;
        return this.shapePositionv;
    }

    @Override
    public void addLayerShape(ALayerShape shape) {
        this.shapes.add(shape);
    }

    public void addMyLayerShape(NewShape myshape) {
        this.shapes.add(myshape);
    }

    public void removerShape(int position) {
        this.shapes.remove(position);
    }

    public void substituirShape(int posicaoShapeRemover, ALayerShape shape) {
        this.removerShape(posicaoShapeRemover);
        this.addLayerShape(shape);
    }
}
