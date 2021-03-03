package vista;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class InterfazPregunta extends JFrame implements ActionListener, ChangeListener {
    private JLabel titulo, texto1, texto2, texto3, texto4;
    private JTextField tituloPregunta;
    private JTextArea pregunta;
    private JButton boton1, boton2, boton3;
    private JCheckBox check1;
    public InterfazMenu menu= new InterfazMenu();
    public InterfazUsuario userMenu= new InterfazUsuario();

    public InterfazPregunta(){
        setLayout(null);
        titulo=new JLabel("Realizar Pregunta");
        titulo.setBounds(215,30,120,30);
        add(titulo);

        texto1= new JLabel("T\u00edtulo");
        texto1.setBounds(10,100,120,30);
        add(texto1);

        //tituloPregunta=new JTextField("\"\u00bfC\u00f3mo puedo imprimir en python?\"");
        tituloPregunta=new JTextField();
        tituloPregunta.setBounds(10,150,400,30);
        add(tituloPregunta);

        pregunta=new JTextArea();
        pregunta.setBounds(10,200,400,200);
        add(pregunta);

        boton1=new JButton("Enviar pregunta");
        boton1.setBounds(10,450,150,30);
        add(boton1);

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
        if(e.getSource()==boton1){
            //hacer el coso para subir la pregunta
        }
        else if (e.getSource()==boton2){
            userMenu.setBounds(0,0,550,550);
            userMenu.setResizable(false);
            userMenu.setLocationRelativeTo(null);
            userMenu.setVisible(true);
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

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
