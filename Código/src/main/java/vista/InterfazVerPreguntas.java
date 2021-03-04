package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazVerPreguntas extends JFrame implements ActionListener {
    public static InterfazMenu menu = new InterfazMenu();
    private JTable tablaDatos;
    //private DefaultTableModel modelo = new DefaultTableModel();
    private JLabel titulo;
    private JButton boton2;
    private JScrollPane scroll;

    public static InterfazMenu Menu= new InterfazMenu();
    private InterfazUsuario userMenu= new InterfazUsuario();


    public InterfazVerPreguntas(){
        setLayout(null);
        modificarTabla();

        titulo=new JLabel("Responder Pregunta");
        titulo.setBounds(350,30,120,30);
        add(titulo);

        scroll=new JScrollPane(tablaDatos);
        scroll.setBounds(10,60,763,300);
        //scroll.setBounds();
        add(scroll);

        boton2=new JButton("Volver");
        boton2.setBounds(350,450,90,30);
        add(boton2);
        boton2.addActionListener(this);
    }

    public void modificarTabla(){
        String[][] datos=new String[menu.stack.getPreguntas().size()][7];
        Boolean[] estados=new Boolean[menu.stack.getPreguntas().size()];
        int i;

        for(i=0;i<menu.stack.getPreguntas().size();i++){
            datos[i][0]=menu.stack.getPreguntas().get(i).getID()+"";
            datos[i][1]=menu.stack.getPreguntas().get(i).getTitulo();
            datos[i][2]=menu.stack.getPreguntas().get(i).getEtiquetas().tagToString();
            datos[i][3]=menu.stack.getPreguntas().get(i).getPregunta();
            datos[i][4]=menu.stack.getPreguntas().get(i).getFecha().toString();//si se cae este coso lo cambio por string date o como sea
            datos[i][5]=menu.stack.getPreguntas().get(i).getAutor().getUser();
            datos[i][6]=menu.stack.getPreguntas().get(i).getRecompensa()+"";

            estados[i]=menu.stack.getPreguntas().get(i).getEstado();
        }

        tablaDatos=new JTable(new DefaultTableModel(datos,new String[]{"ID","T\u00edtulo","Etiquetas","Pregunta","Fecha","Autor","Recompensa"}));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton2){
            userMenu.setBounds(0,0,550,550);
            userMenu.setResizable(false);
            userMenu.setLocationRelativeTo(null);
            userMenu.setVisible(true);
            this.setVisible(false);
        }
    }
}
