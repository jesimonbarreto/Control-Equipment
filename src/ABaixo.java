
import Action.ActionReal;
import Arduino.PortControl;
import Panel.MyscreenPanel;
import Panel.NewShape;

/**
 *
 * @author JB
 */
public class ABaixo extends ActionReal {

    @Override
    public void runArduino(PortControl pc, MyscreenPanel pnl) {
        pnl.removerShape(7);
        NewShape ns = null;
        try {
            ns = new NewShape(pnl.imagem[2], pnl);
        } catch (Exception erro) {
            System.out.println("Erro ADD SHAPE");
        }
        //setpoint pontos selecionados(padrões)
        pnl.addMyLayerShape(ns);
    }

    @Override
    public void stopAction(PortControl pc, MyscreenPanel pnl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}