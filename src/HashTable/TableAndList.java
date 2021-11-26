/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable;

import textList.TextList;

/**
 *
 * @author luism
 */
public class TableAndList {

    private HashTable table;
    private Top5List top5;
    private TextList karpList;

    public TableAndList(HashTable table, Top5List top5,
            TextList karpList) {
        this.table = table;
        this.top5 = top5;
        this.karpList = karpList;
    }

    public HashTable getTable() {
        return table;
    }

    public void setTable(HashTable table) {
        this.table = table;
    }

    public Top5List getTop5() {
        return top5;
    }

    public void setTop5(Top5List top5) {
        this.top5 = top5;
    }

    public TextList getKarpList() {
        return karpList;
    }

    public void setKarpList(TextList karpList) {
        this.karpList = karpList;
    }

}
