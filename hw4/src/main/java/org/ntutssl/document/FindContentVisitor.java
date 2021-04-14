package org.ntutssl.document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FindContentVisitor implements Visitor {  
  private String target;
  private String searching;
  private List<Document> result = new ArrayList<>();
  public FindContentVisitor(String target) {
    this.target = target.replaceAll("\\s+", "").toLowerCase(); 
  }

  public void visitParagraph(Paragraph paragraph) {
    searching = paragraph.getText().replaceAll("\\s+", "").toLowerCase();

    if(searching.contains(target)) {
      if(!target.isEmpty()) {
        result.add(paragraph);
      }
    }

    if(searching.isEmpty() && target.isEmpty()) {
        result.add(paragraph);
    }
    

  }

  public void visitTitle(Title title) {
    searching = title.getText().replaceAll("\\s+", "").toLowerCase();

    if(searching.contains(target)) {
      if(!target.isEmpty()) {
        result.add(title);
      }
    }

    if(searching.isEmpty() && target.isEmpty()) {
        result.add(title);
    }
    
  }

  public void visitArticle(Article article) {
    Iterator<Document> it = article.iterator();
    searching = article.getText().replaceAll("\\s+", "").toLowerCase();

    if(searching.contains(target)) {
      if(!target.isEmpty()) {
        result.add(article);
      }
    }

    if(searching.isEmpty() && target.isEmpty()) {
        result.add(article);
    }
    
    //
    while(it.hasNext()) {
      Document temp = it.next();
      //FindContentVisitor fcv = new FindContentVisitor(target);
      
      temp.accept(this);
//       List<Document> fcvResult = fcv.getResult();

//       for(Document d : fcvResult) {
//         result.add(d);
//       }
    }
  }
  
  public List<Document> getResult() {
    return result;
  }
}
