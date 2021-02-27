package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Esta clase define a las preguntas que realizan los usuarios
 * @author Jaime Carrasco
 */

public class Pregunta {
    /*
    ID (único y autoincremental)
    Respuestas
    Etiquetas
    Título
    Contenido
    Fecha de publicación
    Autor (usuario)
    Estado (con respuesta aceptada o no)
    Recompensa
    */
    private int ID;
    private String titulo;
    private Etiquetas tags;
    private String pregunta;
    private Date fecha;
    //private fecha; debo averiguar como hacer esto xD
    private Usuario autor;
    private boolean estado; //True=pregunta abierta, False=pregunta cerrada
    private int recompensa;
    private ArrayList<Respuesta> respuestas;

    /**
     * Constructor de Pregunta
     * @param id id de la pregunta
     * @param titulo titulo de la pregunta
     * @param etiquetas etiquetas d ela pregunta
     * @param pregunta contenido de la pregunta
     * @param autor autor de la pregunta
     * @param estado si está abierta la pregunta es true, sino,es false
     * @param recompensa cantidad de puntos ofrecidos por la pregunta
     * @param respuestas listado de las respuestas de la pregunta
     */
    public Pregunta(int id, String titulo, Etiquetas etiquetas,String pregunta, Usuario autor, boolean estado, int recompensa, ArrayList<Respuesta> respuestas){
        this.ID=id;
        this.titulo=titulo;
        this.tags=etiquetas;
        this.pregunta=pregunta;
        this.fecha=new Date();
        this.autor=autor;
        this.estado=estado;
        this.recompensa=recompensa;
        this.respuestas=respuestas;
    }

    /**
     * getter del id
     * @return id de la pregunta
     */
    public int getID() {
        return ID;
    }

    /**
     * getter del titulo
     * @return titulo de la pregunta
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * getter de la pregunta
     * @return la pregunta
     */
    public String getPregunta() {
        return pregunta;
    }

    /**
     * getter del autor
     * @return el autor de la pregunta
     */
    public Usuario getAutor() {
        return autor;
    }

    /**
     * getter del estado
     * @return booleano
     */
    public boolean getEstado(){
        return estado;
    }

    /**
     * getter de la recompensa
     * @return un entero
     */
    public int getRecompensa() {
        return recompensa;
    }

    /**
     * getter de las respuestas
     * @return listado con las respuestas de la pregunta
     */
    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }

    /**
     * getter de las etiquetas
     * @return las etiquetas de la pregunta
     */
    public Etiquetas getEtiquetas() {
        return tags;
    }

    /**
     * getter de la fecha
     * @return fecha de la pregunta
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * añade una respuesta a la pregunta seleccionada
     * @param respuesta ingresa la respuesta que se desea agregar
     */
    public void anadirRespuesta(Respuesta respuesta){
        this.respuestas.add(respuesta);
    }


}
