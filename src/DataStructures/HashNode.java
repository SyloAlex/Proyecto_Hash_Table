package DataStructures;

/**
 * Nodo de la Hash Table y de la Lista top5.
 */
public class HashNode {
    
    private HashNode next;
    private HashNode nextList;
    private String word;
    private int count;
    
    /**
     * Constructor de la clase sin parámetros
     */
    public HashNode(){
        this.next = null;
        this.nextList = null;
        this.word = "";
        this.count = 0;
    }
    
    /**
     * Constructor de la clase con la palabra como parámetro
     * @param word¨(String) palabra a almacenar en la Hash Table
     */
    public HashNode(String word){
        this.next = null;
        this.nextList = null;
        this.word = word;
        this.count = 1;
    }
    
    /**
     * Constructor de la clase con la palabra y la cantidad de veces que 
     * se repite como parámetro
     * @param word (String) palabra a almacenar en la Hash Table
     * @param count (int) cantidad de repeticiones
     */
    public HashNode(String word, int count){
        this.next = null;
        this.nextList = null;
        this.word = word;
        this.count = count;
    }

    /**
     * Getter del siguiente nodo en la Hash Table
     * @return next (HashNode) siguiente nodo en la Hash Table
     */
    public HashNode getNext() {
        return next;
    }

    /**
     * Setter del siguiente nodo en la Hash Table
     * @param next (HashNode) siguiente nodo en la Hash Table
     */
    public void setNext(HashNode next) {
        this.next = next;
    }

    /**
     * Getter de la palabra almacenada en el nodo
     * @return word (String) palabra almacenada en el nodo
     */
    public String getWord() {
        return word;
    }

    /**
     * Setter de la palabra almacenada en el nodo
     * @param word (String) palabra almacenada en el nodo
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Getter de la cantidad de veces que se repite la palabra en el texto
     * @return count (int) cantidad de repeticiones
     */
    public int getCount() {
        return count;
    }

    /**
     * Setter de la cantidad de veces que se repite la palabra en el texto
     * @param count (int) cantidad de repeticiones
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Getter del siguiente nodo en la Lista top5
     * @return nextList (HashNode) siguiente nodo en la Lista
     */
    public HashNode getNextList() {
        return nextList;
    }

    /**
     * Setter del siguiente nodo en la Lista top5
     * @param nextList (HashNode) siguiente nodo en la Lista
     */
    public void setNextList(HashNode nextList) {
        this.nextList = nextList;
    }
    
}
