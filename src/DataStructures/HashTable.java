package DataStructures;

/**
 * Clase Hash Table que almacena las palabras del texto y la cantidad de veces 
 * que se repiten
 */
public class HashTable {
    
    private int size;
    private HashNode table[];
    
    /**
     * Constructor de la clase Hash Table con el tamaño como parámetro
     * @param size (int) tamaño del array de la Hash Table
     */
    public HashTable(int size){
        this.size = size;
        this.table = new HashNode[this.size];
        for (int i = 0; i < this.size; i++){
            this.table[i] = null;
        }
    }
    
    /**
     * Método para vaciar la Hash Table de todos los nodos que la contienen
     */
    public void emptyTable(){
        for (int i = 0; i < this.size; i++){
            this.table[i] = null;
        }
    }
    
    /**
     * Función para retornar un string con todas las palabras y la cantidad 
     * de repeticiones en los textos guardados
     * @return table (String) con las palabras y su cantidad de repeticiones
     */
    public String showTable(){
        String table = "";
        for (int i = 0; i < this.size; i++){
            HashNode aux = this.table[i];
            if (aux != null){
                while (aux != null){
                    table += "Word: " + aux.getWord() + 
                            ". Count: " + aux.getCount() + "\n";
                    aux = aux.getNext();
                }
            }
        }
        return table;
    }
    
    /**
     * Función para convertir una palabra en un valor entero, de forma que 
     * pueda guardarse en alguna posición de la Hash Table
     * @param word (String) palabra que se desea almacenar
     * @return (value % this.size) (int) posición en la que se va a almacenar 
     * la palabra
     */
    public int hashing(String word){
        int value = 0;
        int position = 1;
        for (int i = 0; i < word.length(); i++){
            if (word.codePointAt(i) == 32){
                value += 0;
            } else if(word.codePointAt(i) >= 48 && word.codePointAt(i) <= 57){
                value += ((word.codePointAt(i) - 47) * position);
            } else if(word.codePointAt(i) >= 65 && word.codePointAt(i) <= 90){
                value += ((word.codePointAt(i) - 54) * position);
            } else if(word.codePointAt(i) >= 97 && word.codePointAt(i) <= 122){
                value += ((word.codePointAt(i) - 60) * position);
            }
            position++;
        }
        
        return (value % this.size);
    }
    
    /**
     * Función que transforma la palabra a entero y lo guarda en la Hash Table. 
     * Si la palabra ya existe, aumenta su contador de repeticiones, sino, 
     * agrega la palabra a la Hash Table. En caso de que haya colisión en las 
     * posiciones, anexa el nodo al nodo ya existente simulando una lista
     * @param word (String) palabra a almacenar
     * @return aux (HashNode) nodo creado para anexar a la Hash Table
     */
    public HashNode hashFunction(String word){
        int position = this.hashing(word);
        boolean exist = false;
        if (this.table[position] != null){
            HashNode aux = this.table[position];
            boolean flag = false;
            while (!flag){
                if (aux.getWord().equals(word)){
                    flag = true;
                    exist = true;
                } else{
                    if (aux.getNext() != null){
                        aux = aux.getNext();
                    } else{
                        flag = true;
                    }
                }
            }
            if (!exist){
                HashNode newWord = new HashNode(word);
                aux.setNext(newWord);
            } else{
                aux.setCount(aux.getCount() + 1);
            }
            return aux;
        } else{
            HashNode newWord = new HashNode(word);
            this.table[position] = newWord;
            return newWord;
        }
    }
    
    /**
     * Función que busca en la Hash Table el nodo con la palabra del parámetro, 
     * si no la encuentra retorna null.
     * @param word (String) palabra a buscar en la Hash Table
     * @return aux (HashNode) nodo que contiene la palabra o null.
     */
    public HashNode searchWord(String word){
        int position = this.hashing(word);
        HashNode aux = this.table[position];
        boolean exist = false;
        if (aux != null){
            boolean flag = false;
            while (!flag){
                if (aux.getWord().equals(word)){
                    flag = true;
                    exist = true;
                } else{
                    if (aux.getNext() != null){
                        aux = aux.getNext();
                    } else{
                        flag = true;
                        aux = null;
                    }
                }
            }
        }
        return aux;
    }
}
