package DataStructures;

/**
 * Lista simplemente enlazada con las 5 palabras con mayor número de 
 * repeticiones en los textos cargados por el usuario
 */
public class Top5List {
    
    private HashNode first;
    private HashNode last;
    private int size;
    private int max;
    
    /**
     * Constructor de la clase Top5List sin parámetros.
     */
    public Top5List(){
        this.first = null;
        this.last = null;
        this.size = 0;
        this.max = 5;
    }

    /**
     * Getter del primer nodo de la lista
     * @return first (HashNode)
     */
    public HashNode getFirst() {
        return this.first;
    }

    /**
     * Setter del primer nodo de la lista
     * @param first (HashNode)
     */
    public void setFirst(HashNode first) {
        this.first = first;
    }

    /**
     * Getter del último nodo de la lista
     * @return last (HashNode)
     */
    public HashNode getLast() {
        return this.last;
    }

    /**
     * Setter del último nodo de la lista
     * @param last (HashNode)
     */
    public void setLast(HashNode last) {
        this.last = last;
    }
    
    /**
     * Getter del tamaño de la lista
     * @return size (int)
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Setter del tamaño de la lista
     * @param size (int)
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Getter del tamaño máximo que puede tener la lista (5 nodos)
     * @return max (int) = 5
     */
    public int getMax() {
        return this.max;
    }
    
    /**
     * Función que revisa si la lista está vacía
     * @return (boolean) true si esta vacía, de lo contrario false
     */
    public boolean isEmpty(){
        return first == null;
    }
    
    /**
     * Función que busca el nodo en la posición pasada por parámetro
     * @param position (int) posición donde se desea buscar el nodo.
     * @return (HashNode) si encuentra el nodo retorna aux, de lo contrario null
     */
    public HashNode getNode(int position){
        HashNode aux = this.first;
        for (int i = 0; i < this.size; i++){
            if (i == position){
                return aux;
            }else{
                aux = aux.getNextList();
            }
        }
        return null;
    }
    
    /**
     * Función que revisa si la palabra pasada por parámetro se encuentra en 
     * la lista
     * @param word (String) palabra a buscar
     * @return flag (boolean) false si no la consigue y true si la consigue
     */
    public boolean checkWord(String word){
        boolean flag = false;
        HashNode aux = this.first;
        for (int i = 0; i < this.size; i++){
            if (aux.getWord().equals(word)){
                flag = true;
                break;
            }else{
                aux = aux.getNextList();
            }
        }
        return flag;
    }
    
    /**
     * Método para cambiar de posición el primer nodo con un nodo con más 
     * repeticiones
     * @param aux (HashNode) nodo con más repeticiones
     * @param position (int) posición en la que se encuentra el nodo
     */
    public void changePositions(HashNode aux, int position){
        if (position == this.size - 1){
            HashNode proxy = this.getNode(position - 1);
            this.last.setNextList(this.first);
            this.setFirst(this.last);
            this.setLast(proxy);
        }else if (position > 0 && position < this.size - 1){
            HashNode proxy = this.getNode(position - 1);
            HashNode temp = new HashNode();
            temp.setNextList(aux.getNextList());
            aux.setNextList(this.first);
            this.setFirst(aux);
            proxy.setNextList(temp.getNextList());
            temp = null;
        }
    }
    
    /**
     * Método que añade un nodo a la lista vacía.
     * @param newNode (HashNode)
     */
    public void addEmpty(HashNode newNode){
        if (isEmpty()){
            first = newNode;
            last = newNode;
            size = size + 1;
        }
    }
    
    /**
     * Método que añade un nodo de primero en la lista.
     * @param newNode (HashNode)
     */
    public void addFirst(HashNode newNode){
        if (isEmpty()){
            this.addEmpty(newNode);
        }else{
            newNode.setNextList(first);
            first = newNode;
            size = size + 1;
        }
    }
    
    /**
     * Método que añade un nodo de último en la lista.
     * @param newNode (HashNode)
     */
    public void addLast(HashNode newNode){
        if (isEmpty()){
            this.addEmpty(newNode);
        }else{
            last.setNextList(newNode);
            last = newNode;
            size = size + 1;
        }
    }
    
    /**
     * Método que añade un nodo en la posición pasada por parámetro
     * @param newNode (HashNode)
     * @param position (int) posición en la que se desea añadir el nodo
     */
    public void addNode(HashNode newNode, int position){
        if (isEmpty()){
            addEmpty(newNode);
        }else{
            if (position == 0){
                addFirst(newNode);
            }else if(position == size){
                addLast(newNode);
            }else{
                HashNode aux = this.getNode(position - 1);
                newNode.setNextList(aux.getNextList());
                aux.setNextList(newNode);
                size = size + 1;
            }
        }
    }
    
    /**
     * Método para añadir un nodo de forma ordenada a la lista. Si el nodo 
     * tiene más repeticiones que el primero, lo coloca de primero, si el nodo 
     * no existe y tiene menos repeticiones, no lo añade.
     * @param newNode (HashNode)
     */
    public void addOrdered(HashNode newNode){
        HashNode aux = first;
        boolean flag = false;
        if (isEmpty()){
            addFirst(newNode);
        }else{
            if (this.checkWord(newNode.getWord())){
                for (int i = 0; i < this.size; i++){
                    if (aux.getWord().equals(newNode.getWord())){
                        this.changePositions(aux, i);
                        break;
                    }else{
                        aux = aux.getNextList();
                    }
                }
            }else{
                for (int i = 0; i < size; i++){
                    if (aux.getCount() < newNode.getCount()){
                        addNode(newNode, i);
                        if (this.size >= this.max){
                            this.deleteLast();
                        }
                        flag = true;
                        break;
                    }else{
                        aux = aux.getNextList();
                    }
                }
                if (!flag && this.size < this.max){
                    addLast(newNode);
                }
            }
        }
    }
    
    /**
     * Método que elimina el último nodo de la lista
     */
    public void deleteLast(){
        if (isEmpty()){
        }else{
            last = getNode(size - 2);
            last.setNextList(null);
            size = size - 1;           
        }
    }
    
    /**
     * Función que recorre todos los nodos de la lista y almacena en un string 
     * las palabras y repeticiones de cada nodo.
     * @return top5 (String) con todas las palabras y cantidad de repeticiones 
     * de cada una.
     */
    public String showList(){
        String top5 = "";
        HashNode aux = this.first;
        for (int i = 0; i < this.getSize(); i++){
            top5 += "Word: " + aux.getWord() + 
                    ". Count: " + aux.getCount() + "\n";
            aux = aux.getNextList();
        }
        
        return top5;
    }
    
    /**
     * Función que revisa si la lista está ordenada de mayor a menor según la 
     * cantidad de repeticiones
     * @return flag (boolean) true si está ordenada, de lo contrario false.
     */
    public boolean checkOrder(){
        boolean flag = true;
        HashNode aux = this.first;
        for (int i = 0; i < this.size - 1; i++){
            if (aux.getCount() < aux.getNextList().getCount()){
                flag = false;
                break;
            }else{
                aux = aux.getNextList();
            }
        }
        
        return flag;
    }
    
    /**
     * Método que ordena los nodos de la lista de mayor a menor, según la 
     * cantidad de repeticiones almacenada en el nodo
     */
    public void sortMaxMin(){
        if (size > 1) {
        boolean change;
        do {
            HashNode actual = first;
            HashNode last = null;
            HashNode next = first.getNextList();
            change = false;
            for (int i = 0; i < this.getSize() - 1; i++){
                if (actual.getCount() < next.getCount()) {
                    change = true;
                    if ( last != null ) {
                        HashNode aux = next.getNextList();
                        last.setNextList(next);
                        next.setNextList(actual);
                        actual.setNextList(aux);
                    } else {
                        HashNode aux = next.getNextList();
                        first = next;
                        next.setNextList(actual);
                        actual.setNextList(aux);
                    }
                    last = next;
                    next = actual.getNextList();
                } else { 
                    last = actual;
                    actual = next;
                    next = next.getNextList();
                }
            } 
        } while(change);
    }
}
    
}
