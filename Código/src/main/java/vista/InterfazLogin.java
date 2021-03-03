package vista;

import modelo.*;

import javax.swing.*;
import java.awt.event.*;

/**
 * Clase interfaz login
 */
public class InterfazLogin extends JFrame implements ActionListener{
    private JLabel titulo, texto1, texto2, titulo2;
    private JButton boton1, boton2, boton3;
    private JTextField usuario;
    private JPasswordField pass;
    public static InterfazMenu menu = new InterfazMenu();

    public InterfazLogin(){
        setLayout(null);
        titulo=new JLabel("Iniciar Sesi\u00f3n");
        titulo.setBounds(215,30,120,30);
        add(titulo);

        titulo2=new JLabel("");
        titulo2.setBounds(10,150,300,50);
        add(titulo2);

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

        boton1=new JButton("Ingresar");
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

        if (e.getSource()==boton1){
            String user=usuario.getText();
            String password=pass.getText();
            if (menu.stack.login(user,password)){
                InterfazUsuario menuUser = new InterfazUsuario();
                menuUser.setBounds(0,0,550,550);
                menuUser.setVisible(true);
                menuUser.setResizable(false);
                menuUser.setLocationRelativeTo(null);
                this.setVisible(false);
                //enviar a otra interfaz
            }
            else{
                titulo2.setText("<html><body><p style=\"color:#FF0000\";>Usuario o contrase\u00f1a equivocada.</p><br>Reint\u00e9ntelo</body></html>");
            }


            setTitle("Sesi\u00f3n iniciada como "+user);
            //System.out.println(password);
        }
        else if (e.getSource()==boton2){
            menu.setBounds(0,0,550,550);
            menu.setResizable(false);
            menu.setLocationRelativeTo(null);
            menu.setVisible(true);
            this.setVisible(false);
        }
        else if (e.getSource()==boton3){
            System.exit(0);
        }

    }
}
