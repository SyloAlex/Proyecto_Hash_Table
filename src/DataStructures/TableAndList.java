
package DataStructures;

import textList.TextList;

/**
 * Clase que almacena la Hash Table, Lista top5 y Lista karpList para poder 
 * retornar todos los objetos en una sola función
 */
public class TableAndList {

    private HashTable table;
    private Top5List top5;
    private TextList karpList;

    /**
     * Constructor de la clase TableAndList con parámetros Hash Table y 
     * ambas listas.
     * @param table (Hash Table) Hash Table que contiene todas las palabras y 
     * repeticiones de los textos.
     * @param top5 (Top5List) lista que contiene las 5 palabras más repetidas 
     * en los textos.
     * @param karpList (TextList) lista que contiene todos los textos cargados 
     * por el usuario.
     */
    public TableAndList(HashTable table, Top5List top5,
            TextList karpList) {
        this.table = table;
        this.top5 = top5;
        this.karpList = karpList;
    }

    /**
     * Getter de la Hash Table
     * @return table (Hash Table) 
     */
    public HashTable getTable() {
        return table;
    }

    /**
     * Setter de la Hash Table
     * @param table
     */
    public void setTable(HashTable table) {
        this.table = table;
    }

    /**
     * Getter de la Lista top5
     * @return top5 (Top5List)
     */
    public Top5List getTop5() {
        return top5;
    }

    /**
     * Setter de la Lista top5
     * @param top5 (Top5List)
     */
    public void setTop5(Top5List top5) {
        this.top5 = top5;
    }

    /**
     * Getter de la Lista karpList
     * @return karpList (TextList)
     */
    public TextList getKarpList() {
        return karpList;
    }

    /**
     * Setter de la Lista karpList
     * @param karpList (TextList)
     */
    public void setKarpList(TextList karpList) {
        this.karpList = karpList;
    }

}
