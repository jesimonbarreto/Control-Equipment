package UsingManagerGA.ControlTV;

import Manager.Action.ActionReal;
import Manager.Arduino.PortControl;
import Manager.Panel.NewShape;

/**
 *
 * @author JB
 */
public class ActionCenter extends ActionReal {

    @Override
    public void runArduino(PortControl pc, Manager.Panel.MyscreenPanel pnl) {
        pnl.LoadImage("./centro_clicado.png");
        NewShape ns = null;
        try {
            ns = new NewShape(pnl.getImage(), pnl, 370, 350, 200, 290);
        } catch (Exception erro) {
            System.out.println("Erro ADD SHAPE");
        }
        pnl.replaceShape(2, ns);
    }

    @Override
    public void stopAction(PortControl pc, Manager.Panel.MyscreenPanel pnl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
