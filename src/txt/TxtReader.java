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

/**
 *
 * @author luism
 */
public class TxtReader {
    
    public void openFile(HashTable hs) {
        String aux = "";
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
                        aux += line + " ";
                    }
                }
                System.out.println(aux);
                
                if (aux != null){
                    aux = aux.replaceAll(",", "");
                    aux = aux.replaceAll("\\.", "");
                    aux = aux.replaceAll (" \\) ", "");
                    aux = aux.replaceAll (" \\( ", "");
                    aux = aux.replaceAll (" \\[ ", "");
                    aux = aux.replaceAll (" \\] ", "");
                    aux = aux.replaceAll (" \\{ ", "");
                    aux = aux.replaceAll (" \\} ", "");
                    aux = aux.replaceAll (" \\! ", "");
                    aux = aux.replaceAll (" \\* ", "");
                    aux = aux.replaceAll (" \\? ", "");
                    aux = aux.toLowerCase();
                    
                    String [] wordList = aux.split(" ");
                    
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
