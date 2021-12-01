package textList;

/**
 * Calse TextList en la cual se almacenan nodos TextNode con los archivos 
 * cargados por el usuario.
 */
public class TextList {
    TextNode first;
    TextNode last;
    public int length;
    
    /**
     * Constructor de la clase TextList sin parámetros
     */
    public TextList(){
        first = null;
        last = null;
        length = 0;
    }
    
    /**
     * Funcion que verifica si la lista está vacía
     * @return (boolean) true si la lista esta vacía, de lo contrario false
     */
    public boolean isVoid() {
        if (first == null) {
            return true;
        }
        return false;
    }
    
    /**
     * Método que inserta un nodo al final de la lista
     * @param text (String) texto cargado por el usuario
     * @param title (String) titulo otorgado por el usuario
     */
    public void insertAtTheEnd(String text ,String title){

        TextNode newNode = new TextNode();
        newNode.title = title;
        newNode.text = text;
        if (first == null){
            first = newNode;
            first.next = null;
            last = first;
        } else {
            last.next = newNode;
            last = newNode;
            last.next = null;
        }
        length ++;

    }
    
    /**
     * Función que recorre la lista mientras lamacena en un String los titulos 
     * de cada nodo
     * @return str (String) con los titulos de cada nodo.
     */
    public String getTitles(){
        TextNode aux = this.first;
        
        String titleList = "";
        
        while(aux != null){
            if (aux.next != null){
                titleList += aux.title + ",";
                aux = aux.next;   
            } else{
                titleList += aux.title;
                aux = aux.next;
            }
        }   
        return titleList;
    }
    
    /**
     * Función que recorre la lista buscando el nodo con el título igual al 
     * valor pasado por parámetro
     * @param title (String) título a buscar en la lista
     * @return (TextNode) nodo con el título pasado por parámetro, o null si 
     * no lo encuentra.
     */
    public TextNode search(String title){
        TextNode aux = this.first;
        while(aux != null){
            if (aux.title.equals(title)){
                 return aux;
            } else {
                aux = aux.next;
            }
        }
        return null;
    }
}
