package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HtmlOutputVisitorTest {
    @Test
    public void visitParagraphTest() {
        HtmlOutputVisitor hov = new HtmlOutputVisitor();
        Document paragraph = new Paragraph("Paragraph 1 : Hi!");
        paragraph.accept(hov);
        String result = hov.getResult();
        assertEquals("<p>Paragraph 1 : Hi!</p>\n", result);
    }

    @Test
    public void visitTitleTest() {
        HtmlOutputVisitor hov = new HtmlOutputVisitor();
        Document title = new Title("Title 1 : Be Happy", 1);
        title.accept(hov);
        String result = hov.getResult();
        assertEquals("<h1>Title 1 : Be Happy</h1>\n", result);
    }

    @Test
    public void visitArticleTest() {
        HtmlOutputVisitor hov = new HtmlOutputVisitor();
        Document article = new Article("Chapter 1 : Be Happy", 1);
        Document title = new Title("Title : What is happiness", 1);
        Document paragraph = new Paragraph("Happiness is the most important thing in your life.");

        article.add(title);
        article.add(paragraph);
        article.accept(hov);

        String result = hov.getResult();
        String expectedResult = "<article topic='Chapter 1 : Be Happy'>" + "\n" +
                                "  <h1>Title : What is happiness</h1>" + "\n" +
                                "  <p>Happiness is the most important thing in your life.</p>" + "\n" +
                                "</article>" + "\n";

        assertEquals(expectedResult, result);
    }

    @Test
    public void visitArticleInAnotherArticle() {
        HtmlOutputVisitor hov = new HtmlOutputVisitor();
        Document article1 = new Article("Chapter 1 : Be Happy", 1);
        Document title1 = new Title("Title : What is happiness", 1);
        Document paragraph1 = new Paragraph("Happiness is the most important thing in your life.");
        Document article2 = new Article("Chapter 2 : Be Positive", 2);
        Document title2 = new Title("Title : Keep being positive", 2);
        Document paragraph2 = new Paragraph("The hardest but most important thing.");

        article1.add(title1);
        article1.add(paragraph1);
        article2.add(title2);
        article2.add(paragraph2);
        article1.add(article2);
        article1.accept(hov);

        String result = hov.getResult();
        String expectedResult = "<article topic='Chapter 1 : Be Happy'>\n" +
                             "  <h1>Title : What is happiness</h1>\n" +
                             "  <p>Happiness is the most important thing in your life.</p>\n" +
                             "  <article topic='Chapter 2 : Be Positive'>\n" +
                             "    <h2>Title : Keep being positive</h2>\n" +
                             "    <p>The hardest but most important thing.</p>\n" +
                             "  </article>\n" +
                             "</article>\n";

        assertEquals(expectedResult, result);
    }
 }
