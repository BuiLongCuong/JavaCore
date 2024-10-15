package Practice.OOP.Bai1;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

public class BorrowingManagement implements Comparator<BorrowingManagement> {
    private Reader reader;
    private Map<Book,Integer> booksBorrowed;
    private Map<Book, Boolean> bookStatus = new HashMap<>();
    private ReadAndWriteFile readAndWriteFile;

    public BorrowingManagement(Reader reader){
        readAndWriteFile = new ReadAndWriteFile();
        this.reader = reader;
        this.booksBorrowed = readAndWriteFile.readBorrowingManagementFile();
    }

    public void addBook(Book book, int quantity){
        if(booksBorrowed.size() <= 5) {
            int currentQuantity = booksBorrowed.getOrDefault(book, 0);
            if(currentQuantity + quantity <= 3) {
                booksBorrowed.put(book, currentQuantity + quantity);
                bookStatus.put(book, true);

                readAndWriteFile.writeBorrowingManagementFile(this);
                System.out.println("Sách " + book.getName() + " đã được mượn với số lượng " + quantity);
            } else {
                System.out.println("Không thể mượn quá 3 cuốn cho mỗi loại cuốn sách.");
            }
        } else {
            System.out.println("Không thể mượn hơn 5 cuốn sách khác nhau.");
        }
    }

    public Reader getReader() {
        return reader;
    }

    public Map<Book, Boolean> getBookStatus() {
        return bookStatus;
    }

    public Map<Book, Integer> getBooksBorrowed() {
        return booksBorrowed;
    }

    public int getTotalBooksBorrowed() {
        return booksBorrowed.values().stream().mapToInt(Integer::intValue).sum();
    }

    public List<Reader> getAllReaders(List<BorrowingManagement> borrowingList){
        return borrowingList.stream()
                .map(BorrowingManagement::getReader)
                .collect(Collectors.toList());
    }

    public static void sortByReaderName(List<BorrowingManagement> borrowings) {
        Collections.sort(borrowings, new Comparator<BorrowingManagement>() {
            @Override
            public int compare(BorrowingManagement b1, BorrowingManagement b2) {
                return b1.getReader().getFullName().compareToIgnoreCase(b2.getReader().getFullName());
            }
        });
    }


    public static void sortByBookQuantityDescending(List<BorrowingManagement> borrowings) {
        Collections.sort(borrowings, new Comparator<BorrowingManagement>() {
            @Override
            public int compare(BorrowingManagement b1, BorrowingManagement b2) {
                int totalBooks1 = b1.getBooksBorrowed().values().stream().mapToInt(Integer::intValue).sum();
                int totalBooks2 = b2.getBooksBorrowed().values().stream().mapToInt(Integer::intValue).sum();
                return Integer.compare(totalBooks2, totalBooks1);
            }
        });
    }

    public static void listBorrowingsByReaderName(List<BorrowingManagement> borrowings) {
        Collections.sort(borrowings, new Comparator<BorrowingManagement>() {
            @Override
            public int compare(BorrowingManagement b1, BorrowingManagement b2) {
                return b1.getReader().getFullName().compareToIgnoreCase(b2.getReader().getFullName());
            }
        });

        for (BorrowingManagement borrowing : borrowings) {
            System.out.println("Tên bạn đọc: " + borrowing.getReader().getFullName());
            System.out.println("Số sách đã mượn:");
            for (Map.Entry<Book, Integer> entry : borrowing.getBooksBorrowed().entrySet()) {
                Book book = entry.getKey();
                int quantity = entry.getValue();
                System.out.println("- Sách: " + book.getName() + " (Số lượng: " + quantity + ")");
            }
            System.out.println("------------------------------");
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(reader.getFullName()).append(" đã mượn\n");
        for (Map.Entry<Book, Integer> entry : booksBorrowed.entrySet()) {
            result.append(entry.getKey().getName()).append(" - ").append(entry.getValue()).append(" cuốn\n");
        }
        return result.toString();
    }

    @Override
    public int compare(BorrowingManagement o1, BorrowingManagement o2) {
        return 0;
    }

    @Override
    public Comparator<BorrowingManagement> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<BorrowingManagement> thenComparing(Comparator<? super BorrowingManagement> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<BorrowingManagement> thenComparing(Function<? super BorrowingManagement, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<BorrowingManagement> thenComparing(Function<? super BorrowingManagement, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<BorrowingManagement> thenComparingInt(ToIntFunction<? super BorrowingManagement> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<BorrowingManagement> thenComparingLong(ToLongFunction<? super BorrowingManagement> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<BorrowingManagement> thenComparingDouble(ToDoubleFunction<? super BorrowingManagement> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }
}
