package vista;

import modelo.Etiquetas;
import modelo.Respuesta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazResponder extends JFrame implements ActionListener {
    public static InterfazMenu menu=new InterfazMenu();
    public InterfazUsuario userMenu= new InterfazUsuario();
    public InterfazVerPreguntas pregMenu= new InterfazVerPreguntas();
    private JLabel titulo,texto1,texto2,texto3,texto4 ;
    private JButton boton1,boton2,boton3;
    private JTextArea respuesta;
    private JScrollPane scroll;


    public InterfazResponder(){
        setLayout(null);
        titulo=new JLabel("Responder Pregunta");
        titulo.setBounds(215,30,120,30);
        add(titulo);

        texto2=new JLabel("Respuesta");
        texto2.setBounds(10,150,120,30);
        add(texto2);

        respuesta =new JTextArea();
        scroll=new JScrollPane(respuesta);
        scroll.setBounds(10,180,400,200);
        add(scroll);

        boton1=new JButton("Enviar respuesta");
        boton1.setBounds(10,450,150,30);
        add(boton1);
        boton1.addActionListener(this);

        boton2=new JButton("Volver");
        boton2.setBounds(250,450,90,30);
        add(boton2);
        boton2.addActionListener(this);

        boton3=new JButton("Cerrar Sesi\u00f3n");
        boton3.setBounds(350,450,150,30);
        add(boton3);
        boton3.addActionListener(this);

    }

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
