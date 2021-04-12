package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
        paragraph.add(new Paragraph("Title 1"));
    }

    @Test
    public void getLevelException(){
        expectes.expect(DocumentException.class);
        expectes.expectMessage("Document Exception : invalid usage of getLevel().");
        Document paragraph = new Paragraph("Paragraph 1 : Hi!");
        paragraph.getLevel();
    }

    @Test
    public void getSizeException(){
        expectes.expect(DocumentException.class);
        expectes.expectMessage("Document Exception : invalid usage of getSize().");
        Document paragraph = new Paragraph("Paragraph 1 : Hi!");
        paragraph.getSize();
    }

    @Test
    public void toStringSuccess() {
        String expected = "Paragraph\ttext: Paragraph 1 : Hi!\n";
        Document paragraph = new Paragraph("Paragraph 1 : Hi!");
        assertEquals(expected, paragraph.toString());
    }

    @Test
    public void acceptFunctionTest() {
        FindContentVisitor fcv = new FindContentVisitor("Hi");
        HtmlOutputVisitor hov = new HtmlOutputVisitor();
        Document paragraph = new Paragraph("Paragraph 1 : Hi!");

        paragraph.accept(fcv);
        paragraph.accept(hov);

        List<Document> fcvResult = fcv.getResult();
        String hovResult = hov.getResult();

        assertEquals("Paragraph 1 : Hi!", fcvResult.get(0).getText());
        assertEquals("<p>Paragraph 1 : Hi!</p>\n", hovResult);
    }

    @Test
    public void addTitleException() {
        expectes.expect(DocumentException.class);
        Document paragraph = new Paragraph("Paragraph 1 : Hi!");
        Document title = new Title("Title 1: Bye!", 10);
        paragraph.add(title);
    }

    @Test
    public void addArticleException() {
        expectes.expect(DocumentException.class);
        Document paragraph = new Paragraph("Paragraph 1 : Hi!");
        Document article = new Article("How to say Goodbye?", 1);
        paragraph.add(article);
    }
 }
