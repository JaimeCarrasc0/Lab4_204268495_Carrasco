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

    public Stack(){
        ArrayList<Respuesta> respuestas1 = new ArrayList<>();
        ArrayList<Respuesta> respuestas2 = new ArrayList<>();
        ArrayList<Respuesta> respuestas3 = new ArrayList<>();
        ArrayList<Respuesta> respuestas4 = new ArrayList<>();
        ArrayList<Respuesta> respuestas5 = new ArrayList<>();

        Usuario user1=new Usuario("Julián","Alonso",3);
        Usuario user2=new Usuario("Jaime","Alejandro",5);
        Usuario user3=new Usuario("31110t","mrRob0t",50);
        //Usuario user4=new Usuario("LazarB3am","Lannan",35);
        Usuario user4=new Usuario("","",35);

        Respuesta answer1=new Respuesta(0,user2,"Debes usar input");
        Respuesta answer2=new Respuesta(1,user3,"input");

        respuestas1.add(answer1);
        respuestas1.add(answer2);

        Respuesta answer3=new Respuesta(0,user4,"Creo que debes usar display");
        Respuesta answer4=new Respuesta(1,user1,"Usa display");

        respuestas2.add(answer3);
        respuestas2.add(answer4);

        Respuesta answer5=new Respuesta(0,user1,"debes usar %c y al printf como parámetros secundarios pones el ascii del caracter que quieres");
        Respuesta answer6=new Respuesta(1,user2,"usa ascii");

        respuestas3.add(answer5);
        respuestas3.add(answer6);

        Respuesta answer7=new Respuesta(0,user2,"");
        Respuesta answer8=new Respuesta(1,user3,"");

        respuestas4.add(answer7);
        respuestas4.add(answer8);

        Respuesta answer9=new Respuesta(0,user2,"Usa print(<lo que quieres imprimir>)");
        Respuesta answer10=new Respuesta(1,user3,"Usa print");

        respuestas5.add(answer9);
        respuestas5.add(answer10);

        ArrayList<String> auxTag=new ArrayList<>();
        auxTag.add("Python");
        ArrayList<String> auxDesc=new ArrayList<>();
        auxDesc.add("Python es un lenguaje multiparadigmas, de tipeo bajo.");


        Etiquetas tag1=new Etiquetas(auxTag,auxDesc);

        auxTag.clear();
        auxDesc.clear();

        auxTag.add("Scheme");
        auxDesc.add("Sheme es un lenguaje funcional, de tipeo bajo.");

        Etiquetas tag2=new Etiquetas(auxTag,auxDesc);

        auxTag.clear();
        auxDesc.clear();

        auxTag.add("C");
        auxDesc.add("C es un lenguaje Imperativo, de tipeo alto.");

        Etiquetas tag3=new Etiquetas(auxTag,auxDesc);

        ArrayList<String> etiquetasStack=new ArrayList<>();
        etiquetasStack.add("Python");
        etiquetasStack.add("Scheme");
        etiquetasStack.add("C");

        ArrayList<String> descripcionEtiquetas=new ArrayList<>();
        descripcionEtiquetas.add("Python es un lenguaje multiparadigmas, de tipeo bajo.");
        descripcionEtiquetas.add("Sheme es un lenguaje funcional, de tipeo bajo.");
        descripcionEtiquetas.add("C es un lenguaje Imperativo, de tipeo alto.");

        Etiquetas tagStack = new Etiquetas(etiquetasStack,descripcionEtiquetas);


        Pregunta question1=new Pregunta(0,"Ayuda con python",tag1,"Cómo puedo ingresar datos?",user1,true,2, respuestas1);
        Pregunta question2=new Pregunta(1,"Ayuda con Scheme",tag2,"Como puedo imprimir por pantalla en scheme?",user2,true,3,respuestas2);
        Pregunta question3=new Pregunta(2,"Ayuda con C",tag3,"Alguien sabe como puedo hacer que C utilice tildes?",user4,false,10,respuestas3);
        Pregunta question4=new Pregunta(3,"Spotify en python",tag2,"Como puedo obtener los datos de una playlist de spotify con python?",user1,true,1,respuestas4);
        Pregunta question5=new Pregunta(4,"Cómo mostrar por pantalla en python",tag2,"Hola como puedo imprimir datos en python?",user4,false,5,respuestas5);

        ArrayList<Usuario> usuarios= new ArrayList<>();
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);
        usuarios.add(user4);

        ArrayList<Pregunta> preguntas= new ArrayList<>();
        preguntas.add(question1);
        preguntas.add(question2);
        preguntas.add(question3);
        preguntas.add(question4);
        preguntas.add(question5);


        ArrayList<Usuario> activos= new ArrayList<>();

        //Stack stack=new Stack(usuarios,preguntas,activos);

        this.usuarios=usuarios;
        this.preguntas=preguntas;
        this.activos=activos;
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
            System.out.println("===========================================================");
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