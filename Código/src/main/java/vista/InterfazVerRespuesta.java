package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

/**
 * Interfaz para ver la respuesta seleccionada
 * @author Jaime Carrasco
 */

public class InterfazVerRespuesta extends JFrame implements ActionListener {
    public static InterfazMenu menu = new InterfazMenu();
    private InterfazVerPreguntas pregMenu= new InterfazVerPreguntas(0);
    private JTable tablaDatos;
    private DefaultTableModel modelo = new DefaultTableModel();
    private JLabel titulo,texto2;
    private JTextArea respuesta;
    private JButton boton1,boton2,boton3;
    private JScrollPane scroll;
    private JDialog ventanita;

    public static InterfazMenu Menu= new InterfazMenu();
    private InterfazUsuario userMenu= new InterfazUsuario();
    public static int respuestaEscogida;

    public InterfazVerRespuesta(){
        modificarTabla();
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

    /*
     Considere incluir un ID (único y autoincremental)
     Autor
     Fecha de publicación
     Contenido
    */

    /**
     * Modificación de la tabla que se utiliza para mostrar las respuestas del stack
     */

    public void modificarTabla(){
        String[][] datos=new String[menu.stack.getPreguntas().get(pregMenu.preguntaEscogida).getRespuestas().size()][4];

        int i;
        for(i=0;i<menu.stack.getPreguntas().get(pregMenu.preguntaEscogida).getRespuestas().size();i++){
            datos[i][0]=menu.stack.getPreguntas().get(i).getRespuestas().get(i).getID()+"";
            datos[i][1]=menu.stack.getPreguntas().get(i).getRespuestas().get(i).getAutor().getUser();
            datos[i][2]=menu.stack.getPreguntas().get(i).getRespuestas().get(i).getFecha().toString();
            datos[i][3]=menu.stack.getPreguntas().get(i).getRespuestas().get(i).getRespuesta();

        }

        modelo=new DefaultTableModel(datos,new String[]{
                "ID","T\u00edtulo","Etiquetas","Pregunta","Fecha","Autor","Recompensa"
        });

        tablaDatos=new JTable(modelo);

        tablaDatos.addMouseListener(new MouseAdapter() {
            /**
             * Funcionalidad para traducir los eventos del mouse en la tabla
             * @param e entrada evento
             */
            @Override
            public void mouseClicked(MouseEvent e){
                int fila= tablaDatos.rowAtPoint(e.getPoint());

                if (fila>-1){
                    String aux="";
                    aux=(String) modelo.getValueAt(fila,NORMAL);
                    respuestaEscogida = Integer.parseInt(aux);
                    InterfazAceptarRespuesta acp=new InterfazAceptarRespuesta();
                    acp.setBounds(0,0,800,550);
                    acp.setResizable(false);
                    acp.setLocationRelativeTo(null);
                    acp.setVisible(true);

                }
            }
        });


    }
}
