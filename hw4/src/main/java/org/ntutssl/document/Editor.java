package org.ntutssl.document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Editor {  
  private List<Document> document;

  public Editor() {
    this.document = new ArrayList<>();  
  }

  public void add(Document document) {
    this.document.add(document);
  }

  public int size() {
    return this.document.size();
  }

  public Iterator<Document> iterator() {
    return this.document.iterator();
  }
}
