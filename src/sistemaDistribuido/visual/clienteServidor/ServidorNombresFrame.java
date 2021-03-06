package sistemaDistribuido.visual.clienteServidor;

import sistemaDistribuido.sistema.clienteServidor.modoUsuario.ProcesoServidorNombres;
import sistemaDistribuido.sistema.clienteServidor.modoUsuario.Puentazo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @Nombre: Rodriguez Haro Ricardo
 * @seccion: D04
 * @No: Practica 5
 * Modificado para Practica 5
 */

public class ServidorNombresFrame extends ProcesoFrame
{
    //atributos
    public static JTable tablaProcesos;
    private JScrollPane desplazamientoTabla;
    private ProcesoServidorNombres proc;

    //constructor
    public ServidorNombresFrame(MicroNucleoFrame frameNucleo) {
        super(frameNucleo, "Servidor de Nombres");
        super.setLayout(new GridLayout(3, 1));

        tablaProcesos = new JTable(new DefaultTableModel(new Object[][]{},
                new String[]{
                        "Nombre", "Direccion IP", "Identificador"
                }));
        add(tablaProcesos);

        desplazamientoTabla = new JScrollPane(tablaProcesos);
        add(desplazamientoTabla);

        setSize(500, 300);

        proc=new ProcesoServidorNombres(this);
        fijarProceso(proc);
        Puentazo.asignarPuente(proc);

    }//fin del constructor

}//fin de la clase ServidorNombresFrame
