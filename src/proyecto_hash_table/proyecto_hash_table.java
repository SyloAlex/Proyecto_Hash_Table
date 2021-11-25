package proyecto_hash_table;

import txt.TxtReader;
import classes.HashTable;
import classes.Functions;

public class proyecto_hash_table {

    public static void main(String[] args) {
        Functions f = new Functions();
        HashTable hs = f.readTXT("test\\test.txt");
        hs.printTable();
        
//        HashTable hs = new HashTable(10007);
//        hs.hashFunction("Hola");
//        hs.hashFunction("Hola");
//        hs.hashFunction("Como");
//        hs.hashFunction("Estas");
//        hs.hashFunction("Hello");
//        hs.hashFunction("Jose");
//        hs.hashFunction("Maria");
//        hs.hashFunction("Test");
//        hs.hashFunction("Hola");
//        hs.hashFunction("Como");
//        hs.printTable();
        
    }
    
}
