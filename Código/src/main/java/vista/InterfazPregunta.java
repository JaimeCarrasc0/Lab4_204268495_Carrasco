package vista;

import modelo.Etiquetas;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazPregunta extends JFrame implements ActionListener, ChangeListener {
    private JLabel titulo, texto1, texto2, texto3, texto4;
    private JTextField tituloPregunta, etiquetas;
    private JTextArea pregunta;
    private JScrollPane scroll;
    private JButton boton1, boton2, boton3, ayuda;
    //private JComboBox;

    public static InterfazMenu menu= new InterfazMenu();
    public InterfazUsuario userMenu= new InterfazUsuario();

    public InterfazPregunta(){
        setLayout(null);
        titulo=new JLabel("Realizar Pregunta");
        titulo.setBounds(215,30,120,30);
        add(titulo);

        texto1= new JLabel("T\u00edtulo");
        texto1.setBounds(10,90,120,30);
        add(texto1);

        //tituloPregunta=new JTextField("\"\u00bfC\u00f3mo puedo imprimir en python?\"");
        tituloPregunta=new JTextField();
        tituloPregunta.setBounds(10,120,400,30);
        add(tituloPregunta);

        texto2=new JLabel("Cuerpo");
        texto2.setBounds(10,150,120,30);
        add(texto2);

        pregunta=new JTextArea();
        scroll=new JScrollPane(pregunta);
        scroll.setBounds(10,180,400,200);
        add(scroll);

        texto3=new JLabel("Etiquetas");
        texto3.setBounds(10,380,120,30);
        add(texto3);


        ayuda=new JButton("?");
        ayuda.setBounds(389,385,20,20);
        ayuda.setBackground(new java.awt.Color(0,170,228));
        ayuda.setForeground(Color.white);
        ayuda.setFont(new Font("dialog",Font.PLAIN,10));
        ayuda.setMargin(new Insets(0, 0, 0, 0));
        add(ayuda);
        ayuda.addActionListener(this);

        texto4=new JLabel("");
        texto4.setBounds(410,363,120,60);
        add(texto4);

        /*texto4=new JLabel("<html><body><p style=\"color:#9A9A9A\";>Separa las etiquetas con espacios</html></body></p>");
        texto4.setBounds(210,380,300,30);
        add(texto4);*/

        etiquetas= new JTextField();
        etiquetas.setBounds(10,410,400,30);
        add(etiquetas);

        boton1=new JButton("Enviar pregunta");
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
            Etiquetas tag = new Etiquetas(etiquetas.getText());
            menu.stack.ask(titulo.getText(),pregunta.getText(),tag);

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
        else if(e.getSource()==ayuda){
            texto4.setText("<html><body><p style=\"color:#6c6c6c\";>Separa las etiquetas <br> con espacios</html></body></p>");
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
