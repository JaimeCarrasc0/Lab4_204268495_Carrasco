package vista;

import modelo.*;

import javax.swing.*;
import java.awt.event.*;

public class InterfazUsuario extends JFrame implements ActionListener {
    private JLabel titulo;
    private JButton boton1, boton2, boton3, boton4, boton5, boton6;
    private InterfazMenu menu = new InterfazMenu();
    private InterfazVerPreguntas preg;

    public InterfazUsuario(){
        setLayout(null);
        titulo=new JLabel("Men\u00fa Usuario");
        setTitle("Sesi\u00f3n iniciada como "+menu.stack.getActivos().get(menu.stack.getActivos().size()-1).getUser());
        titulo.setBounds(215,30,120,30);
        add(titulo);

        boton1=new JButton("Agregar Pregunta");
        boton1.setBounds(10,100,200,30);
        add(boton1);
        boton1.addActionListener(this);

        boton2=new JButton("Responder Pregunta");
        boton2.setBounds(10,150,200,30);
        add(boton2);
        boton2.addActionListener(this);

        boton3=new JButton("Dar Recompensa");
        boton3.setBounds(10,200,200,30);
        add(boton3);
        boton3.addActionListener(this);

        boton4=new JButton("Aceptar Respuesta");
        boton4.setBounds(10,250,200,30);
        add(boton4);
        boton4.addActionListener(this);

        boton5=new JButton("Cerrar Sesi\u00f3n");
        boton5.setBounds(240,450,150,30);
        add(boton5);
        boton5.addActionListener(this);

        boton6=new JButton("Salir");
        boton6.setBounds(400,450,90,30);
        add(boton6);
        boton6.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1){
            //interfaz de hacer preguntas
            InterfazPregunta menuPregunta = new InterfazPregunta();
            menuPregunta.setBounds(0,0,600,550);
            menuPregunta.setResizable(false);
            menuPregunta.setLocationRelativeTo(null);
            menuPregunta.setVisible(true);

            this.setVisible(false);
        }
        else if (e.getSource()==boton2){
            //interfaz de responder
            preg=new InterfazVerPreguntas();
            preg.setBounds(0,0,800,550);
            preg.setResizable(false);
            preg.setLocationRelativeTo(null);
            preg.setVisible(true);
            this.setVisible(false);
        }
        else if (e.getSource()==boton3){
            //interfaz de dar recompensa
        }
        else if(e.getSource()==boton4){
            //interfaz de aceptar respuesta
        }
        else if (e.getSource()==boton5){
            menu.stack.logout(menu.stack.getActivos().get(menu.stack.getActivos().size()-1).getUser());
            menu.setBounds(0,0,550,550);
            menu.setResizable(false);
            menu.setLocationRelativeTo(null);
            menu.setVisible(true);
            this.setVisible(false);
        }
        else if (e.getSource()==boton6){
            System.exit(0);
        }

    }
}
