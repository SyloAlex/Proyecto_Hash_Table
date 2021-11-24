/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package txt;

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
    public String [] wordList;
    public String originalText;
    
    public void openFile() {
        String aux = "";
    
        try {
            JFileChooser file = new JFileChooser();

            file.showOpenDialog(file);
            File open = file.getSelectedFile();

            if (open != null) {
                FileReader files = new FileReader(open);
                BufferedReader read = new BufferedReader(files);
                aux = read.readLine();
                System.out.println(aux);
                
                if (aux != null){
                    originalText = aux;
                    aux = aux.replaceAll(",", "");
                    aux = aux.replaceAll("\\.", "");
                    aux = aux.toLowerCase();
                    
                    wordList = aux.split(" ");
                }
                
                
                
                
                 
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo o el archivo no tiene el formato correspondiente, por lo que se iniciara la aplicación sin informacion previa.",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        
    }
}
