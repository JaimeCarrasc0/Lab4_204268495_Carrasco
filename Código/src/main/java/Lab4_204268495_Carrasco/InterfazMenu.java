package Lab4_204268495_Carrasco;

import javax.swing.*;
import java.awt.event.*;

public class InterfazMenu extends JFrame implements ActionListener{
    private JLabel etiqueta;
    private JButton boton1,boton2,boton3;

    public InterfazMenu(){
        setLayout(null);

        boton1= new JButton("Iniciar Sesión");
        boton1.setBounds(10,200,150,30);
        add(boton1);
        boton1.addActionListener(this);

        boton2= new JButton("Registrarse");
        boton2.setBounds(10,250,150,30);
        add(boton2);
        boton2.addActionListener(this);

        boton3 =new JButton("Salir");
        boton3.setBounds(10,300,150,30);
        add(boton3);
        boton3.addActionListener(this);

        etiqueta = new JLabel("Simulador Stack Overflow");
        etiqueta.setBounds(10, 10, 200, 300);
        add(etiqueta);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==boton1){
            //System.out.println("Iniciar Sesión");
            etiqueta.setText("Iniciar Sesión");
        }
        else if(e.getSource() == boton2){
            //System.out.println("Registrarse");
            etiqueta.setText("Registrarse");
            }
        else if(e.getSource() == boton3){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        InterfazMenu menu= new InterfazMenu();
        menu.setBounds(0,0,550,550);
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        menu.setResizable(false);

    }
}
