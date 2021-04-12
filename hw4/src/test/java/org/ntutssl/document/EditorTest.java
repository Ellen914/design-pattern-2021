package org.ntutssl.document;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class EditorTest { 
    @Test
    public void addTest() {
        Editor editor = new Editor();

        Document article = new Article("Chapter 1 : Be Happy", 1);
        Document title = new Title("Title : What is happiness", 1);
        Document paragraph = new Paragraph("Happiness is the most important thing in your life.");

        editor.add(article);
        editor.add(title);
        editor.add(paragraph);

        Iterator<Document> it = editor.iterator();

        assertTrue(it.hasNext());
        assertEquals("Chapter 1 : Be Happy", it.next().getText());
        
        assertTrue(it.hasNext());
        assertEquals("Title : What is happiness", it.next().getText());

        assertTrue(it.hasNext());
        assertEquals("Happiness is the most important thing in your life.", it.next().getText());

        assertFalse(it.hasNext());
    }

    public void sizeTest() {
        Editor editor = new Editor();

        Document article = new Article("Chapter 2 : Don't Worry", 1);
        Document title = new Title("Title : Be Positive", 1);
        Document paragraph = new Paragraph("Being positive can give us energy.");

        editor.add(article);
        editor.add(title);
        editor.add(paragraph);
        
        assertEquals(3, editor.size());
    }


    @Test(expected = NoSuchElementException.class)
    public void addException() {
        Editor editor = new Editor();

        Document article = new Article("Chapter 1 : Be Happy", 1);
        Document title = new Title("Title : What is happiness", 1);
        Document paragraph = new Paragraph("Happiness is the most important thing in your life.");

        editor.add(article);
        editor.add(title);
        editor.add(paragraph);

        Iterator<Document> it = editor.iterator();

        assertTrue(it.hasNext());
        assertEquals("Chapter 1 : Be Happy", it.next().getText());
        
        assertTrue(it.hasNext());
        assertEquals("Title : What is happiness", it.next().getText());

        assertTrue(it.hasNext());
        assertEquals("Happiness is the most important thing in your life.", it.next().getText());

        assertFalse(it.hasNext());
        it.next();
    }
}