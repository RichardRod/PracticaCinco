package sistemaDistribuido.sistema.clienteServidor.modoUsuario;

public class Puente {

    private static ProcesoServidorNombres servidorNombres;

    public static void asignarPuente(ProcesoServidorNombres servidor)
    {
        servidorNombres = servidor;
        servidorNombres.iniciar();
    }

    public static int exportarInterfaz(String NOMBRE_SERVIDOR, int i, String hostAddress)
    {
        servidorNombres.registrarServidor(NOMBRE_SERVIDOR, i, hostAddress);
        return 0;
    }

    public static boolean eliminar(int identificador)
    {
        servidorNombres.eliminarServidor(identificador);
        return false;
    }



}//fin de la clase Puente
