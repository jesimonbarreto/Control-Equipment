package ControlandoTV;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Gerente.ControlePorta;
import Gerente.GerenteDeGestoseAcoes;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;
import javax.imageio.ImageIO;
import presentation.ALayerShape;
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
    GerenteDeGestoseAcoes gerente = new GerenteDeGestoseAcoes();

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

    public void inserindoGestoEAcoes() {
        GestoCima gc = new GestoCima();
        gc.setNomeClasse("GestoCima");
        gerente.addGestos(gc);
        GestoCentro gcen = new GestoCentro();
        gc.setNomeClasse("GestoCentro");
        gerente.addGestos(gcen);
        GestoBaixo gb = new GestoBaixo();
        gc.setNomeClasse("GestoBaixo");
        gerente.addGestos(gb);
        GestoDireita gd = new GestoDireita();
        gc.setNomeClasse("GestoDireita");
        gerente.addGestos(gd);
        GestosEsquerda ge = new GestosEsquerda();
        gc.setNomeClasse("GestoEsquerda");
        gerente.addGestos(ge);
        ACima ac = new ACima();
        gerente.addAcao("GestoCima", ac);
        ACentro acen = new ACentro();
        gerente.addAcao("GestoCentro", acen);
        ABaixo ab = new ABaixo();
        gerente.addAcao("GestoBaixo", ab);
        ADireito ad = new ADireito();
        gerente.addAcao("GestoDireita", ad);
        AEsquerdo ae = new AEsquerdo();
        gerente.addAcao("GestoEsquerda", ae);
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
    }
}
