public class DocumentExcception extends RuntimeException {
   
    public DocumentExcception(String errorMessage) {
        super(errorMessage);
    }


}

import java.util.Iterator;

public interface DPFormat {
    //建立一個Interface 讓leaf 跟composite (class)可以implents
    public String getText();
    public default Iterator<DPFormat> iterator() {
        return new NullIterator();
    }

    public default int getLevel() {
        throw new DocumentExcception();
    }

    
    public default void add(DPFormat t) {
        throw new DocumentExcception();
    }

    //讓accept出現在 interface這層!!!! 這樣composite跟leaf都只要override
    public void accept(WriteVisitor wv);


}


public class NullIterator implements Iterator<DPFormat> {
    //NullIterator 需要implements的是指標!! Iteratoe<(大家implements的interface)>
    public boolean hasNext() {
        return false;
    }

    public DPFormat next() {
        return new NoSuchElementException();
    }
}

//'作為Leaf'
public class Text implements DPFormat {
    private String text;

    //先有建構子
    public Text(String text) {
        this.text = text;
    }

    //回傳
    public String getText() {
        return this.text;
    }

    //Visitor pattern : 需要一個accept 去叫Visitor來幫忙
    public void accept (WriteVisitor wv) {
        wv.visitText(this);
        //不需要額外宣告find...可以直接讓Visitor去call this 就好
    }
}

//作為Composite
public class Title implements DPFormat {
    private List<DPFormat> list;
    private String text;
    private int level;

    public Title(int level, String text) {
        this.list = new ArrayList<>();
        //收取要搜尋的範圍並且存在一個List裡面
        this.level = level;
        this.text = text;
    }

    //在composite宣告 iterator!!!!!
    public Iterator<DPFormat> iterator() {
        //回傳搜尋範圍的指標
        return this.list.iterator();
    }

    public int getLevel() {
        return this.level;
    }
    
    public String getText() {
        return this.text;
    }

    //不可以再回傳寫邏輯  寫個add當讀取的方式
    public void add(DPFormat item) {
        list.add(item)
    }

    //accept內容的code寫在interface
    public void accept(WriteVisitor wv){}
}


public class WriteVisitor {
    private String result;
    public WriteVisitor() {
        this.result = new String();
    }

    public void visitTitle(Title title) {
        Iterator<DPFormat> it = title.iterator();
        this.result += title.getText() + "\n";
        while(it.hasNext()){
            DPFormat temp = it.next();
            temp.accept(this);
        }
    }

    public void visitText(Text text) {
        result += text.getText() + "\n";
    }

    //切記!!! getResult只能回傳 result不可以有邏輯寫在裡面
    public String getResult() {
        return this.result;
    }
}