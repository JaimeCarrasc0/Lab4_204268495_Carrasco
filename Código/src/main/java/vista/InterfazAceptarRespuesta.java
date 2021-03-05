package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Clase para aceptar respuestas
 * @author Jaime Carrasco
 */
public class InterfazAceptarRespuesta extends JFrame implements ActionListener {
    private JLabel titulo, texto1, texto2,texto3,texto4;
    //private JPanel texto;
    public static InterfazMenu menu =new InterfazMenu();
    public InterfazVerRespuesta resp= new InterfazVerRespuesta();
    public InterfazVerPreguntas preg=new InterfazVerPreguntas(0);
    //private JLabel cont,aut,fech,pregun,titulo
    private JButton boton1,boton2,boton3;
    private JScrollPane scroll1;

    /**
     * constructor clase
     */
    public InterfazAceptarRespuesta(){
        setLayout(null);
        String contenido="",autor="",fecha="",pregunta="";
        contenido+=menu.stack.getPreguntas().get(preg.preguntaEscogida).getRespuestas().get(resp.respuestaEscogida).getRespuesta();
        autor+=menu.stack.getPreguntas().get(preg.preguntaEscogida).getRespuestas().get(resp.respuestaEscogida).getAutor().getUser();
        fecha+=menu.stack.getPreguntas().get(preg.preguntaEscogida).getRespuestas().get(resp.respuestaEscogida).getFecha().toString();
        pregunta+=menu.stack.getPreguntas().get(preg.preguntaEscogida).getPregunta();

        titulo= new JLabel("Aceptar respuesta");
        titulo.setBounds(215,30,120,30);
        add(titulo);

        texto1=new JLabel(pregunta);
        texto1.setBounds(10,50,400,100);
        add(texto1);

        texto2=new JLabel(contenido);
        //scroll1=new JScrollPane(texto2);
        //scroll1.setBounds(10,120,400,400);
        //add(scroll1);
        texto2.setBounds(10,120,400,400);
        add(texto2);
    }


    /**
     * Funcionalidad para traducir los eventos de botones
     * @param e entrada evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
