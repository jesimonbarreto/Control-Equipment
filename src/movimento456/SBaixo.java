/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movimento456;

import java.awt.Graphics;

/**
 *
 * @author Geral
 */
public class SBaixo extends MyALayerShape {

    public SBaixo() throws Exception {
    }

    @Override
    public void draw(Graphics grphcs) {
        grphcs.drawRect(this.getPoint(0).x, this.getPoint(0).y, this.getPoint(1).x, this.getPoint(1).y);
    }

    @Override
    public void action(MyscreenPanel sp) {
        sp.removerShape(7);
        NewShape ns = null;
        try {
            ns = new NewShape(sp.image[3], sp);
        } catch (Exception erro) {
            System.out.println("Erro ADD SHAPE");
        }
        //set point pontos selecionados(padrões)
        sp.addLayerShape(ns);
        //Enviar char para arduíno iniciar ação throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void stopAction(MyscreenPanel sp) {
        sp.removerShape(7);
        NewShape ns = null;
        try {
            ns = new NewShape(sp.image[0], sp);
        } catch (Exception erro) {
            System.out.println("Erro REMOVER SHAPE");
        }
        //set point pontos selecionados(padrões)
        sp.addLayerShape(ns);
        //Enviar char para arduíno para finalizar ação
    }
}
