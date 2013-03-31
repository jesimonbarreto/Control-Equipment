/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movimento456;

import javax.swing.JFrame;
import presentation.ALayerShape;
import presentation.impl.KinectMotionCapture.KinectControl.KinectAccess;
import presentation.impl.KinectMotionCapture.layers.LayerRGB;
import presentation.impl.KinectMotionCapture.layers.LayerSkeletonBone;

/**
 *
 * @author Geral
 */
public class Movimento456 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        MyscreenPanel sp = new MyscreenPanel();

        ALayerShape rgb = null;
        LayerSkeletonBone sb = null;
        SCima cima = null;
        SBaixo baixo = null;
        SDireita direita = null;
        SEsquerda esquerda = null;
        SCentro centro = null;
        try {
            rgb = new LayerRGB();
            sb = new LayerSkeletonBone();
            cima = new SCima();
            baixo = new SBaixo();
            direita = new SDireita();
            esquerda = new SEsquerda();
            centro = new SCentro();
        } catch (Exception erro) {
            System.out.println("erro");
        }
        //setPoint
        sp.addLayerShape(rgb);
        sp.addLayerShape(sb);
        sp.addLayerShape(cima);
        sp.addLayerShape(baixo);
        sp.addLayerShape(direita);
        sp.addLayerShape(esquerda);
        sp.addLayerShape(centro);

        JFrame frame = new JFrame();
        frame.setSize(KinectAccess.getPrefSize());
        frame.add(sp);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);





    }
}
