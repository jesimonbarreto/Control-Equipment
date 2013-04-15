/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerente;

/**
 *
 * @author JB
 */
public abstract class Acao {

    private char identi;

    public char getIdenti() {
        return identi;
    }

    public void setIdenti(char identi) {
        this.identi = identi;

    }

    public abstract void execute();

    public abstract void executeArduino(ControlePorta cp, MyscreenPanel sp);
}
