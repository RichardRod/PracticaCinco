package sistemaDistribuido.sistema.clienteServidor.modoUsuario;

import sistemaDistribuido.sistema.clienteServidor.modoMonitor.ParMaquinaProceso;

public class Asa implements ParMaquinaProceso{

    //atributos
    private String ip;
    private int id;

    //constructor
    public Asa(int id, String ip) {
        this.id = id;
        this.ip = ip;
    }//fin del constructor

    @Override
    public String dameIP() {
        return ip;
    }

    @Override
    public int dameID() {
        return id;
    }
}//fin de la clase Asa
