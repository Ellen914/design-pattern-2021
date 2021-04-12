package org.ntutssl.document;

public interface Document { 
    public String getText();

    public default void add(Document document) throws DocumentException {
        throw new DocumentException("Document Exception : invalid usage of add().");
    }

    public default Document getContent(int index) throws DocumentException {
        throw new DocumentException("Document Exception : invalid usage of getContent().");
    }

    public default int getLevel() throws DocumentException {
        throw new DocumentException("Document Exception : invalid usage of getLevel().");
    }

}
