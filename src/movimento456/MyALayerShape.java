/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movimento456;

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

    public abstract void action(MyscreenPanel sp);

    public abstract void stopAction(MyscreenPanel sp);

    @Override
    public void draw(Graphics grphcs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
