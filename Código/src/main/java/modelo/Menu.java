package modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase define al menú, este es el que representa la interacción del usuario con el programa.
 * @author Jaime Carrasco
 */
public class Menu{
    public static void main(String[] args){
        ArrayList<Respuesta> respuestas1 = new ArrayList<>();
        ArrayList<Respuesta> respuestas2 = new ArrayList<>();
        ArrayList<Respuesta> respuestas3 = new ArrayList<>();
        ArrayList<Respuesta> respuestas4 = new ArrayList<>();
        ArrayList<Respuesta> respuestas5 = new ArrayList<>();

        Usuario user1=new Usuario("Julián","Alonso",3);
        Usuario user2=new Usuario("Jaime","Alejandro",5);
        Usuario user3=new Usuario("31110t","mrRob0t",50);
        Usuario user4=new Usuario("LazarB3am","Lannan",35);

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

        Stack stack=new Stack(usuarios,preguntas,activos);
        //Stack stack=new Stack();
        Scanner input= new Scanner(System.in);
        int opcion;
        //System.out.println("Bienvenido al sistema de preguntas y respuestas\n1)Iniciar Sesión\n2)Registrarse\n3)Salir");
        //System.out.println("Ingrese su opción:");
        //opcion=input.nextInt();
        System.out.println("Bienvenido al sistema de preguntas y respuestas");

        Usuario usuario;
        String user="";
        String clave;
        Scanner userInput= new Scanner(System.in);

        int llave=1,key;
        while (llave==1) {
            key=1;
            while (key == 1) {
                System.out.println("1)Iniciar Sesión\n2)Registrarse\n3)Salir");
                System.out.println("Ingrese su opción:");
                opcion = input.nextInt();

                switch (opcion) {
                    case 1:
                        //Scanner userInput= new Scanner(System.in);
                        System.out.println("\nIngrese su nombre de usuario: ");
                        user = userInput.nextLine();
                        boolean aux = false;

                        while (!aux) {
                            if (stack.existeUsuario(user)) {
                                Scanner passInput = new Scanner(System.in);
                                System.out.println("Ingrese su contraseña: ");
                                clave = passInput.nextLine();

                                aux = stack.login(user, clave);
                                if (aux) {
                                    System.out.println("Inicio de sesión exitoso!");
                                    break;
                                } else {
                                    clave = "";
                                    System.out.println("Inicio de sesión incorrecto\n");
                                }
                            } else {
                                System.out.println("Usuario no existe, intente nuevamente\nIngrese su nombre de usuario: ");
                                user = userInput.nextLine();
                            }
                        }
                        key = 0;
                        //verificar inicio de sesión
                        break;

                    case 2:
                        //Scanner userInput= new Scanner(System.in);
                        System.out.println("\nIngrese un nombre de usuario: ");
                        user = userInput.nextLine();

                        if (stack.existeUsuario(user)) {
                            System.out.println("El nombre de usuario ya existe.\nInicie sesión o Registrese con otro nombre.");
                            break;
                        }
                        //verificar si existe usuario
                        //si no existe el usuario, crearlo


                        Scanner passInput = new Scanner(System.in);
                        System.out.println("\nIngrese su contraseña: ");
                        clave = passInput.nextLine();

                        usuario = new Usuario(user, clave, 0);

                        stack.registrarUsuario(usuario);

                        System.out.println("Usuario creado con éxito");

                        //usuario.imprimirDatos();
                        key = 0;
                        break;

                    case 3:
                        key = 0;
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Error, no existe esa opción\n");
                        break;
                }

            }


            key = 1;
            while (key == 1) {


                /*                                                                aquÃ­ â†“ deberÃ­a ir el usuario que estÃ¡ utilizando la app*/
                System.out.println("### SISTEMA DE PREGUNTAS Y RESPUESTAS ###\n## Registrado como:" + user + " ##\nEscoja su opción:\n1. Agregar nueva pregunta\n2. Responder pregunta\n3. Dar recompensa\n4. Aceptar respuesta\n5. Cerrar sesión\n6. Salir del programa\n");
                System.out.println("INTRODUZCA SU OPCIÓN: ");
                /*
                ### SISTEMA DE PREGUNTAS Y RESPUESTAS ###
                ## Registrado como: User123 ##
                Escoja su opción:
                1. Agregar nueva pregunta
                2. Responder pregunta
                3. Dar recompensa
                4. Aceptar respuesta
                5. Cerrar sesión
                6. Salir del programa
                INTRODUZCA SU OPCIÓN: _
                */
                opcion = input.nextInt();

                switch (opcion) {

                    case 1:
                        /*Agregar nueva pregunta*/
                        Scanner titleInput = new Scanner(System.in);
                        Scanner questionInput = new Scanner(System.in);
                        Scanner tagSelector = new Scanner(System.in);

                        String titulo, pregunta;
                        int ingreso = 0;
                        Etiquetas tags = new Etiquetas();


                        System.out.println("Ingrese el título de la pregunta: ");
                        titulo = titleInput.nextLine();
                        System.out.println("Ingrese su pregunta: ");
                        pregunta = questionInput.nextLine();

                        System.out.println("Seleccione al menos 1 etiqueta para su pregunta\n");
                        tagStack.imprimirTags();

                        while (ingreso != 0 || tags.getTags().size() < tagStack.getTags().size()) {
                            System.out.println("Seleccione su etiqueta\n si no desea añadir más ingrese 0");
                            ingreso = tagSelector.nextInt();
                            if (ingreso != 0) {
                                tags.anadirTags(tagStack.getTags().get(ingreso - 1), tagStack.getDescripcion().get(ingreso - 1));
                            } else {
                                break;
                            }
                        }

                        stack.ask(titulo, pregunta, tags);

                        //stack.imprimirPreguntas();

                        break;

                    case 2:
                        /*Responder pregunta*/
                        Scanner idInput = new Scanner(System.in);
                        Scanner respuestaInput = new Scanner(System.in);
                        boolean aux;
                        int idPregunta;
                        String respuesta = "";

                        stack.imprimirPreguntas();

                        do {
                            System.out.println("\nIngrese el ID de la pregunta que desea responder: ");
                            idPregunta = idInput.nextInt();

                            System.out.println("Ingrese su respuesta: ");
                            respuesta = respuestaInput.nextLine();

                            aux = stack.answer(idPregunta, respuesta);

                        } while (!aux);


                        break;

                    case 3:
                        /*Dar recompensa*/
                        if (stack.getActivos().get(stack.getActivos().size() - 1).getReputacion() > 0) {
                            Scanner idPregInput = new Scanner(System.in);
                            Scanner recomInput = new Scanner(System.in);
                            int idPreg, recom;
                            Pregunta questionAux;

                            stack.imprimirPreguntas();

                            System.out.println("Ingrese el ID de la pregunta que desea recompensar: ");
                            idPreg = idPregInput.nextInt();
                            questionAux = stack.getPreguntas().get(idPreg);

                            System.out.println("Ingrese la cantidad de puntos que desea entregar: ");
                            recom = recomInput.nextInt();

                            stack.reward(questionAux, recom);
                        } else {
                            System.out.println("No puedes ofrecer recompensas, tu reputación es demasiado baja.");
                        }
                        break;

                    case 4:
                        /*Aceptar respuesta*/
                        Scanner idPregInput = new Scanner(System.in);
                        Scanner idResInput = new Scanner(System.in);
                        int idPreg, idRes;
                        Pregunta pregAux;
                        Respuesta resAux;

                        stack.imprimirPreguntas(stack.getActivos().get(stack.getActivos().size() - 1));

                        System.out.println("Ingrese el id de la pregunta: ");
                        idPreg = idPregInput.nextInt();
                        pregAux = stack.getPreguntas().get(idPreg);

                        stack.imprimirRespuestas(pregAux);

                        System.out.println("Ingrese el id de la respuesta que desea aceptar: ");
                        idRes = idResInput.nextInt();

                        resAux = pregAux.getRespuestas().get(idRes);
                        //resAux.imprimirRespuestas();

                        stack.accept(pregAux, resAux);

                        break;

                    case 5:
                        /*Cerrar SesiÃ³n*/
                        key = 0;
                        //menu();
                        stack.logout(user);
                        break;

                    case 6:
                        /*Salir del programa*/
                        key = 0;
                        llave=0;
                        break;

                    default:
                        System.out.println("Error, no existe esa opción\n");
                        break;
                }
            }
        }
        System.exit(0);
    }
}
