package org.ntutssl.document;

public class Title implements Document {
  private String text;
  private int size;
  public Title(String text, int size) {
    this.text = text;
    this.size = size;
  }

  public String getText() {
    return this.text;
  }

  public int getSize() {
    return this.size;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitTitle(this);
  }

  @Override
  public String toString() {
    return "Title" + "\t\t" + "text: " + this.text + "\n" + "\t\t" + "size: " + this.size + "\n";
  }
}