package org.ntutssl.document;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ArticleTest { 

    @Test
    public void addSucess() {
        Document article = new Article("Chapter 1 : Be Happy", 1);
        article.add(new Title("Title : What is happiness"));
        assertEquals("Chapter 1 : Be Happy", article.getText());
    }

    @Test
    public void getTextSucess() {
        Document article = new Article("Chapter 2 : Don't Worry", 2);
        assertEquals(article.getText(),"Chapter 2 : Don't Worry");
    }

    @Test
    public void getTextWithManyDocumentsSucess() {
        Document article = new Article("Chapter 3 : That's OK", 3);
        article.add(new Title("Title 1 and "));
        article.add(new Title("Title 2"));
        assertEquals(article.getText(),"Chapter 3 : That's OK");
    }

    @Test
    public void getContentSucess() {
        Document article = new Article("Chapter 1 : Be Happy", 1);
        Document title = new Title("Title : What is happiness");
        article.add(title);
        assertEquals(article.getContent(0),title);
    }

    @Test
    public void getLevelSuccess(){
        Document article = new Article("Chapter 3 : That's OK", 3);
        assertTrue(article.getLevel() == 3);
    }

    @Test
    public void addHigherLevelArticleSuccess(){
        Document article1 = new Article("Chapter 1 : Be Happy ", 1);
        article1.add(new Title("Title : What is happiness "));
        Document article2 = new Article("Chapter 2 : Don't Worry", 2);
        article2.add(new Title("Title : Be Positive"));
        article1.add(article2);
        assertEquals(article1.getText(), "Chapter 1 : Be Happy ");
    }

    @Test(expected = DocumentException.class)
    public void addLowerLevelArticleToArticleFail(){
        Document article3 = new Article("Chapter 3 : That's OK", 3);
        article3.add(new Title("Title : You're Good Enough "));
        Document article2 = new Article("Chapter 2 : Don't Worry", 2);
        article2.add(new Title("Title : Be Positive"));
        article3.add(article2);
        assertEquals(article3.getText(), "Chapter 3 : That's OK");
    }

 }
