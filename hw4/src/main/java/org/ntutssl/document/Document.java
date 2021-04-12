package org.ntutssl.document;

import java.util.Iterator;

public interface Document {    
  public default void add(Document document) throws DocumentException {
    throw new DocumentException("Document Exception : invalid usage of add().");
  }

  public default Document getContent(int index) throws DocumentException {
      throw new DocumentException("Document Exception : invalid usage of getContent().");
  }

  public default int getLevel() throws DocumentException {
      throw new DocumentException("Document Exception : invalid usage of getLevel().");
  }
  
  public default Iterator<Document> iterator() {
    return new NullIterator();
  }
  
  public default int getSize() throws DocumentException {
    throw new DocumentException("Document Exception : invalid usage of getSize().");
  }

  public String getText();

  public void accept(Visitor visitor);

  public String toString();
}
