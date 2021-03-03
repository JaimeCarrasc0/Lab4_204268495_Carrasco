package vista;

import javax.swing.*;
import java.awt.event.*;

/**
 * clase interfaz register
 */
public class InterfazRegister extends JFrame implements ActionListener {
    private JLabel titulo, texto1, texto2;
    private JButton boton1,boton2,boton3;
    private JTextField usuario;
    private JPasswordField pass;
    private InterfazMenu menu;

    public InterfazRegister(){
        setLayout(null);
        titulo= new JLabel("Registro nuevo usuario");
        titulo.setBounds(195,30,180,30);
        add(titulo);

        texto1=new JLabel("Usuario");
        texto1.setBounds(10,200,150,30);
        add(texto1);

        usuario= new JTextField();
        usuario.setBounds(10,230,150,25);
        add(usuario);

        texto2=new JLabel("Contrase\u00f1a");
        texto2.setBounds(10,300,150,30);
        add(texto2);

        pass=new JPasswordField();
        pass.setBounds(10,330,150,25);
        add(pass);

        boton1=new JButton("Registrar");
        boton1.setBounds(10,450,150,30);
        add(boton1);
        boton1.addActionListener(this);

        boton2=new JButton("Volver");
        boton2.setBounds(300,450,90,30);
        add(boton2);
        boton2.addActionListener(this);

        boton3=new JButton("Salir");
        boton3.setBounds(400,450,90,30);
        add(boton3);
        boton3.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menu=new InterfazMenu();
        menu.setBounds(0,0,550,550);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);

        if (e.getSource()==boton1){
            //realizar registro con el código anterior
            String user=usuario.getText();
            String password=pass.getText();
            setTitle("Sesi\u00f3n iniciada como "+user);
            menu.setVisible(true);
            this.setVisible(false);
            //System.out.println(password);
        }
        else if (e.getSource()==boton2){

            menu.setVisible(true);
            this.setVisible(false);
        }
        else if (e.getSource()==boton3){
            System.exit(0);
        }
    }
}
