package classes;

public class KarpNode {
    
    private String text;
    private String title;
    private KarpNode next;
    
    public KarpNode(String text){
        this.text = text;
        this.title = "";
        this.next = null;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public KarpNode getNext() {
        return next;
    }

    public void setNext(KarpNode next) {
        this.next = next;
    }
    
    
}
