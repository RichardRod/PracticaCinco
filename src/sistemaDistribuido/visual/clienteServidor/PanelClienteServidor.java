package sistemaDistribuido.visual.clienteServidor;

import javax.swing.*;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;

public class PanelClienteServidor extends Panel {
    private static final long serialVersionUID = 1;
    private JButton botonCliente, botonServidor, botonServidorNombres;

    public PanelClienteServidor() {
        botonCliente = new JButton("Cliente");
        botonServidor = new JButton("Servidor");
        botonServidorNombres = new JButton("Servidor Nombres");
        add(botonCliente);
        add(botonServidor);
        add(botonServidorNombres);
    }

    public JButton dameBotonCliente() {
        return botonCliente;
    }

    public JButton dameBotonServidor() {
        return botonServidor;
    }

    public JButton dameBotonServidorNombres() {
        return botonServidorNombres;
    }

    public void agregarActionListener(ActionListener al) {
        botonCliente.addActionListener(al);
        botonServidor.addActionListener(al);
        botonServidorNombres.addActionListener(al);
    }
}