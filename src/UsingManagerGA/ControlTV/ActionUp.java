package UsingManagerGA.ControlTV;

import Manager.Panel.*;
import Manager.Arduino.PortControl;
import Manager.Action.ActionReal;
import Manager.Panel.MyscreenPanel;

/**
 *
 * @author JB
 */
public class ActionUp extends ActionReal {

    @Override
    public void runArduino(PortControl pc, MyscreenPanel pnl) {
        pnl.LoadImage("./cima_clicado.png");
        NewShape ns = null;
        try {
            ns = new NewShape(pnl.getImage(), pnl, 370, 350, 200, 290);
        } catch (Exception erro) {
            System.out.println("Erro ADD SHAPE");
        }
        pnl.replaceShape(2, ns);
    }

    @Override
    public void stopAction(PortControl pc, MyscreenPanel pnl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
