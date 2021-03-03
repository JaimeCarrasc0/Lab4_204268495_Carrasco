package modelo;

import java.util.Date;

/**
 * Esta clase define a las respuestas de las preguntas
 * @author Jaime Carrasco
 */

public class Respuesta {
    /*
     Considere incluir un ID (único y autoincremental)
     Autor
     Fecha de publicación
     Contenido
    */

    private int ID;
    private Usuario autor;
    private Date fecha;
    //private fecha; debo averiguar como hacer esto xD
    private String respuesta;

    /**
     * Constructor de Respuesta
     * @param id entero que maneja el id de la respuesta
     * @param autor autor de la respuesta
     * @param contenido contenido de la respuesta
     */
    public Respuesta(int id, Usuario autor, String contenido){
        this.ID=id;
        this.autor=autor;
        this.fecha=new Date();
        this.respuesta=contenido;
    }


    /**
     * getter del id
     * @return el id
     */
    public int getID() {
        return ID;
    }

    /**
     * getter del autor
     * @return el autor
     */
    public Usuario getAutor() {
        return autor;
    }

    /**
     * getter de la fecha
     * @return la fecha de la respuesta
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * imprime el contenido de la respuesta
     */
    public void imprimirRespuestas(){
        //System.out.println("\tR #"+ID);
        System.out.println("R #"+ID+"\tAutor: "+autor.getUser()+"\t Fecha: "+fecha);
        System.out.println("\tRespuesta:\n\t\t"+respuesta);
    }
}