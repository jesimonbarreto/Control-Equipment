package Gerente;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import java.io.IOException;
import java.io.OutputStream;

public class ControlePorta {

    private OutputStream serialOut;

    public void initSerial() {
        try {
            CommPortIdentifier portId = null;
            try {
                portId = CommPortIdentifier.getPortIdentifier("COM55");
            } catch (NoSuchPortException mpe) {
            }

            SerialPort port = (SerialPort) portId.open("T�tulo comunica��o serial", 9600);

            serialOut = port.getOutputStream();

            port.setSerialPortParams(9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            System.out.println("Chegou entrou conex�o");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            serialOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void enviaDados(char opcao) {
        try {

            serialOut.write(opcao);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
