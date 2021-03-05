package vista;

import modelo.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Clase interfaz menú
 * @author Jaime Carrasco
 */
public class InterfazMenu extends JFrame implements ActionListener{
    private JLabel etiqueta;
    private JButton boton1,boton2,boton3,boton4;
    private InterfazLogin login;
    private InterfazRegister register;
    private InterfazVerPreguntas preg;

    /**
     * constructor de la clase
     */
    public InterfazMenu(){
        setLayout(null);

        boton1= new JButton("Iniciar Sesi\u00f3n");
        boton1.setBounds(10,200,200,30);
        add(boton1);
        boton1.addActionListener(this);

        boton2= new JButton("Registrarse");
        boton2.setBounds(10,250,200,30);
        add(boton2);
        boton2.addActionListener(this);

        /*boton3 =new JButton("Ver preguntas");
        boton3.setBounds(10,350,200,30);
        add(boton3);
        boton3.addActionListener(this);*/

        boton4 =new JButton("Salir");
        boton4.setBounds(10,350,200,30);
        add(boton4);
        boton4.addActionListener(this);

        etiqueta = new JLabel("Simulador Stack Overflow");
        etiqueta.setBounds(10, 10, 200, 300);
        add(etiqueta);
    }

    /**
     * Funcionalidad para traducir los eventos de botones
     * @param e entrada evento
     */

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==boton1){
            //System.out.println("Iniciar Sesión");
            //etiqueta.setText("Iniciar Sesión");
            this.setVisible(false);
            login=new InterfazLogin();
            login.setBounds(0,0,550,550);
            login.setLocationRelativeTo(null);
            login.setResizable(false);
            login.setVisible(true);

        }
        else if(e.getSource() == boton2){
            //System.out.println("Registrarse");
            //etiqueta.setText("Registrarse");
            this.setVisible(false);
            register=new InterfazRegister();
            register.setBounds(0,0,550,550);
            register.setLocationRelativeTo(null);
            register.setResizable(false);
            register.setVisible(true);
            }

        else if(e.getSource() == boton3) {
            preg=new InterfazVerPreguntas(1);
            preg.setBounds(0,0,800,550);
            preg.setResizable(false);
            preg.setLocationRelativeTo(null);
            preg.setVisible(true);
            this.setVisible(false);
        }

        else if(e.getSource() == boton4){
            System.exit(0);
        }
    }
    public static Stack stack= new Stack();

    /**
     * Main del programa
     * @param args argumentos standard
     */
    public static void main(String[] args) {
        //stack.imprimirPreguntas();
        InterfazMenu menu= new InterfazMenu();
        menu.setBounds(0,0,550,550);
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        menu.setResizable(false);

    }
}
