package modelo;

import java.util.ArrayList;

/**
 * Esta clase define al stack, unidad fundamental para organizar las preguntas, usuarios y demás.
 * @author Jaime Carrasco
 */
public class Stack {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Pregunta> preguntas;
    private ArrayList<Usuario> activos;
    private ArrayList<Retenidos> retenidos;

    /**
     * Constructor para la clase stack
     * @param usuarios arreglo del tipo Usuario
     * @param preguntas arreglo del tipo Pregunta
     * @param activos arreglo del tipo activos
     */

    public Stack(ArrayList<Usuario> usuarios, ArrayList<Pregunta> preguntas, ArrayList<Usuario> activos) {
        this.usuarios = usuarios;
        this.preguntas = preguntas;
        this.activos = activos;
        this.retenidos= new ArrayList<>();
    }

    /**
     * getter de usuarios
     * @return arreglo con los usuarios del stack
     * NO LA LLAMANAAAAAAAAAAa
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * getter de los datos del usuario
     * @param username nombre del usuario que se desea obtener datos
     * @return los datos del usuario, o null si es que no existe el usuario
     */
    private Usuario getUserData(String username) {
        int i;
        for (i = 0; i < usuarios.size(); i++) {
            if (username.equals(usuarios.get(i).getUser())) {
                return usuarios.get(i);
            }
        }
        return null;
    }

    /**
     * getter de las preguntas
     * @return el arreglo de las preguntas
     */
    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    /**
     * getter de los usuarios activos
     * @return el arreglo de los usuarios activos
     */
    public ArrayList<Usuario> getActivos() {
        return activos;
    }

    /**
     * verificar la existencia de un usuario
     * @param user nombre de usuario
     * @return booleano
     */
    public Boolean existeUsuario(String user) {
        int i;
        //String aux;
        for (i = 0; i < usuarios.size(); i++) {
            //aux=usuarios.get(i);
            if (user.equals(usuarios.get(i).getUser())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Añadir un usuario nuevo al stack
     * @param nuevoUsuario un usuario
     */
    public void registrarUsuario(Usuario nuevoUsuario) {
        this.usuarios.add(nuevoUsuario);
    }

    /**
     * Login
     * @param user nombre del usuario
     * @param pass contraseña del usuario
     * @return booleano, este indica si se logra iniciar sesión o no.
     */
    public boolean login(String user, String pass) {
        int i;
        for (i = 0; i < usuarios.size(); i++) {
            if (user.equals(usuarios.get(i).getUser())) {
                if (pass.equals(usuarios.get(i).getPass())) {
                    Usuario aux = getUserData(user);
                    //System.out.println("Aux=");
                    //aux.imprimirDatos();
                    this.activos.add(aux);
                    return true;
                } else {
                    System.out.println("Clave incorrecta, intentelo de nuevo...");
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * logout
     * @param user nombre de usuario.
     */
    public void logout(String user) {
        int i;
        for (i = 0; i < activos.size(); i++) {
            if (user.equals(activos.get(i).getUser())) {
                activos.remove(i);
                System.out.println("Sesión cerrada con éxito!");
            }
        }
    }

    /*
    ID (único y autoincremental)
    Respuestas
    Etiquetas
    Título
    Contenido
    Fecha de publicación
    Autor (usuario)
    Estado //True=pregunta abierta, False=pregunta cerrada
    Recompensa
    */

    /**
     * ask
     * @param titulo titulo de la pregunta en String
     * @param pregunta contenido de la pregunta en string
     * @param etiquetas Etiquetas seleccionadas para la pregunta
     */
    public void ask(String titulo, String pregunta, Etiquetas etiquetas) {
        //Date fechaActual = new Date();
        int id = preguntas.size();
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        Usuario autor = activos.get(activos.size() - 1);

        Pregunta nuevaPregunta = new Pregunta(id, titulo, etiquetas, pregunta, autor, true, 0, respuestas);

        this.preguntas.add(nuevaPregunta);
    }

    /**
     * Imprimir las preguntas del stack
     */
    public void imprimirPreguntas(){
        int i,j;
        for(i=0;i<preguntas.size();i++){
            System.out.println("════════════════════════════════════════════════════════════════════");
            System.out.println("\nID #"+preguntas.get(i).getID());
            System.out.println("Titulo: "+preguntas.get(i).getTitulo());
            for(j=0;j<preguntas.get(i).getEtiquetas().getTags().size();j++){
                System.out.println("["+preguntas.get(i).getEtiquetas().getTags().get(j)+"]: "+preguntas.get(i).getEtiquetas().getDescripcion().get(j)+"\n");
            }
            System.out.println("Pregunta: "+preguntas.get(i).getPregunta() + "\t\tRecompensa: "+preguntas.get(i).getRecompensa());
            System.out.println("Fecha consulta: "+preguntas.get(i).getFecha());
            System.out.println("Pregunta realizada por: "+preguntas.get(i).getAutor().getUser());

            if(preguntas.get(i).getRespuestas().size()==0){
                System.out.println("Esta pregunta aún no tiene respuestas, sé el primero en responder.");
            }
            else{
                System.out.println("Respuestas: ");
                for(j=0;j<preguntas.get(i).getRespuestas().size();j++){
                    preguntas.get(i).getRespuestas().get(j).imprimirRespuestas();
                }
                //realizar print respuestas en clase respuestas xD
            }
            if (preguntas.get(i).getEstado()){
                System.out.println("Esta pregunta sigue abierta, aún puedes responderla!");
            }
            else {
                System.out.println("Este hilo ya está cerrado");
            }

            //System.out.println(preguntas.get(i));
        }
    }

    /**
     * Imprimir las preguntas del stack, en este caso, imprime todas las que corresponden a un autor específico
     * @param autor autor de las preguntas
     */
    public void imprimirPreguntas(Usuario autor){
        int i,j;
        for(i=0;i<preguntas.size();i++){
            if(preguntas.get(i).getAutor()==autor){
                System.out.println("────────────────────────────────────────────────────────────────────");
                System.out.println("ID #"+preguntas.get(i).getID());
                System.out.println("Titulo: "+preguntas.get(i).getTitulo());
                for(j=0;j<preguntas.get(i).getEtiquetas().getTags().size();j++){
                    System.out.println("["+preguntas.get(i).getEtiquetas().getTags().get(j)+"]: "+preguntas.get(i).getEtiquetas().getDescripcion().get(j)+"\n");
                }
                System.out.println("Pregunta: "+preguntas.get(i).getPregunta() + "\t\tRecompensa: "+preguntas.get(i).getRecompensa());
                System.out.println("Fecha consulta: "+preguntas.get(i).getFecha());

                if(preguntas.get(i).getRespuestas().size()==0){
                    System.out.println("Esta pregunta aún no tiene respuestas.");
                }
                /*else{
                    System.out.println("Respuestas: ");
                    for(j=0;j<preguntas.get(i).getRespuestas().size();j++){
                        preguntas.get(i).getRespuestas().get(j).imprimirRespuestas();
                    }
                    //realizar print respuestas en clase respuestas xD
                }*/
                if (preguntas.get(i).getEstado()){
                    System.out.println("Esta pregunta sigue abierta.");
                }
                else {
                    System.out.println("Este hilo ya está cerrado");
                }
            }
        }
    }

    /**
     * Imprime las respuestas que corresponden a una pregunta
     * @param pregunta la pregunta que se desea imprimir las respuestas
     */
    public void imprimirRespuestas(Pregunta pregunta){
        int i;
        System.out.println("Respuestas: ");
        for(i=0;i<pregunta.getRespuestas().size();i++){
            pregunta.getRespuestas().get(i).imprimirRespuestas();
        }
    }



    /**
     * answer
     * @param id id de la pregunta
     * @param respuesta contenido de la respuesta
     * @return boolean sobre si se pudo contestar o no.
     */
    public boolean answer(int id, String respuesta){
        if (id<preguntas.size()) {
            if (preguntas.get(id).getEstado()) {
                int idRes = preguntas.get(id).getRespuestas().size();
                Respuesta res = new Respuesta(idRes, activos.get(activos.size() - 1), respuesta);
                preguntas.get(id).anadirRespuesta(res);
                return true;
            } else {
                System.out.println("La duda que intentas responder, ya está resuelta.");
                return false;
            }
        }
        System.out.println("Pregunta no existente! intentelo de nuevo.");
        return false;

    }

    /**
     * se añade la retención de puntos al usuariio que ofrece recompensa
     * @param autor autor del tipo Usuario
     * @param ptjeRet puntaje que se retiene
     * @param pregunta pregunta donde va a retenerse
     */
    private void anadirRetencion(Usuario autor, int ptjeRet, Pregunta pregunta){
        Retenidos retencion= new Retenidos(autor, ptjeRet, pregunta);
        this.retenidos.add(retencion);
    }

    /**
     * reward
     * @param pregunta pregunta donde se entrega recompensa
     * @param recompensa cantidad de puntaje que se entrega
     */
    public void reward(Pregunta pregunta, int recompensa){
        Usuario persona=activos.get(activos.size()-1);
        if(recompensa<=persona.getReputacion()){
            anadirRetencion(persona,recompensa,pregunta);
        }
        else{
            System.out.println("No es posible ofrecer esa cantidad de recompensa, intentalo más tarde.");
        }
    }

    /**
     * se aplica el descuento al usuario que ofreció recompensa
     * @param donante el usuario que ofreció puntos
     * @param puntajeResta el puntaje que se le quita
     */
    private void aplicarDescuento(Usuario donante, int puntajeResta){
        int i;
        for(i=0;i<usuarios.size();i++){
            if(usuarios.get(i) == donante){
                this.usuarios.get(i).anadirReputacion(-puntajeResta);
            }
        }
    }

    /**
     * entrega la recompensa que se ofreció
     * @param pregunta pregunta seleccionada
     * @param premiado usuario que recibe el puntaje
     */
    private void entregarReward(Pregunta pregunta, Usuario premiado){
        int i, recompensa=0;
        ArrayList<Integer> quitar=new ArrayList<>();
        if(retenidos.size()>=1) {
            for (i = 0; i < retenidos.size(); i++) {
                if (retenidos.get(i).getQuestion() == pregunta) {
                    recompensa += retenidos.get(i).getPuntajeRetenido();
                    //retenidos.get(i).getUser().anadirReputacion(-retenidos.get(i).getPuntajeRetenido());
                    aplicarDescuento(retenidos.get(i).getUser(), retenidos.get(i).getPuntajeRetenido());
                    quitar.add(i);
                }
            }

            for (i = 0; i < quitar.size(); i++) {
                //quitamos a los que tenían puntaje retenido ya que se les descontó el puntaje retenido.

                this.retenidos.remove(quitar.get(i));
            }
        }
        else{

            recompensa=pregunta.getRecompensa();
        }

        premiado.anadirReputacion(recompensa+15);//se añaden 15 puntos porque la respuesta fue aceptada.
    }

    /**
     * Accept
     * @param pregunta pregunta que se desea aceptar la respuesta
     * @param respuesta respuesta seleccionada para aceptar
     */
    public void accept(Pregunta pregunta, Respuesta respuesta){
        if(pregunta.getAutor()==activos.get(activos.size()-1)){
            entregarReward(pregunta,respuesta.getAutor());
            activos.get(activos.size()-1).anadirReputacion(2-pregunta.getRecompensa());//se agregan 2 puntos al usuario por aceptar la respuesta
        }
    }
}