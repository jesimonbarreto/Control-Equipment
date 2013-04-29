/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlLam;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;
import javax.imageio.ImageIO;
import presentation.ALayerShape;
import presentation.impl.KinectMotionCapture.KinectControl.EBone;
import presentation.impl.KinectMotionCapture.KinectControl.KinectAccess;
import presentation.impl.KinectMotionCapture.KinectControl.SkeletonBone;
import presentation.impl.KinectMotionCapture.layers.ScreenPanel;

/**
 *
 * @author JB
 */
public final class MyscreenPanel extends ScreenPanel {

    Vector shapes = new Vector();
    BufferedImage image = null;
    private int shapePositionv = 0;
    boolean desenhar = false;
    boolean acao = false;
    int positionInicialLeft = 0;
    int positionFinalLeft = 0;
    int positionInicialRigth = 0;
    int positionFinalRigth = 0;
    int controle = 0;
    PortControl cp = new PortControl();

    public MyscreenPanel() {
        super();
        this.LoadImage("./lampada.png");
        cp.initSerial();
    }

    public void LoadImage(String fileName) {
        try {
            image = ImageIO.read(new File(fileName));
        } catch (Exception erro) {
            System.out.println("Erro Image");
        }
    }

    public int getShapePositionv() {
        return shapePositionv;
    }

    public void setShapePositionv(int shapePositionv) {
        this.shapePositionv = shapePositionv;
    }

    @Override
    public void addLayerShape(ALayerShape shape) {
        this.shapes.add(shape);
    }

    public void removerShape(int position) {
        this.shapes.remove(position);
    }

    @Override
    public void paint(Graphics g) {
        if (!shapes.isEmpty()) {
            super.paint(g);
            for (int a = 0; a < this.shapes.size(); a++) {
                ALayerShape shape = (ALayerShape) shapes.get(a);
                shape.draw(g);
            }
            int gx1;
            int gy1;
            int gx2;
            int gy2;
            int gz1;
            int gz2;
            int gzneck;
            try {
                SkeletonBone sb = KinectAccess.getSkeletonsBone();
                gx1 = (int) (sb.getBone(EBone.LEFT_FOREARM).getJ2().getX());
                gy1 = (int) (sb.getBone(EBone.LEFT_FOREARM).getJ2().getY());
                gz1 = (int) (sb.getBone(EBone.LEFT_FOREARM).getJ2().getZ());
                gx2 = (int) (sb.getBone(EBone.RIGHT_FOREARM).getJ2().getX());
                gy2 = (int) (sb.getBone(EBone.RIGHT_FOREARM).getJ2().getY());
                gz2 = (int) (sb.getBone(EBone.RIGHT_FOREARM).getJ2().getZ());
                gzneck = (int) (sb.getBone(EBone.NECK).getJ2().getZ());

                if ((gzneck - gz2) < 0 && (gzneck - gz1) < 0) {
                    for (int l = 2; l < this.shapes.size(); l++) {
                        this.removerShape(l);
                    }
                    controle = 0;
                    positionInicialLeft = positionFinalLeft;
                }
                if (controle == 2) {
                    controle++;
                }
                if ((gzneck - gz1) > positionInicialLeft) {
                    positionInicialLeft = gzneck - gz1;
                }
                if ((gzneck - gz2) > positionInicialRigth) {
                    positionInicialRigth = gzneck - gz2;
                }
                if (controle < 2) {
                    g.drawImage(this.image, gx1, gy1, (gx2 - gx1), (gy2 - gy1), this);
                    g.drawLine(gx1, gy1, gx1, gy2);
                    g.drawLine(gx2, gy2, gx2, gy1);
                    g.drawLine(gx1, gy1, gx2, gy1);
                    g.drawLine(gx2, gy2, gx1, gy2);
                }
                sb = KinectAccess.getSkeletonsBone();
                gz1 = (int) (sb.getBone(EBone.LEFT_FOREARM).getJ2().getZ());
                gzneck = (int) (sb.getBone(EBone.NECK).getJ2().getZ());
                gz2 = (int) (sb.getBone(EBone.RIGHT_FOREARM).getJ2().getZ());
                positionFinalLeft = gzneck - gz1;
                positionFinalRigth = gzneck - gz2;

                if (positionFinalLeft <= (positionInicialLeft / 2) && positionFinalLeft > 0 && controle < 2) {
                    desenhar = true;
                    controle++;
                }
                if (positionFinalRigth <= (positionInicialRigth / 2) && positionFinalRigth > 0 && controle > 2) {
                    acao = true;
                }
                if (desenhar) {
                    NewShape ns = new NewShape(image, this);
                    ns.setPoint(gx1, gy1, 0);
                    ns.setPoint(gx2, gy2, 1);
                    this.addLayerShape(ns);
                    desenhar = false;
                    positionInicialLeft = positionFinalLeft;
                }
                if (controle > 2) {

                    Point pontohandrigth = new Point(gx2, gy2);
                    if (acao) {
                        for (int j = 2; j < this.shapes.size(); j++) {
                            MyALayerShape shape = (MyALayerShape) this.shapes.get(j);
                            if (shape.Contain(pontohandrigth) && !shape.isClicado()) {
                                shape.action(j, cp);
                                ((MyALayerShape) this.shapes.get(j)).setClicado(true);
                            } else if (shape.Contain(pontohandrigth) && shape.isClicado()) {
                                shape.stopAction(j, cp);
                                ((MyALayerShape) this.shapes.get(j)).setClicado(false);
                            }
                        }
                        acao = false;
                        positionInicialRigth = positionFinalRigth;
                    }

                }
            } catch (Exception ex) {
                System.out.println("Erro");
            }

            this.repaint();
        }

    }
}
