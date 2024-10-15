package Practice.OOP.Bai1;

import java.util.ArrayList;

public class BookManagement {
    private ArrayList<Book> bookList;
    private ReadAndWriteFile readAndWriteFile;

    public BookManagement(){
        readAndWriteFile = new ReadAndWriteFile();
        this.bookList = readAndWriteFile.readBookFile();
    }

    public void addBook(Book newBook) {
        bookList.add(newBook);
        readAndWriteFile.writeBookFile(bookList);
    }

    public void showAll(){
        System.out.println("----------------------- Danh sách sách đọc -----------------------");
        if(bookList.isEmpty()){
            System.out.println("Chưa có sách nào cả !!");
        } else {
            for (Book book: bookList) {
                System.out.println(book.toString());
            }
        }
        System.out.println("-------------------------------------------------------------------");
    }
    public ArrayList<Book> getAllBooks(){
        return bookList;
    }
}
