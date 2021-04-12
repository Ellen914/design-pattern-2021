package org.ntutssl.document;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class ArticleTest { 

    @Test
    public void addArticleTest() {
        Document article1 = new Article("Chapter 1 : Be Happy", 1);
        Document title1 = new Title("Title : What is happiness", 5);
        Document paragraph1 = new Paragraph("Happiness is the most important thing in your life.");
        Document article2 = new Article("Chapter 2 : Be Positive", 2);
        Document title2 = new Title("Title : Keep being positive", 5);
        Document paragraph2 = new Paragraph("The hardest but most important thing.");

        article1.add(title1);
        article1.add(paragraph1);
        article2.add(title2);
        article2.add(paragraph2);
        article1.add(article2);

        Iterator<Document> it1 = article1.iterator();
        Iterator<Document> it2 = article2.iterator();

        assertTrue(it1.hasNext());
        assertEquals("Title : What is happiness", it1.next().getText());
        
        assertTrue(it1.hasNext());
        assertEquals("Happiness is the most important thing in your life.", it1.next().getText());

        assertTrue(it1.hasNext());
        assertEquals("Chapter 2 : Be Positive", it1.next().getText());

        assertTrue(it2.hasNext());
        assertEquals("Title : Keep being positive", it2.next().getText());
        
        assertTrue(it2.hasNext());
        assertEquals("The hardest but most important thing.", it2.next().getText());
    }

    @Test
    public void getTextSucess() {
        Document article = new Article("Chapter 2 : Don't Worry", 2);
        assertEquals(article.getText(),"Chapter 2 : Don't Worry");
    }

    @Test
    public void getLevelSuccess(){
        Document article = new Article("Chapter 3 : That's OK", 3);
        assertTrue(article.getLevel() == 3);
    }

    @Test
    public void addHigherLevelArticleSuccess(){
        Document article1 = new Article("Chapter 1 : Be Happy ", 1);
        Document title1 = new Title("Title : What is happiness ", 5);
        article1.add(title1);
        Document article2 = new Article("Chapter 2 : Don't Worry", 2);
        Document title2 = new Title("Title : Be Positive", 5);
        article2.add(title2);
        article1.add(article2);
        assertEquals(article1.getText(), "Chapter 1 : Be Happy ");
    }

    @Test(expected = DocumentException.class)
    public void addLowerLevelArticleToArticleFail(){
        Document article3 = new Article("Chapter 3 : That's OK", 3);
        article3.add(new Title("Title : You're Good Enough ", 5));
        Document article2 = new Article("Chapter 2 : Don't Worry", 2);
        article2.add(new Title("Title : Be Positive", 5));
        article3.add(article2);
        assertEquals(article3.getText(), "Chapter 3 : That's OK");
    }

    @Test
    public void toStringSuccess() {
        Document article = new Article("Chapter 1 : Be Happy", 1);
        String expected = "Article\t\ttopic: Chapter 1 : Be Happy" + "\n" +
                          "\t\tlevel: 1" + "\n";
        assertEquals(expected, article.toString());
    }

 }
