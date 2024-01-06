package com.design.patterns.creational.factory;

// Product Interface
interface Document {
    void create();
}

// Concrete Products
class PdfDocument implements Document {
    @Override
    public void create() {
        System.out.println("Creating PDF document");
    }
}

class TextDocument implements Document {
    @Override
    public void create() {
        System.out.println("Creating Text document");
    }
}

// Creator Interface
interface DocumentCreator {
    Document createDocument();
}

// Concrete Creators
class PdfDocumentCreator implements DocumentCreator {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class TextDocumentCreator implements DocumentCreator {
    @Override
    public Document createDocument() {
        return new TextDocument();
    }
}

// Client Code
public class DocumentCreation {
    public static void main(String[] args) {
        // Using Factory Method to create PDF document
        DocumentCreator pdfCreator = new PdfDocumentCreator();
        Document pdfDocument = pdfCreator.createDocument();
        pdfDocument.create();

        // Using Factory Method to create Text document
        DocumentCreator textCreator = new TextDocumentCreator();
        Document textDocument = textCreator.createDocument();
        textDocument.create();
    }
}
