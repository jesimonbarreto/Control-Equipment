/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerente;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import presentation.ALayerShape;

/**
 *
 * @author Geral
 */
public abstract class MyALayerShape extends ALayerShape {

    private Point[] coordinate = new Point[2];

    public MyALayerShape() throws Exception {
        super();
    }

    public void setPoint(int x, int y, int i) {
        coordinate[i] = new Point(x, y);

    }

    public Point getPoint(int i) {
        return coordinate[i];
    }

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
    public void draw(Graphics grphcs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
