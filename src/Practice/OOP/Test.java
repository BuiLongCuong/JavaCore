package Practice.OOP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Đọc data từ file Book.csv, lưu vào 1 mảng, sau đó sắp xếp theo tieu chi
* */

class BookTest{
    private int id;
    private String name;
    private String author;
    private String category;
    private int year;

    public BookTest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "BookTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", year=" + year +
                '}';
    }
}

public class Test {

    public static void main(String[] args) {
        // Read file and init BookList
        List<BookTest> bookLists = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data/Books.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                BookTest bookTest = new BookTest();
                bookTest.setId(Integer.parseInt(values[0]));
                bookTest.setName(values[1]);
                bookTest.setAuthor(values[2]);
                bookTest.setCategory(values[3]);
                bookTest.setYear(Integer.parseInt(values[4]));
                bookLists.add(bookTest);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        // sort bookLists theo ten sach
        bookLists.sort((b1, b2) -> b1.getName().compareTo(b2.getName()));

        for (BookTest bookTest : bookLists){
            System.out.println(bookTest.toString());
        }
    }
}
