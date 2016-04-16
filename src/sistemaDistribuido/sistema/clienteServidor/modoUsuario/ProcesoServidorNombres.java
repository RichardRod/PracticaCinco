package sistemaDistribuido.sistema.clienteServidor.modoUsuario;

import sistemaDistribuido.util.Escribano;
import sistemaDistribuido.visual.clienteServidor.ServidorNombresFrame;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;

public class ProcesoServidorNombres extends Proceso{

    //atributos
    private LinkedList<DatosProceso> listaProcesos;

    //constructor
    public ProcesoServidorNombres(Escribano esc)
    {
        super(esc);
        start();

    }//fin del constructor

    public void iniciar()
    {
        listaProcesos = new LinkedList<>();
    }

    public void run()
    {
        imprimeln("Proceso Servidor Nombres iniciado");

        while(continuar())
        {

        }//fin de while

    }//fin del metodo run

    public void registrarServidor(String nombreServidor, int ID, String IP)
    {
        imprimeln("Registrado proceso " + ID);

        DefaultTableModel modelo = (DefaultTableModel)ServidorNombresFrame.tablaProcesos.getModel();
        Object[] fila = new Object[3];
        int contador = ServidorNombresFrame.tablaProcesos.getRowCount();

        //System.out.println("Contador: " + contador);

        DatosProceso proceso = new DatosProceso(nombreServidor, ID, IP);
        proceso.setIndice(contador);

        listaProcesos.add(proceso);

        fila[0] = nombreServidor;
        fila[1] = IP;
        fila[2] = ID;

        modelo.addRow(fila);
        ServidorNombresFrame.tablaProcesos.setModel(modelo);

    }

    public void eliminarServidor(int id)
    {
        imprimeln("Eliminando proceso " + id);
        int indice;

        for(DatosProceso proceso : listaProcesos)
        {
            if(proceso.getId() == id)
            {
                indice = proceso.getIndice();
                //System.out.println("Indice: " + indice);
                listaProcesos.remove(proceso);
                ((DefaultTableModel)ServidorNombresFrame.tablaProcesos.getModel()).removeRow(indice);
                ServidorNombresFrame.tablaProcesos.addNotify();
                actualizarIndices();
            }
        }
    }

    public void actualizarIndices()
    {
        int contador = ServidorNombresFrame.tablaProcesos.getRowCount();

        for(int i = 0; i < contador; i++){

            listaProcesos.get(i).setIndice(i);
        }
    }

}//fin de la clase ProcesoServidorNombres

class DatosProceso
{
    private String nombreServidor;
    private int id;
    private String ip;
    private int indice;

    //constructor
    public DatosProceso(String nombreServidor, int id, String ip)
    {
        this.nombreServidor = nombreServidor;
        this.id = id;
        this.ip = ip;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getIndice() {
        return indice;
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