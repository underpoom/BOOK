import java.util.List;

public class Main {
	public static void main(String[] args) {
		Book book = new Book("Tyland", 
		    List.of("I", "moved", "here", "recently", "too"));
		    
		BookPrinter bookPrinter = new BookPrinter(book);
		
		BookFilePrinterAdapter fileAdapter = new BookFilePrinterAdapter(bookPrinter);
		fileAdapter.printToFile();
		
		BookScreenPrinterAdapter screenAdapter = new BookScreenPrinterAdapter(bookPrinter);
		screenAdapter.printToScreen();
	}
}