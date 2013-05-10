package UsingManagerGA.ControlTV;

import Manager.Panel.*;
import Manager.Arduino.PortControl;
import Manager.GesturesStandards.HandsBackwards;
import Manager.GesturesStandards.HandsUp;
import Manager.ManagerG.ManagerGA;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;
import javax.imageio.ImageIO;
import org.OpenNI.Point3D;
import presentation.ALayerShape;
import presentation.impl.KinectMotionCapture.KinectControl.EBone;
import presentation.impl.KinectMotionCapture.KinectControl.KinectAccess;
import presentation.impl.KinectMotionCapture.KinectControl.SkeletonBone;

/**
 *
 * @author JB
 */
public final class MyscreenPanel extends Manager.Panel.MyscreenPanel {

    private Vector shapes = new Vector();
    private BufferedImage image = null;
    private int shapePositionv = 0;
    private Point3D mao, pesc, maoJ1, maoL;
    private int maoX, maoY, maoZ, pescX, pescY, pescZ, maoYJ1, maoXJ1, maoZJ1, maoLx, maoLy, maoLz;
    private PortControl cp = new PortControl();
    private ManagerGA gerente = new ManagerGA(this);
    public NewShape ns = null;

    public MyscreenPanel() throws Exception {
        super();
        inserindo();
        this.LoadImage("./navegação.png");
        ns = new NewShape(image, this, 370, 350, 200, 290);
    }

    @Override
    public void LoadImage(String fileName) {
        try {
            image = ImageIO.read(new File(fileName));
        } catch (Exception erro) {
            System.out.println("Erro Image");
        }
    }

    @Override
    public BufferedImage getImage() {
        return this.image;
    }

    public MyALayerShape getLayerShape(int i) {
        MyALayerShape shapeRetorno = null;
        shapeRetorno = (MyALayerShape) shapes.get(i);
        return shapeRetorno;
    }

    public void inserindo() {
        HandsBackwards hb = new HandsBackwards();
        gerente.addGestures(hb);
        AHandsBackwards ahb = new AHandsBackwards();
        gerente.addAction("HandsBackwards", ahb);
        HandsUp hu = new HandsUp();
        gerente.addGestures(hu);
        AHandsUp ahu = new AHandsUp();
        gerente.addAction("HandsUp", ahu);

    }

    @Override
    public int setShapePositionv(int shapePosition) {
        this.shapePositionv = shapePosition;
        return this.shapePositionv;
    }

    @Override
    public void addLayerShape(ALayerShape shape) {
        this.shapes.add(shape);
    }

    @Override
    public void removerShape(int position) {
        this.shapes.remove(position);
    }

    public void substituirShape(int posicaoShapeRemover, ALayerShape shape) {
        this.removerShape(posicaoShapeRemover);
        this.addLayerShape(shape);
    }

    public void inserindoGestoEAcoes() {
    }

    @Override
    public void paint(Graphics g) {
        if (!shapes.isEmpty()) {
            super.paint(g);
            for (int a = 0; a < this.shapes.size(); a++) {
                ALayerShape shape = (ALayerShape) shapes.get(a);
                shape.draw(g);
            }

            try {
                SkeletonBone sb = KinectAccess.getSkeletonsBone();
                
                maoX = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ2().getX();
                maoY = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ2().getY();
                maoZ = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ2().getZ();
                maoXJ1 = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ1().getX();
                maoYJ1 = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ1().getY();
                maoZJ1 = (int) sb.getBone(EBone.RIGHT_FOREARM).getJ1().getZ();
                pescX = (int) sb.getBone(EBone.NECK).getJ2().getX();
                pescY = (int) sb.getBone(EBone.NECK).getJ2().getY();
                pescZ = (int) sb.getBone(EBone.NECK).getJ2().getZ();
                maoLx = (int) sb.getBone(EBone.LEFT_FOREARM).getJ2().getX();
                maoLy = (int) sb.getBone(EBone.LEFT_FOREARM).getJ2().getY();
                maoLz = (int) sb.getBone(EBone.LEFT_FOREARM).getJ2().getZ();
                
                mao = new Point3D(maoX, maoY, maoZ);
                maoJ1 = new Point3D(maoXJ1, maoYJ1, maoZJ1);
                pesc = new Point3D(pescX, pescY, pescZ);
                maoL = new Point3D(maoLx, maoLy, maoLz);

                gerente.Finalize(mao, pesc, maoJ1, maoL, null, null);

            } catch (Exception erro) {
            }


        }
        this.repaint();
    }
}
