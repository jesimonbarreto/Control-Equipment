
import Action.*;
import Arduino.*;
import Panel.MyscreenPanel;
import Panel.NewShape;

/**
 *
 * @author JB
 */
public class AEsquerdo extends ActionReal {

    @Override
    public void runArduino(PortControl pc, MyscreenPanel pnl) {
        pnl.removerShape(7);
        NewShape ns = null;
        try {
            ns = new NewShape(pnl.imagem[5], pnl);
        } catch (Exception erro) {
            System.out.println("Erro ADD SHAPE");
        }
        //set point pontos selecionados(padrões)
        pnl.addLayerShape(ns);
        //Enviar char para arduíno iniciar ação throw new UnsupportedOperationException("Not supported yet.");

    }

    @Override
    public void stopAction(PortControl pc, MyscreenPanel pnl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
