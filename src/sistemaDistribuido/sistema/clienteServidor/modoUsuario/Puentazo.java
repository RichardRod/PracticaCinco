package sistemaDistribuido.sistema.clienteServidor.modoUsuario;

import sistemaDistribuido.sistema.clienteServidor.modoMonitor.Nucleo;
import sistemaDistribuido.sistema.clienteServidor.modoMonitor.ParMaquinaProceso;

/**
 * @Nombre: Rodriguez Haro Ricardo
 * @seccion: D04
 * @No: Practica 5
 * Modificado para Practica 5
 */

public class Puentazo {

    private static ProcesoServidorNombres servidorNombres;

    public static String importarInterfaz(String nombreServidor)
    {
        String server = "";
        ParMaquinaProceso asa = servidorNombres.busqueda(nombreServidor);

        if (asa != null) {
            Nucleo.nucleo.registrarTablaEmision(asa);
            server = Integer.toString(asa.dameID());
        }//fin de if

        System.out.println("RPC.java regresa: " + server);

        return server;
    }

    public static void asignarPuente(ProcesoServidorNombres servidor)
    {
        servidorNombres = servidor;
        servidorNombres.iniciar();
    }

    public static int agregar(String NOMBRE_SERVIDOR, ParMaquinaProceso asa)
    {
        servidorNombres.registrarServidor(NOMBRE_SERVIDOR, asa.dameID(), asa.dameIP());
        return 0;
    }

    public static boolean eliminar(int identificador)
    {
        servidorNombres.eliminarServidor(identificador);
        return false;
    }



}//fin de la clase Puentazo
