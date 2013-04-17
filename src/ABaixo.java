

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Acao.AcaoReal;
import Arduino.ControlePorta;
import Painel.NewShape;

/**
 *
 * @author Geral
 */
public class ABaixo extends AcaoReal {

    @Override
    public void executeArduino(ControlePorta cp, Painel.MyscreenPanel sp) {
        sp.removerShape(7);
        NewShape ns = null;
        try {
            ns = new NewShape(sp.imagem[2], sp);
        } catch (Exception erro) {
            System.out.println("Erro ADD SHAPE");
        }
        //setpoint pontos selecionados(padrões)
        sp.addMyLayerShape(ns);
    }

    @Override
    public void pararAcao(ControlePorta cp, Painel.MyscreenPanel sp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}