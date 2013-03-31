/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movimento456;

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
 * @author Geral
 */
public final class MyscreenPanel extends ScreenPanel {
    
    Vector shapes = new Vector();
    BufferedImage[] image = null;
    private int shapePositionv = 0;
    boolean acao = false;
    int positionInicialRigth = 0;
    int positionFinalRigth = 0;
    int controle = 0;
    ControlePorta cp = new ControlePorta();
    
    public MyscreenPanel() throws Exception {
        super();
        cp.initSerial();
        this.LoadImage("./navegação.png", 0);
        this.LoadImage("./centro_clicado.png", 1);
        this.LoadImage("./cima_clicado.png", 2);
        this.LoadImage("./baixo_clicado.png", 3);
        this.LoadImage("./direito_clicado.png", 4);
        this.LoadImage("./esquerdo_clicado.png", 5);
        NewShape n = new NewShape(image[0], this);
        //inserir pontos
        this.addLayerShape(n);
    }
    
    public void LoadImage(String fileName, int i) {
        try {
            image[i] = ImageIO.read(new File(fileName));
        } catch (Exception erro) {
            System.out.println("Erro Image");
        }
    }
    
    public MyALayerShape getLayerShape(int i) {
        MyALayerShape shapeRetorno = null;
        shapeRetorno = (MyALayerShape) shapes.get(i);
        return shapeRetorno;
    }

    public int setShapePositionv(int shapePosition) {
        this.shapePositionv = shapePosition;
        return this.shapePositionv;
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
            int gRX;
            int gRY;
            int gRZ;
            int gNeckZ;
            try {
                SkeletonBone sb = KinectAccess.getSkeletonsBone();
                gRZ = (int) (sb.getBone(EBone.RIGHT_FOREARM).getJ2().getZ());
                gNeckZ = (int) (sb.getBone(EBone.NECK).getJ2().getZ());
                
                if ((gNeckZ - gRZ) > positionInicialRigth) {
                    positionInicialRigth = gNeckZ - gRZ;
                }
                
                sb = KinectAccess.getSkeletonsBone();
                gRX = (int) (sb.getBone(EBone.RIGHT_FOREARM).getJ2().getX());
                gRY = (int) (sb.getBone(EBone.RIGHT_FOREARM).getJ2().getY());
                gRZ = (int) (sb.getBone(EBone.LEFT_FOREARM).getJ2().getZ());
                gNeckZ = (int) (sb.getBone(EBone.NECK).getJ2().getZ());
                
                positionFinalRigth = gNeckZ - gRZ;
                
                if (positionFinalRigth <= (positionInicialRigth / 2) && positionFinalRigth > 0) {
                    acao = true;
                }
                
                if (acao) {
                    Point point = new Point(gRX, gRY);
                    for (int i = 2; i < 7; i++) {
                        MyALayerShape myshape = (MyALayerShape) shapes.get(i);
                        if (myshape.Contain(point)) {
                            for (int j = 2; j < 7; j++) {
                                MyALayerShape myshapeStop = (MyALayerShape) shapes.get(j);
                                if (myshapeStop.isClicado()) {
                                    System.out.println("Finalizando Ação Ativa");
                                    this.getLayerShape(j).setClicado(false);
                                    myshapeStop.stopAction(this);
                                }
                            }
                            if (!myshape.isClicado()) {
                                this.getLayerShape(i).setClicado(true);
                                myshape.action(this);
                                
                            } else {
                                this.getLayerShape(i).setClicado(false);
                                myshape.stopAction(this);
                            }
                        }
                    }
                    acao=false;
                    positionInicialRigth=positionFinalRigth;
                }
                
                
            } catch (Exception ex) {
                System.out.println("Erro");
            }
            
            this.repaint();
        }
        
    }
}
