package sistemaDistribuido.sistema.clienteServidor.modoUsuario;

import sistemaDistribuido.sistema.clienteServidor.modoMonitor.ParMaquinaProceso;

public class Puentazo {

    private static ProcesoServidorNombres servidorNombres;

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
