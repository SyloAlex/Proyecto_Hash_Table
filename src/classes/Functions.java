package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Functions {
    
    public Functions(){
    }
    
    public class TableAndList {
        
        private HashTable table;
        private SimpleList top5;
        
        public TableAndList(HashTable table, SimpleList top5){
            this.table = table;
            this.top5 = top5;
        }

        public HashTable getTable() {
            return table;
        }

        public void setTable(HashTable table) {
            this.table = table;
        }

        public SimpleList getTop5() {
            return top5;
        }

        public void setTop5(SimpleList top5) {
            this.top5 = top5;
        }
        
    }
    
    public TableAndList readTXT(String TXTpath, HashTable hs, SimpleList top5){
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
                        HashNode node = hs.hashFunction(word);
                        top5.addOrdered(node);
                    }
                }
            }
            TableAndList tl = new TableAndList(hs, top5);
            return tl;
        }catch (Exception e){
            return null;
        }
    }
    
//    public SimpleList sortList(SimpleList top5, int size){
//        SimpleList newTop5 = new SimpleList();
//        for (int i = 0; i < size; i++){
//            HashNode test = null;
//            HashNode aux = top5.getFirst();
//            for (int j = 0; j < top5.getSize(); j++){
//                if (test == null){
//                    
//                }
//            }
//        }
//    }
    
}
