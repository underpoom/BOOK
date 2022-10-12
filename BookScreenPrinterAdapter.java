public class BookScreenPrinterAdapter implements IBookScreenPrinter {
    private BookPrinter adaptee;
    
    public BookScreenPrinterAdapter(BookPrinter adaptee) {
        super();
        this.adaptee = adaptee;
    }
    
    @Override
    public void printToScreen() {
        adaptee.printToScreen();
    }
}