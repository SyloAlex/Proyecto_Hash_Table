package classes;

public class HashTable {
    
    private int size;
    private HashNode table[];
    
    public HashTable(int size){
        this.size = size;
        this.table = new HashNode[this.size];
        for (int i = 0; i < this.size; i++){
            this.table[i] = null;
        }
    }
    
    public void emptyTable(){
        for (int i = 0; i < this.size; i++){
            this.table[i] = null;
        }
    }
    
    public void printTable(){
        for (int i = 0; i < this.size; i++){
            HashNode aux = this.table[i];
            if (aux != null){
                System.out.println("Position: " + i + "\n" + 
                        "------------------");
                while (aux != null){
                    System.out.println("Word: " + aux.getWord() + 
                            ". Count: " + aux.getCount());
                    aux = aux.getNext();
                }
                System.out.println(">>>>>>>>>>>>>>>>>>>");
            }
        }
    }
    
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
