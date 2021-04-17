package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TitleTest { 

    @Test
    public void get_text_success(){
        Document title = new Title("Title 1 : Hello!");
        assertEquals(title.getText(), "Title 1 : Hello!");
    }

    @Rule
    public ExpectedException expectes = ExpectedException.none();

    @Test
    public void addException(){
        expectes.expect(DocumentException.class);
        expectes.expectMessage("Document Exception : invalid usage of add().");
        
        Document title = new Title("Title 1 : Hello!");
        title.add(new Title("Title 1"));
    }

    @Test
    public void getContentException(){
        expectes.expect(DocumentException.class);
        expectes.expectMessage("Document Exception : invalid usage of getContent().");
        Document title = new Title("Title 1 : Hello!");
        title.getContent(0);
    }

    @Test
    public void getLevelException(){
        expectes.expect(DocumentException.class);
        expectes.expectMessage("Document Exception : invalid usage of getLevel().");
        Document title = new Title("Title 1 : Hello!");
        title.getLevel();
    }
 }
