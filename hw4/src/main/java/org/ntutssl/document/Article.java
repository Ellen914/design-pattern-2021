package org.ntutssl.document;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Article implements Document {
  private String topic;
  private int level;
  private List<Document> document;
  
  public Article(String topic, int level) {
    this.topic = topic;
    this.level = level;
    this.document = new ArrayList<>();
  }

  public String getText() {
    return this.topic;
  }

  @Override
  public int getLevel() {
    return this.level;
  }
  
  @Override
  public void add(Document document) {
    Boolean flag = false;
    
    try {
      if(document.getLevel() <= level) {
        flag = true;
      } else {
        this.document.add(document);
      }
    } catch(DocumentException e){
      this.document.add(document);
    }

    if(flag) {
      throw new DocumentException("can't add lower level Article.");
    };
    
  }

  @Override
  public Iterator<Document> iterator() {
    return document.iterator();
    
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitArticle(this);// 
  }

  @Override
  public String toString() {
    return "Article" + "\t\t" + "topic: " + this.topic + "\n" + "\t\t" + "level: " + this.level + "\n";
  }
}
