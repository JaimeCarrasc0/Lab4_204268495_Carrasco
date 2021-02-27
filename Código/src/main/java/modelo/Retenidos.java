package modelo;

public class Retenidos {
    private Usuario user;
    private int puntajeRetenido;
    private Pregunta question;

    /**
     * Constructor de Retenidos
     * @param user usuario que se retiene puntaje
     * @param puntaje la cantidad de puntaje que se retiene
     * @param pregunta la pregunta donde se retiene el puntaje
     */
    public Retenidos(Usuario user, int puntaje, Pregunta pregunta){
        this.user=user;
        this.puntajeRetenido=puntaje;
        this.question=pregunta;
    }

    /**
     * getter de la pregunta que está el usuario
     * @return la pregunta
     */
    public Pregunta getQuestion() {
        return question;
    }

    /**
     * getter del puntaje que se retiene
     * @return el puntaje
     */
    public int getPuntajeRetenido() {
        return puntajeRetenido;
    }

    /**
     * getter del usuario
     * @return el usuario que está retenido
     */
    public Usuario getUser() {
        return user;
    }
}
