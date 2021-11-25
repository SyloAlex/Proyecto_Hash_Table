package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Functions {
    
    public Functions(){
    }
    
    public HashTable readTXT(String TXTpath){
        HashTable hs = new HashTable(10007);
        String txt = "";
        String line;
        File file = new File(TXTpath);
        try{
            if (file.exists()){
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null){
                    if (!line.isEmpty()){
                        txt += line + "\n";
                    }
                }
                String[] txtInfo = txt.split("\n");
                for (int i = 0; i < txtInfo.length; i++){
                    String[] txtWords = txtInfo[i].split(" ");
                    for (int j = 0; j < txtWords.length; j++){
                        String word = txtWords[j];
                        for (int k = 0; k < word.length(); k++){
                            if (!Character.isAlphabetic(word.charAt(k)) && !Character.isDigit(word.charAt(k))){
                                char test = word.charAt(k);
                                word = word.replace(String.valueOf(word.charAt(k)), "");
                            }
                        }
                        word = word.toLowerCase();
                        hs.hashFunction(word);
                    }
                }
            }
            return hs;
        }catch (Exception e){
            return null;
        }
    }
    
}
