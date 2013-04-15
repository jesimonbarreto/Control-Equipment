package ControlandoTV;


import Gerente.Gesto;
import org.OpenNI.Point3D;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Geral
 */
public class GestoCentro extends Gesto {

    @Override
    public void LeituraPontos(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
    }

    @Override
    public boolean Aconteceu(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        boolean aconteceu = false;
        if (ponto1.getY() > ponto3.getY()) {
            if (ponto1.getY() < ponto5.getY()) {
                aconteceu = true;
            }
        }
        return aconteceu;
    }
}
