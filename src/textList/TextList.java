/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textList;

/**
 *
 * @author luism
 */
public class TextList {
    TextNode first;
    TextNode last;
    public int length;
    
    public TextList(){
        first = null;
        last = null;
        length = 0;
    }
    
    public boolean isVoid() {
        if (first == null) {
            return true;
        }
        return false;
    }
    
    public void insertAtTheEnd(String text ,String title){

        TextNode newNode = new TextNode();
        newNode.title = title;
        newNode.text = text;
        if (first == null){
            first = newNode;
            first.next = null;
            last = first;
        } else {
            last.next = newNode;
            last = newNode;
            last.next = null;
        }
        length ++;

    }
    
    public String viewList(){
        TextNode aux = this.first;
        String str = "";
        while(aux != null){
            str += aux.title + ",";
            aux = aux.next;   
        }
        return str;
    }
    
    public String getTitles(){
        TextNode aux = this.first;
        
        String titleList = "";
        
        while(aux != null){
            if (aux.next != null){
                titleList += aux.title + ",";
                aux = aux.next;   
            } else{
                titleList += aux.title;
                aux = aux.next;
            }
        }   
        return titleList;
    }
    
    public TextNode search(String title){
        TextNode aux = this.first;
        while(aux != null){
            if (aux.title.equals(title)){
                 return aux;
            } else {
                aux = aux.next;
            }
        }
        return null;
    }
}
