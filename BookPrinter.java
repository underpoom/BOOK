
import java.util.ListIterator;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class BookPrinter {
    private Book book;
    private ListIterator<String> iterator;
    private String currentPage;
    
    public BookPrinter(Book book) {
        this.book = book;
        turnToFirstPage();
    }
    
    public String getCurrentPage() {
        return currentPage;
    }
    public void turnToFirstPage() {
        iterator = book.getPagesIterator();
        if (iterator.hasNext()) {
            currentPage = iterator.next();
        } else {
            currentPage = null;
        }
    }
    public boolean turnToNextPage() {
        if (iterator.hasNext()) {
            currentPage = iterator.next();
            return true;
        } else {
            return false;
        }
    }
    
    public void printToScreen() {
        turnToFirstPage();
        do {
            System.out.println(getCurrentPage());
        } while (turnToNextPage());
    }
    
    public void printToFile() {
        boolean isEven = false;
        String previousPage = "";
        
        turnToFirstPage();
        try {
            FileWriter fileWriter = new FileWriter(book.getTitle() + ".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            do {
                if (isEven) {
                    previousPage = getCurrentPage();
                    isEven = false;
                } else {
                    printWriter.printf("%-25s : %25s%n", previousPage, getCurrentPage());
                    isEven = true;
                }
            } while (turnToNextPage());
            printWriter.close();
        } catch (IOException ex) {
            System.out.println("Cannot print this book due to IOException");
        }
    }
}