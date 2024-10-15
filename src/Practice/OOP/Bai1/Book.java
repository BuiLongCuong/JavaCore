package Practice.OOP.Bai1;

enum Specialized {
    KHTN,
    VAN_HOC_VA_NGHE_THUAT,
    DIEN_TU_VIEN_THONG,
    CONG_NGHE_THONG_TIN;
}

public class Book {
    private int idBook;
    private static int idIncrements = 1;
    private String name;
    private String author;
    private Specialized specialized;
    private String publishYear;

    public Book(String name, String author, Specialized specialized, String PublishYear) {
        this.idBook = idIncrements;
        this.name = name;
        this.author = author;
        this.specialized = specialized;
        this.publishYear = PublishYear;
        idIncrements++;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
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

    public Specialized getSpecialized() {
        return specialized;
    }

    public void setSpecialized(Specialized specialized) {
        this.specialized = specialized;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", specialized='" + specialized + '\'' +
                ", publishYear='" + publishYear + '\'' +
                '}';
    }
}
