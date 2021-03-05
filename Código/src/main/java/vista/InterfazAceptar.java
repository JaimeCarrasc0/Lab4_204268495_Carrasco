package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase interfaz aceptar, clase dedicada a la ventana para aceptar respuestas
 * @author Jaime Carrasco
 */
public class InterfazAceptar extends JFrame implements ActionListener {

    public static InterfazMenu menu=new InterfazMenu();
    public InterfazUsuario userMenu= new InterfazUsuario();
    public InterfazVerPreguntas pregMenu= new InterfazVerPreguntas(0);
    private JLabel titulo,texto1,texto2,texto3,texto4 ;
    private JButton boton1,boton2,boton3;
    private JTextArea respuesta;
    private JScrollPane scroll;
    public InterfazAceptarRespuesta acpResp= new InterfazAceptarRespuesta();

    /**
     * constructor clase
     */
    public InterfazAceptar(){
        setLayout(null);
        titulo=new JLabel("Aceptar Respuesta");
        titulo.setBounds(215,30,120,30);
        add(titulo);

        texto2=new JLabel("Respuestas");
        texto2.setBounds(10,150,120,30);
        add(texto2);

        /*acpResp.setBounds(0,0,800,550);
        acpResp.setResizable(false);
        acpResp.setLocationRelativeTo(null);
        acpResp.setVisible(true);*/

        boton2=new JButton("Volver");
        boton2.setBounds(250,450,90,30);
        add(boton2);
        boton2.addActionListener(this);

        boton3=new JButton("Cerrar Sesi\u00f3n");
        boton3.setBounds(350,450,150,30);
        add(boton3);
        boton3.addActionListener(this);

    }

    /**
     * Funcionalidad para traducir los eventos de botones
     * @param e entrada evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1){
            menu.stack.answer(pregMenu.preguntaEscogida,respuesta.getText());
            menu.stack.imprimirRespuestas(menu.stack.getPreguntas().get(pregMenu.preguntaEscogida));
            this.setVisible(false);

        }
        else if (e.getSource()==boton2){
            /*pregMenu.setBounds(0,0,550,550);
            pregMenu.setLocationRelativeTo(null);
            pregMenu.setResizable(false);
            pregMenu.setVisible(true);*/
            this.setVisible(false);
        }
        else if (e.getSource()==boton3){
            menu.stack.logout(menu.stack.getActivos().get(menu.stack.getActivos().size()-1).getUser());
            menu.setBounds(0,0,550,550);
            menu.setResizable(false);
            menu.setLocationRelativeTo(null);
            menu.setVisible(true);
            this.setVisible(false);
        }

    }

}
