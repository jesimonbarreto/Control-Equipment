/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UsingManagerGA.ControlTV;

import Manager.Action.VirtualAction;
import Manager.ManagerG.ManagerGA;
import Manager.Panel.MyscreenPanel;
import Manager.Panel.NewShape;

/**
 *
 * @author JB
 */
public class AHandsUp extends VirtualAction {

    @Override
    public void run(MyscreenPanel sp, ManagerGA gerente) {
        System.out.println("HandsUp");
        gerente.removerGesture("Down");
        gerente.removerGesture("Up");
        gerente.removerGesture("Right");
        gerente.removerGesture("Left");
        gerente.removerGesture("Center");
        sp.LoadImage("./navegação.png");
        NewShape ns = null;
        try {
            ns = new NewShape(sp.getImage(), sp, 370, 350, 200, 290);
        } catch (Exception erro) {
            System.out.println("Erro ADD SHAPE");
        }
        sp.replaceShape(2, ns);
    }
}
