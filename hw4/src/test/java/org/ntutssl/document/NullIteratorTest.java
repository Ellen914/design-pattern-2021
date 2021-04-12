package org.ntutssl.document;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class NullIteratorTest { 
    @Test
    public void iteratorSuccess() {
        Document article = new Article("Chapter 3 : That's OK", 3);
        article.add(new Title("Title 1", 5));
        article.add(new Paragraph("It's ok that sometimes feel upset."));

        Iterator<Document> it = article.iterator();

        assertTrue(it.hasNext());
        assertEquals("Title 1", it.next().getText());
        
        assertTrue(it.hasNext());
        assertEquals("It's ok that sometimes feel upset.", it.next().getText());

        assertFalse(it.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorException() {
        Document article = new Article("Chapter 3 : That's OK", 3);
        article.add(new Title("Title 1", 5));
        article.add(new Paragraph("It's ok that sometimes feel upset."));

        Iterator<Document> it = article.iterator();

        assertTrue(it.hasNext());
        assertEquals("Title 1", it.next().getText());
        
        assertTrue(it.hasNext());
        assertEquals("It's ok that sometimes feel upset.", it.next().getText());

        assertFalse(it.hasNext());
        it.next();
    }
}