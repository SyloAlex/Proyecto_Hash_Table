package classes;

public class KarpList {
    
    private KarpNode first;
    private KarpNode last;
    private int size;
    
    public KarpList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public KarpNode getFirst() {
        return first;
    }

    public void setFirst(KarpNode first) {
        this.first = first;
    }

    public KarpNode getLast() {
        return last;
    }

    public void setLast(KarpNode last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public KarpNode getNode(int position){
        KarpNode aux = this.first;
        for (int i = 0; i < this.size; i++){
            if (i == position){
                return aux;
            }else{
                aux = aux.getNext();
            }
        }
        return null;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public void addEmpty(KarpNode newNode){
        if (isEmpty()){
            first = newNode;
            last = newNode;
            size = size + 1;
        }
    }
    
    public void addFirst(KarpNode newNode){
        if (isEmpty()){
            this.addEmpty(newNode);
        }else{
            newNode.setNext(first);
            first = newNode;
            size = size + 1;
        }
    }
    
    public void addLast(KarpNode newNode){
        if (isEmpty()){
            this.addEmpty(newNode);
        }else{
            last.setNext(newNode);
            last = newNode;
            size = size + 1;
        }
    }
    
    public void addNode(KarpNode newNode, int position){
        if (isEmpty()){
            addEmpty(newNode);
        }else{
            if (position == 0){
                addFirst(newNode);
            }else if(position == size){
                addLast(newNode);
            }else{
                KarpNode aux = this.getNode(position - 1);
                newNode.setNext(aux.getNext());
                aux.setNext(newNode);
                size = size + 1;
            }
        }
    }
    
    public String showKarpList(){
        String result = "";
        KarpNode aux = this.first;
        for (int i = 0; i < this.size; i++){
            result += aux.getTitle() + ":" + "\n";
            result += aux.getText();
            result += "-------------------------\n";
            aux = aux.getNext();
        }
        return result;
    }
    
    public String getTitles(){
        String result = "";
        KarpNode aux = this.first;
        for (int i = 0; i < this.size; i++){
            result += aux.getTitle() + ",";
            aux = aux.getNext();
        }
        return result.substring(0, result.length() - 1);
    }
    
}
