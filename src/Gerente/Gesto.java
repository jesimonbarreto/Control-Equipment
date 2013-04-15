package Gerente;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Point;
import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
public abstract class Gesto {

    Point3D[] point = new Point3D[3];
    private boolean executando = false;
    private String nomeClasse = null;

    public boolean isExecutando() {
        return executando;
    }

    public void setExecutando(boolean executando) {
        this.executando = executando;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClass) {
        this.nomeClasse = nomeClass;
    }

    public abstract void LeituraPontos(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6);

    public abstract boolean Aconteceu(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6);
}
