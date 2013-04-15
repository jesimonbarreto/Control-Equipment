package ControlandoTV;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import Gerente.AcaoReal;
import Gerente.ControlePorta;
import Gerente.MyscreenPanel;
import Gerente.NewShape;

/**
 *
 * @author Geral
 */
public class ABaixo extends AcaoReal{

   

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void executeArduino(ControlePorta cp, MyscreenPanel sp) {
        sp.removerShape(7);
        NewShape ns = null;
        try {
           ns=new NewShape(sp.imagem[2], sp);
        } catch (Exception erro) {
            System.out.println("Erro ADD SHAPE");
        }
        //setpoint pontos selecionados(padrões)
        sp.addMyLayerShape(ns);
    }

    
}