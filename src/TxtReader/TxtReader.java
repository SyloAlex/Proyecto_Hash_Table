/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TxtReader;

import HashTable.HashNode;
import HashTable.HashTable;
import HashTable.TableAndList;
import HashTable.Top5List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import textList.TextList;

/**
 *
 * @author luism
 */
public class TxtReader {
    
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
