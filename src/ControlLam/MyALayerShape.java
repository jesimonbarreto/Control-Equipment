/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlLam;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import presentation.ALayerShape;

/**
 *
 * @author JB
 */
public abstract class MyALayerShape extends ALayerShape {

    private Color color;
    private Point[] coordinate = new Point[2];
    private boolean within = false;
    private boolean clicado = false;

    public boolean isClicado() {
        return clicado;
    }

    public void setClicado(boolean clicado) {
        this.clicado = clicado;
    }

    public MyALayerShape() throws Exception {
        super();
    }

    public boolean isWithin() {
        return within;
    }

    public void setWithin(boolean within) {
        this.within = within;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void setPoint(int x, int y, int i) {
        coordinate[i] = new Point(x, y);

    }

    public Point getPoint(int i) {
        return coordinate[i];
    }

    public abstract boolean Contain(Point ponto);

    public abstract void action(int ledAcender,PortControl cp);

    public abstract void stopAction(int ledApagar,PortControl cp);

    @Override
    public void draw(Graphics grphcs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
