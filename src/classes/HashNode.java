package classes;

public class HashNode {
    
    private HashNode next;
    private HashNode nextList;
    private String word;
    private int count;
    
    public HashNode(){
        this.next = null;
        this.nextList = null;
        this.word = "";
        this.count = 0;
    }
    
    public HashNode(String word){
        this.next = null;
        this.nextList = null;
        this.word = word;
        this.count = 1;
    }
    
    public HashNode(String word, int count){
        this.next = null;
        this.nextList = null;
        this.word = word;
        this.count = count;
    }

    public HashNode getNext() {
        return next;
    }

    public void setNext(HashNode next) {
        this.next = next;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public HashNode getNextList() {
        return nextList;
    }

    public void setNextList(HashNode nextList) {
        this.nextList = nextList;
    }
    
}
