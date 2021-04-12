package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TitleTest { 

    @Test
    public void getTextSuccess(){
        Document title = new Title("Title 1 : Hello!", 1);
        assertEquals("Title 1 : Hello!", title.getText());
    }

    @Test
    public void getSizeSuccess(){
        Document title = new Title("Title 1 : Hello!", 1);
        assertEquals(1, title.getSize());
    }

    @Test
    public void toStringTest() {
        Document title = new Title("Title 1 : Hello!", 5);
        String expected = "Title\t\ttext: Title 1 : Hello!" + "\n" +
                          "\t\tsize: 5" + "\n";
        assertEquals(expected, title.toString());
    }

    @Rule
    public ExpectedException expectes = ExpectedException.none();

    @Test
    public void addException(){
        expectes.expect(DocumentException.class);
        expectes.expectMessage("Document Exception : invalid usage of add().");
        
        Document title = new Title("Title 1 : Hello!", 1);
        title.add(new Title("Title 1", 1));
    }

    @Test
    public void getLevelException(){
        expectes.expect(DocumentException.class);
        expectes.expectMessage("Document Exception : invalid usage of getLevel().");
        Document title = new Title("Title 1 : Hello!", 1);
        title.getLevel();
    }

    @Test
    public void acceptFunctionTest() {
        FindContentVisitor fcv = new FindContentVisitor("Hello");
        HtmlOutputVisitor hov = new HtmlOutputVisitor();
        Document title = new Title("Title 1 : Hello!", 5);

        title.accept(fcv);
        title.accept(hov);

        List<Document> fcvResult = fcv.getResult();
        String hovResult = hov.getResult();

        assertEquals("Title 1 : Hello!", fcvResult.get(0).getText());
        assertEquals("<h5>Title 1 : Hello!</h5>\n", hovResult);
    }

    @Test
    public void addParagraphException() {
        expectes.expect(DocumentException.class);
        Document title = new Title("Title 1 : Hello!", 5);
        Document paragraph = new Paragraph("Paragraph 1 : Hi!");
        title.add(paragraph);
    }

    @Test
    public void addArticleException() {
        expectes.expect(DocumentException.class);
        Document title = new Title("Title 1 : Hello!", 5);
        Document article = new Article("How to say Goodbye?", 1);
        title.add(article);
    }
 }
