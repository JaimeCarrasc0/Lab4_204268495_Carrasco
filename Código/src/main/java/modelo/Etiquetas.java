package modelo;

import java.util.ArrayList;

/**
 * Esta clase define a las etiqeutas para las preguntas
 * @author Jaime Carrasco
 */
public class Etiquetas {
    private ArrayList<String> tags;
    private ArrayList<String> descripcion;

    /**
     * consturctor de la clase etiquetas
     * @param etiquetas arreglo con las etiquetas
     * @param desc arreglo con las descripciones de las etiquetas
     */
    public Etiquetas(ArrayList<String> etiquetas, ArrayList<String> desc){
        this.tags=etiquetas;
        this.descripcion=desc;
    }

    /**
     * Constructor con parámetros vacíos, esto define arreglos vacíos para ambos atributos
     */
    public Etiquetas(){
        this.tags=new ArrayList<>();
        this.descripcion=new ArrayList<>();
    }

    /**
     * Getter de etiquetas
     * @return etiquetas en arreglo
     */
    public ArrayList<String> getTags() {
        return tags;
    }

    /**
     * getter de las descripciones
     * @return arreglo de descirpciones
     */
    public ArrayList<String> getDescripcion() {
        return descripcion;
    }

    /**
     * añadir tags al objeto que instancia la clase
     * @param etiqueta string con la etiqueta nueva
     * @param descripcion string con la descripcion de la etiqueta nueva
     */
    public void anadirTags(String etiqueta, String descripcion){
        this.tags.add(etiqueta);
        this.descripcion.add(descripcion);
    }

    /**
     * imprime los tags que existen en el objeto que instanci la clase
     */
    public void imprimirTags(){
        int i;
        System.out.println("Etiquetas:\n");
        for(i=0;i<tags.size();i++){
            System.out.println("("+(i+1)+")"+tags.get(i)+": "+descripcion.get(i));
        }
    }
}
