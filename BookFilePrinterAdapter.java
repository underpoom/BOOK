public class BookFilePrinterAdapter implements IBookFilePrinter {
    private BookPrinter adaptee;
    
    public BookFilePrinterAdapter(BookPrinter adaptee) {
        super();
        this.adaptee = adaptee;
    }
    
    @Override
    public void printToFile() {
        adaptee.printToFile();
    }
}