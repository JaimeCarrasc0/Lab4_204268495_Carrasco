package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Interfaz para ver las preguntas del stack
 * @author Jaime Carrasco
 */

public class InterfazVerPreguntas extends JFrame implements ActionListener {
    public static InterfazMenu menu = new InterfazMenu();
    private JTable tablaDatos;
    private DefaultTableModel modelo = new DefaultTableModel();
    private JLabel titulo;
    private JButton boton2;
    private JScrollPane scroll;
    private Boolean[] estados=new Boolean[menu.stack.getPreguntas().size()];
    private JDialog ventanita;

    public static InterfazMenu Menu= new InterfazMenu();
    private InterfazUsuario userMenu= new InterfazUsuario();
    public static int preguntaEscogida;

    /**
     * Constructor de la clase
     * @param selector Se utiliza un auxiliar selector para saber para qué se necesita la visualización de las preguntas.
     *                 si es 0 se utiliza para aceptar una respuesta, si se usa 1 es para añadir una respuesta al stack
     */
    public InterfazVerPreguntas(int selector){
        setLayout(null);
        modificarTabla(selector);

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

    /**
     * Modificación de la tabla que se utiliza para mostrar las preguntas del stack
     * @param aux selector ingresado en el cosntructor
     */
    public void modificarTabla(int aux){
        String[][] datos=new String[menu.stack.getPreguntas().size()][7];

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

        modelo=new DefaultTableModel(datos,new String[]{
                "ID","T\u00edtulo","Etiquetas","Pregunta","Fecha","Autor","Recompensa"
        });

        tablaDatos=new JTable(modelo);

        switch (aux) {
            case 0:
                /**
                 * Caso 0, es decir aceptar respuesta
                 */
                tablaDatos.addMouseListener(new MouseAdapter() {
                    /**
                     * Funcionalidad para traducir los eventos del mouse en la tabla
                     * @param e entrada evento
                     */
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int fila = tablaDatos.rowAtPoint(e.getPoint());
                        //int columna=

                        if (fila > -1) {
                            String aux = "";
                            aux = (String) modelo.getValueAt(fila, NORMAL);
                            preguntaEscogida = Integer.parseInt(aux);
                            //System.out.println(preguntaEscogida);

                            //pregunta.getAutor()==activos.get(activos.size()-1)

                            if ((estados[fila]) && (menu.stack.getPreguntas().get(fila).getAutor() == menu.stack.getActivos().get(menu.stack.getActivos().size() - 1))) {
                                InterfazVerRespuesta resp = new InterfazVerRespuesta();
                                resp.setBounds(0, 0, 550, 550);
                                resp.setResizable(false);
                                resp.setLocationRelativeTo(null);
                                resp.setVisible(true);
                            }
                            else if (estados[fila] == false) {
                                InterfazVerPreguntas ventAux = new InterfazVerPreguntas(0);
                                ventanita = new JDialog(ventAux, true);
                                JLabel dialogo = new JLabel("La pregunta que seleccionaste est\u00e1 cerrada.");
                                ventanita.getContentPane().add(dialogo);
                                ventanita.setTitle("PREGUNTA INV\u00c1LIDA");
                                ventanita.pack();
                                ventanita.setBounds(0, 0, 350, 150);
                                ventanita.setLocationRelativeTo(null);
                                ventanita.setVisible(true);
                            } else {
                                InterfazVerPreguntas ventAux = new InterfazVerPreguntas(0);
                                ventanita = new JDialog(ventAux, true);
                                JLabel dialogo = new JLabel("<html><body>La pregunta que seleccionaste <p style=\"color:#FF0000\";>NO</p> es tuya.</body></html>");
                                ventanita.getContentPane().add(dialogo);
                                ventanita.setTitle("PREGUNTA INV\u00c1LIDA");
                                ventanita.pack();
                                ventanita.setBounds(0, 0, 350, 150);
                                ventanita.setLocationRelativeTo(null);
                                ventanita.setVisible(true);
                            }


                        }
                    }
                });
                break;


            case 1:
                /**
                 * caso 1, añadir respuesta
                 */
                tablaDatos.addMouseListener(new MouseAdapter() {
                    /**
                     * Funcionalidad para traducir los eventos del mouse en la tabla
                     * @param e entrada evento
                     */
                    @Override
                    public void mouseClicked(MouseEvent e){
                        int fila= tablaDatos.rowAtPoint(e.getPoint());
                        //int columna=

                        if(fila>-1){
                            String aux="";
                            aux=(String) modelo.getValueAt(fila,NORMAL);
                            preguntaEscogida=Integer.parseInt(aux);
                            //System.out.println(preguntaEscogida);

                            if(estados[fila]){
                                InterfazResponder resp = new InterfazResponder();
                                resp.setBounds(0,0,550,550);
                                resp.setResizable(false);
                                resp.setLocationRelativeTo(null);
                                resp.setVisible(true);
                            }
                            else {
                                InterfazVerPreguntas ventAux= new InterfazVerPreguntas(1);
                                ventanita=new JDialog(ventAux,true);
                                JLabel dialogo=new JLabel("La duda que intentas responder, ya est\u00e1 resuelta.");
                                ventanita.getContentPane().add(dialogo);
                                ventanita.setTitle("PREGUNTA CERRADA");
                                ventanita.pack();
                                ventanita.setBounds(0,0,350,150);
                                ventanita.setLocationRelativeTo(null);
                                ventanita.setVisible(true);

                            }


                        }
                    }
                });
                break;

        }
    }

    /**
     * Funcionalidad para traducir los eventos de botones
     * @param e entrada evento
     */
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
