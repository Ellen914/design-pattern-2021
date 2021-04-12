package org.ntutssl.document;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class FindContentVisitorTest {
    @Test
    public void visitorTitleTest() {
        FindContentVisitor fcv = new FindContentVisitor("Happy");
        Document title1 = new Title("Title 1: Be Happy", 5);
        Document title2 = new Title("Title 2: Be Positive", 2);
        Document title3 = new Title("Title 3: Be Strong", 3);
        
        title1.accept(fcv);
        title2.accept(fcv);
        title3.accept(fcv);

        List<Document> result = fcv.getResult();

        assertEquals("Title 1: Be Happy", result.get(0).getText());
    }

    @Test
    public void visitorTitleSearchWithEmptyStringTest() {
        FindContentVisitor fcv2 = new FindContentVisitor("  ");
        Document title1 = new Title("Title 1: Be Happy", 5);
        Document title2 = new Title("Title 2: Be Positive", 2);
        Document title3 = new Title("Title 3: Be Strong", 3);
        
        title1.accept(fcv2);
        title2.accept(fcv2);
        title3.accept(fcv2);

        List<Document> result = fcv2.getResult();
        
        assertTrue(result.isEmpty());
    }

    @Test
    public void visitorEmptyTitleTest() {
        FindContentVisitor fcv2 = new FindContentVisitor("  ");

        Document title1 = new Title("Title 1: Be Happy", 5);
        Document title2 = new Title("  ", 2);
        Document title3 = new Title("Title 3: Be Strong", 3);
        
        title1.accept(fcv2);
        title2.accept(fcv2);
        title3.accept(fcv2);

        List<Document> result = fcv2.getResult();
        
        assertEquals("  ", result.get(0).getText());
    }

    @Test
    public void visitorParagraphTest() {
        FindContentVisitor fcv = new FindContentVisitor("Happy");
        Document paragraph1 = new Paragraph("Be Strong.");
        Document paragraph2 = new Paragraph("Be Positive.");
        Document paragraph3 = new Paragraph("Be Happy.");
        
        paragraph1.accept(fcv);
        paragraph2.accept(fcv);
        paragraph3.accept(fcv);

        List<Document> result = fcv.getResult();

        assertEquals("Be Happy.", result.get(0).getText());
    }

    @Test
    public void visitorParagraphSearchWithEmptyStringTest() {
        FindContentVisitor fcv2 = new FindContentVisitor("  ");
        Document paragraph1 = new Paragraph("Be Strong.");
        Document paragraph2 = new Paragraph("Be Positive.");
        Document paragraph3 = new Paragraph("Be Happy.");
        
        paragraph1.accept(fcv2);
        paragraph2.accept(fcv2);
        paragraph3.accept(fcv2);

        List<Document> result = fcv2.getResult();
        
        assertTrue(result.isEmpty());
    }

    @Test
    public void visitorEmptyParagraphTest() {
        FindContentVisitor fcv2 = new FindContentVisitor("  ");

        Document paragraph1 = new Paragraph("Be Strong.");
        Document paragraph2 = new Paragraph("  ");
        Document paragraph3 = new Paragraph("Be Happy.");
        
        paragraph1.accept(fcv2);
        paragraph2.accept(fcv2);
        paragraph3.accept(fcv2);

        List<Document> result = fcv2.getResult();
        
        assertEquals("  ", result.get(0).getText());
    }

    @Test
    public void visitorArticleTest() {
        FindContentVisitor fcv = new FindContentVisitor("Happy");
        Document article = new Article("Chapter 1:  What is happiness?", 1);
        Document title = new Title("Title 1: Be Happy", 5);
        Document paragraph = new Paragraph("It's ok that sometimes feel upset.");
        
        article.add(title);
        article.add(paragraph);
        article.accept(fcv);

        List<Document> result = fcv.getResult();

        assertEquals("Title 1: Be Happy", result.get(0).getText());
    }

    @Test
    public void visitorEmptyArticleTest() {
        FindContentVisitor fcv2 = new FindContentVisitor("  ");
        Document article = new Article("Chapter 1:  What is happiness?", 1);
        Document title = new Title("  ", 5);
        Document paragraph = new Paragraph("  ");
        
        article.add(title);
        article.add(paragraph);
        article.accept(fcv2);

        List<Document> result = fcv2.getResult();

        assertEquals("  ", result.get(0).getText());
        assertEquals("  ", result.get(1).getText());
    }
 }
