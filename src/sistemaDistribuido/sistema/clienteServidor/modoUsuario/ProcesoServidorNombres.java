package sistemaDistribuido.sistema.clienteServidor.modoUsuario;

import sistemaDistribuido.util.Escribano;
import sistemaDistribuido.visual.clienteServidor.ServidorNombresFrame;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;

public class ProcesoServidorNombres extends Proceso{

    //atributos
    private LinkedList<DatosProceso> listaProcesos = new LinkedList<>();


    //constructor
    public ProcesoServidorNombres(Escribano esc)
    {
        super(esc);
        start();

    }//fin del constructor

    public void run()
    {
        imprimeln("Servidor De Nombres Iniciado");

        while(continuar())
        {

        }//fin de while
    }//fin del metodo run

    public void registrarServidor(String nombreServidor, int ID, String IP)
    {
        imprimeln("Registrado: " + nombreServidor);

        DefaultTableModel modelo = (DefaultTableModel)ServidorNombresFrame.tablaProcesos.getModel();
        Object[] fila = new Object[4];

        listaProcesos.add(new DatosProceso(nombreServidor, ID, IP));
        fila[0] = "";
        fila[1] = nombreServidor;
        fila[2] = ID;
        fila[3] = IP;

        modelo.addRow(fila);
        ServidorNombresFrame.tablaProcesos.setModel(modelo);

    }

    public void eliminarServidor(int id)
    {
        for(DatosProceso proceso : listaProcesos)
        {
            if(proceso.getId() == id)
            {
                System.out.println("Dar cran: " + proceso.getId());
            }
        }
    }

}//fin de la clase ProcesoServidorNombres

class DatosProceso
{
    private String nombreServidor;
    private int id;
    private String ip;

    //constructor
    public DatosProceso(String nombreServidor, int id, String ip)
    {
        this.nombreServidor = nombreServidor;
        this.id = id;
        this.ip = ip;
    }

    public String getNombreServidor() {
        return nombreServidor;
    }

    public int getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }
}//fin de la clase DatosProceso