/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package txt;

import classes.HashTable;
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
    
    public void openFile(HashTable hs, TextList tl) {
        String text = "";
        String line;
    
        try {
            JFileChooser file = new JFileChooser();

            file.showOpenDialog(file);
            File open = file.getSelectedFile();

            if (open != null) {
                FileReader files = new FileReader(open);
                BufferedReader read = new BufferedReader(files);
                
                while ((line = read.readLine()) != null){
                    if (!line.isEmpty()){
                        text += line + " ";
                    }
                }
                
                
                String title = JOptionPane.showInputDialog("Ingrese titulo del texto: ");
                
                tl.insertAtTheEnd(text.substring(0, text.length()-1), title);
                
                if (text != null){
                    text = text.replaceAll("[\\[\\](){\\.,*?!}]", "");

                    text = text.toLowerCase();
                    
                    String [] wordList = text.split(" ");
                    
                    for (int i = 0; i < wordList.length; i++){
                        hs.hashFunction(wordList[i]);
                    }  
                }
                    
            }  
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo o el archivo no tiene el formato correspondiente, por lo que se iniciara la aplicación sin informacion previa.",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        
    }
}
