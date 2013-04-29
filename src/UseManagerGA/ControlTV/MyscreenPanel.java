package UseManagerGA.ControlTV;


import Arduino.PortControl;
import Manager.ManagerGA;
import GesturesStandards.*;
import Panel.MyALayerShape;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;
import javax.imageio.ImageIO;
import presentation.ALayerShape;

/**
 *
 * @author JB
 */
public final class MyscreenPanel extends Panel.MyscreenPanel {

    Vector shapes = new Vector();
    BufferedImage[] image = null;
    private int shapePositionv = 0;
    boolean acao = false;
    int positionInicialRigth = 0;
    int positionFinalRigth = 0;
    int controle = 0;
    PortControl cp = new PortControl();
    ManagerGA gerente = new ManagerGA(this);

    public MyscreenPanel() throws Exception {
        super();
        cp.initSerial();
        this.LoadImage("./navegação.png", 0);
        this.LoadImage("./centro_clicado.png", 1);
        this.LoadImage("./cima_clicado.png", 2);
        this.LoadImage("./baixo_clicado.png", 3);
        this.LoadImage("./direito_clicado.png", 4);
        this.LoadImage("./esquerdo_clicado.png", 5);


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


        }
        this.repaint();
    }
}
