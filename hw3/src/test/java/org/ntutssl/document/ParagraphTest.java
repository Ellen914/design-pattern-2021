package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParagraphTest { 
    @Test
    public void getTextSuccess(){
        Document paragraph = new Paragraph("Paragraph 1 : Hi!");
        assertEquals(paragraph.getText(), "Paragraph 1 : Hi!");
    }

    @Rule
    public ExpectedException expectes = ExpectedException.none();

    @Test
    public void addException(){
        expectes.expect(DocumentException.class);
        expectes.expectMessage("Document Exception : invalid usage of add().");
        Document paragraph = new Paragraph("Paragraph 1 : Hi!");
        paragraph.add(new Title("Title 1"));
    }

    @Test
    public void getContentException(){
        expectes.expect(DocumentException.class);
        expectes.expectMessage("Document Exception : invalid usage of getContent().");
        Document paragraph = new Paragraph("Paragraph 1 : Hi!");
        paragraph.getContent(0);
    }

    @Test
    public void getLevelException(){
        expectes.expect(DocumentException.class);
        expectes.expectMessage("Document Exception : invalid usage of getLevel().");
        Document paragraph = new Paragraph("Paragraph 1 : Hi!");
        paragraph.getLevel();
    }

    
 }
