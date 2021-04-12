package org.ntutssl.document;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class InstructionHandler {
	private Editor editor;
	private int currentLevel = 0;

	public InstructionHandler(Editor editor) {
		this.editor = new Editor();
	}

	public void run() {
		while(true) {
			Scanner input = new Scanner(System.in);
			printEditorInstructions();
			String instruction;
			instruction = input.nextLine();

			if(instruction.equals("exit")) {
				break;
			} else {
				handleEditorInstructions(instruction);
			}
		}	
		System.exit(0);
	}

	private void printEditorInstructions() {
		System.out.println("Please enter the following instruction to start editing:\n");
		System.out.println("  1. 'add title': to add a title to the editor\n");
		System.out.println("  2. 'add paragraph': to add a paragraph to the editor\n");
		System.out.println("  3. 'add article': to add an article to the editor\n");
		System.out.println("  4. 'find content': to find the specific string in the editor\n");
		System.out.println("  5. 'output html': to transfer the text to html format\n");
		System.out.println("  6. 'exit': to exit the program\n");
	}
	
	private void handleEditorInstructions(String instruction) {
		if(instruction.equals("add title")) {
			Document title = addTitleInstruction();
			if(!(title.getSize() <= 0)) {
				editor.add(title);
				System.out.println("Title added to editor.\n");
			}
		} else if(instruction.equals("add paragraph")) {
			Document paragraph = addParagraphInstruction();
			editor.add(paragraph);
			System.out.println("Paragrapgh added to editor.\n");
		} else if(instruction.equals("add article")) {
			Document inputArticle = addArticleInstruction(this.currentLevel);
			if(!(inputArticle.getLevel() == this.currentLevel)) {
				while(true) {
					Scanner input = new Scanner(System.in);
					printArticleInstructions();
					String articleInstruction = input.nextLine();
					if(articleInstruction.equals("exit")) {
						break;
					} else {
						this.currentLevel = inputArticle.getLevel();
						handleArticleInstructions(articleInstruction, (Article) inputArticle);
					}
				}
			}
			if(inputArticle.getLevel() >= this.currentLevel) {
				editor.add(inputArticle);
				System.out.println("Article added to the editor.\n");
			}
		} else if(instruction.equals("find content")) {
			findContentInstruction();
		} else if(instruction.equals("output html")) {
			outputHtmlInstruction();
		} else {
			System.out.println("Invalid!");
		}
	}

	private Document addTitleInstruction() {
		Scanner input = new Scanner(System.in);
		String titleText;
		int titleSize;
		System.out.println("Please enter the information of title:");
		System.out.println("Text of title: ");
		titleText = input.nextLine();
		System.out.println("Size of title: ");
		titleSize = input.nextInt();
		if(titleSize > 7 || titleSize == 0) {
			System.out.println("Invalid Input!");
			return new Title("", 0);
		} else if(titleSize < 0) {
			System.out.println("Invalid Input!");
			return new Title("", 0);
		} else {
			return new Title(titleText, titleSize);
		}
	}

	private Document addParagraphInstruction() {
		Scanner input = new Scanner(System.in);
		String paragraphText;
		System.out.println("\nPlease enter the information of paragraph:");
		System.out.println("Text of paragraph: ");
		paragraphText = input.nextLine();
		return new Paragraph(paragraphText);
	}

	private Document addArticleInstruction(int lastLevel) {
		Scanner input = new Scanner(System.in);
		String topicText;
		int level;
		System.out.println("\nPlease enter the information of article:");
		System.out.println("Topic of article: ");
		topicText = input.nextLine();
		System.out.println("Level of article: ");
		level = input.nextInt();
		if(level <= lastLevel) {
			System.out.println("Invalid Input: The level should be positive or higher than the level of the current article\n");
			return new Article("", lastLevel);
		} else {
			return new Article(topicText, level);
		}	
	}

	private void printArticleInstructions() {
		System.out.println("Please enter the following instruction to edit the article:\n");
		System.out.println("  1. 'add title': to add a title to the article\n");
		System.out.println("  2. 'add paragraph': to add a paragraph to the article\n");
		System.out.println("  3. 'add article': to add an article to the article\n");
		System.out.println("  4. 'exit': to exit the process\n");
	}

	private void handleArticleInstructions(String instruction, Article article) {
		if(instruction.equals("add title")) {
			Document title = addTitleInstruction();
			article.add(title);
			System.out.println("Title added to the article level " + article.getLevel() + ".\n");
		} else if(instruction.equals("add paragraph")) {
			Document paragraph = addParagraphInstruction();
			article.add(paragraph);
			System.out.println("Paragrapgh added to the article" + article.getLevel() + ".\n");
		} else if(instruction.equals("add article")) {
			Document inputArticle = addArticleInstruction(this.currentLevel);
			while(true) {
				Scanner input = new Scanner(System.in);
				printArticleInstructions();
				System.out.println("Instruction: ");
				String articleInstruction = input.nextLine();
				if(article.getLevel() == inputArticle.getLevel()) {
					break;
				}
				if(articleInstruction.equals("exit")) {
					break;
				} else {
					this.currentLevel = inputArticle.getLevel();
					handleArticleInstructions(articleInstruction, (Article) inputArticle);
				}
			}
			if(!(inputArticle.getLevel() < this.currentLevel)) {
				article.add(inputArticle);
				System.out.println("Article level " + inputArticle.getLevel() + " added to the article level " + article.getLevel() + ".\n");
			}
		} else {
			System.out.println("Invalid!");
		}
	}
	

	private void findContentInstruction() {
		Scanner input = new Scanner(System.in);
		String searchText;
		System.out.println("\nEnter the word you want to find: ");
		searchText = input.nextLine();
		FindContentVisitor fcv = new FindContentVisitor(searchText);
		Iterator<Document> it = editor.iterator();
		while(it.hasNext()) {
			Document temp = it.next();
			temp.accept(fcv);
		}
		List<Document> result = fcv.getResult();
		for(Document d : result) {
			System.out.println(d.toString());
		}
	}

	private void outputHtmlInstruction() {
		HtmlOutputVisitor hov = new HtmlOutputVisitor();
		Iterator<Document> it = editor.iterator();
		while(it.hasNext()) {
			Document temp = it.next();
			temp.accept(hov);
		}
		String result = hov.getResult();
		System.out.println("HTML output:\n");
		System.out.println(result);
	}

}