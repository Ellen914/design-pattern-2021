package org.ntutssl.document;

import java.util.Iterator;

public class HtmlOutputVisitor implements Visitor<String> {
  private String result;
  public HtmlOutputVisitor() {
    this.result = new String();
  }

  public void visitParagraph(Paragraph paragraph) {
    this.result += "<p>" + paragraph.getText() + "</p>\n";
  }

  public void visitTitle(Title title) {
    this.result += "<h" + title.getSize() + ">" + title.getText() + "</h" + title.getSize() + ">\n";
  }

  public void visitArticle(Article article) {
    Iterator<Document> it = article.iterator();

    this.result += "<article topic=\'" + article.getText() + "\'>\n";

    while(it.hasNext()){
      Document temp = it.next();
      //HtmlOutputVisitor visitor = new HtmlOutputVisitor();
      temp.accept(this);

//       for(int i = 0 ; i < article.getLevel() ; i++){
//         this.result += "  ";
//       }
      
//       this.result += visitor.getResult();
    }

    for(int i = 1 ; i < article.getLevel() ; i++){
      this.result += "  ";
    }
    this.result += "</article>\n";
  }

  public String getResult() {
    return this.result;
  }
}
