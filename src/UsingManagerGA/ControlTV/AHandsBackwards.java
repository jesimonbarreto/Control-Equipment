/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UsingManagerGA.ControlTV;

import Manager.Action.VirtualAction;
import Manager.GesturesStandards.Center;
import Manager.GesturesStandards.Down;
import Manager.GesturesStandards.Left;
import Manager.GesturesStandards.Right;
import Manager.GesturesStandards.Up;
import Manager.ManagerG.ManagerGA;
import Manager.Panel.MyscreenPanel;

/**
 *
 * @author JB
 */
public class AHandsBackwards extends VirtualAction {

    @Override
    public void run(MyscreenPanel sp, ManagerGA gerente) {
        System.out.println("hands backwards");
        Down d = new Down();
        gerente.addGestures(d);
        ActionDown ad = new ActionDown();
        gerente.addAction("Down", ad);
        Up u = new Up();
        gerente.addGestures(u);
        ActionUp au = new ActionUp();
        gerente.addAction("Up", au);
        Left l = new Left();
        gerente.addGestures(l);
        ActionLeft al = new ActionLeft();
        gerente.addAction("Left", al);
        Right r = new Right();
        gerente.addGestures(r);
        ActionRight ar = new ActionRight();
        gerente.addAction("Right", ar);
        Center c = new Center();
        gerente.addGestures(c);
        ActionCenter ac = new ActionCenter();
        gerente.addAction("Center", ac);
    }
}
