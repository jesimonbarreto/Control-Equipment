package Gerente;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import java.util.ArrayList;
import java.util.Vector;
import org.OpenNI.Point3D;

/**
 *
 * @author JB
 */
public class GerenteDeGestoseAcoes {

    private ControlePorta cp = new ControlePorta();
    MyscreenPanel msp = new MyscreenPanel() {
    };
    private Hashtable hs = new Hashtable();
    private String objetoAExecutar = null;
    private String StringTest = null;
    private boolean leitura = false;
    private ArrayList<Gesto> Gestos = new ArrayList();

    public void addGestos(Gesto reconhecedor) {
        this.Gestos.add(reconhecedor);
        String nomeClasse = reconhecedor.getNomeClasse();
        Vector acoes = new Vector();
        hs.put(nomeClasse, acoes);
    }

    public void IniciaConexArduino() {
        cp.initSerial();
    }

    public void addAcao(String nomeClasse, Acao acao) {
        ((Vector) hs.get(nomeClasse)).add(acao);
    }

    public String DetectandoGesto(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        if (!leitura) {
            for (int i = 0; i < Gestos.size(); i++) {
                Gestos.get(i).LeituraPontos(ponto1, ponto2, ponto3, ponto4, ponto5, ponto6);
            }
            leitura = true;
            objetoAExecutar = null;
        } else {
            Gesto reconhecedor = null;
            StringTest = objetoAExecutar;
            int i = 0;
            while (i < Gestos.size() && reconhecedor == null) {
                reconhecedor = Gestos.get(i);
                if (!reconhecedor.Aconteceu(ponto1, ponto2, ponto3, ponto4, ponto5, ponto6)) {
                    reconhecedor = null;
                } else {
                    objetoAExecutar = reconhecedor.getNomeClasse();
                }
                i++;
            }
            leitura = false;
        }
        return objetoAExecutar;
    }

    public void ConcluindoAcao(Point3D ponto1, Point3D ponto2, Point3D ponto3, Point3D ponto4, Point3D ponto5, Point3D ponto6) {
        String chave = this.DetectandoGesto(ponto1, ponto2, ponto3, ponto4, ponto5, ponto6);
        if (chave != null && !StringTest.equals(objetoAExecutar)) {
            Vector aAcao = ((Vector) hs.get(chave));
            for (int i = 0; i < aAcao.size(); i++) {
                Acao a = (Acao) aAcao.get(i);
                if (a.getIdenti() == 'r') {
                    a.executeArduino(cp, msp);
                } else {
                    a.execute();
                }
            }
        } else if (chave == null) {
            objetoAExecutar = null;
        }
    }
}
