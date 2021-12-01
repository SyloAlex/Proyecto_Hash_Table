package TxtReader;

import DataStructures.HashNode;
import DataStructures.HashTable;
import DataStructures.TableAndList;
import DataStructures.Top5List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import textList.TextList;

/**
 * Clase que lee archivos .txt y los convierte en Hash Table, Top5List y 
 * TextList. La Hash Table contiene todas las palabras y su cantidad de 
 * repeticiones, la Top5List contiene las 5 palabras con más repeticiones del 
 * texto y la TextList contiene los textos completos cargados por el usuario.
 */
public class TxtReader {
    
    /**
     * Constructor de la clase TextReader con parámetros Hash Table, TextList, 
     * Top5List y txtPath.
     * @param txtPath (String) ruta al archivo .txt que se desea cargar
     * @param hashTable (Hash Table) donde se almacenan las palabras
     * @param textList (TextList) lista con los textos cargados por el usuario
     * @param top5 (Top5List) lista con las 5 palabras con más repeticiones
     * @return tableAndList (TableAndList) objeto que almacena la HashTable y 
     * las 2 listas, retorna null si no se pudo leer el archivo txt.
     */
    public TableAndList openFile(String txtPath, HashTable hashTable, TextList textList, Top5List top5) {
        String text = "";
        String line;
        File file = new File(txtPath);
        try {
            if (file.exists()) {
                FileReader files = new FileReader(file);
                BufferedReader read = new BufferedReader(files);
                
                while ((line = read.readLine()) != null){
                    if (!line.isEmpty()){
                        text += line + " ";
                    }
                }
                
                
                String title = JOptionPane.showInputDialog("Ingrese titulo del texto: ");
                
                textList.insertAtTheEnd(text.substring(0, text.length()-1), title);
                
                if (text != null){
                    text = text.replaceAll("[\\[\\](){\\.,*?!}]", "");

                    text = text.toLowerCase();
                    
                    String [] wordList = text.split(" ");
                    
                    for (int i = 0; i < wordList.length; i++){
                        HashNode node = hashTable.hashFunction(wordList[i]);
                        top5.addOrdered(node);
                    }  
                }
                    
            }
            top5.sortMaxMin();
            TableAndList tableAndList = new TableAndList(hashTable, top5, textList);
            return tableAndList;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo o el archivo no tiene el formato correspondiente, por lo que se iniciara la aplicación sin informacion previa.",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
}
