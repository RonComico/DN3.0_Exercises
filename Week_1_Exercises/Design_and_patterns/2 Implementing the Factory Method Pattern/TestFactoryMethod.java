// Document.java
interface Document {
    void open();
}

// WordDocument.java
class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document...");
    }
}

// PdfDocument.java
class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document...");
    }
}

// ExcelDocument.java
class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel document...");
    }
}

// DocumentFactory.java
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// WordDocumentFactory.java
class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

// PdfDocumentFactory.java
class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

// ExcelDocumentFactory.java
class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// TestFactoryMethod.java
public class TestFactoryMethod {
    public static void main(String[] args) {
        // Create factories for each document type
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        // Create and open Word document
        Document wordDocument = wordFactory.createDocument();
        wordDocument.open();

        // Create and open PDF document
        Document pdfDocument = pdfFactory.createDocument();
        pdfDocument.open();

        // Create and open Excel document
        Document excelDocument = excelFactory.createDocument();
        excelDocument.open();
    }
}
