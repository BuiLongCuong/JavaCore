package Practice.OOP.Bai1;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class LibraryManagement {
    private static Scanner scanner = new Scanner(System.in);
    private static List<BorrowingManagement> borrowings = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        ReaderManagement readerManagement = new ReaderManagement();
        BookManagement bookManagement = new BookManagement();
        BorrowedManagement borrowedManagement = new BorrowedManagement();

        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
//        ArrayList<BorrowingManagement> savedBorrowings = readAndWriteFile.readBorrowingManagementFile();
//        borrowings.addAll(savedBorrowings);

//        borrowings.addAll(savedBorrowings);

//        Reader reader1 = new Reader("Phạm Thu Ngân", "Hoài Nhơn", "0987569466", ReaderType.SINH_VIEN);
//        Reader reader2 = new Reader("Phạm Văn Mạnh", "Hoài Ân ", "0987546466", ReaderType.GIAO_VIEN);
//        Reader reader3 = new Reader("Phạm Minh Phú", "Tăng Bạc Hổ", "0983654976", ReaderType.HOC_VIEN_CAO_HOC);
//        BorrowingManagement borrowingManagement = new BorrowingManagement(reader2);

        int selectGeneral;
        do{
            System.out.println("1.Danh sách sách đọc.");
            System.out.println("2.Thêm sách mới.");
            System.out.println("3.Danh sách người đọc.");
            System.out.println("4.Thêm người đọc mới.");
            System.out.println("5.Quản lí những ai đang mượn sách gì.");
            System.out.println("6.Sắp xếp theo tên của bạn đọc.");
            System.out.println("7.Sắp xếp số sách được mượn (giảm dần).");
            System.out.println("8.Danh sách mượn sách theo tên bạn đọc.");
            System.out.println("0.Thoát.");
            selectGeneral = scanner.nextInt();
            switch (selectGeneral) {
                case 1:
                    bookManagement.showAll();
                    break;
                case 2:
                    addNewBook(bookManagement);
                    break;
                case 3:
                    readerManagement.showAll();
                    break;
                case 4:
                    addNewReader(readerManagement);
                    break;
                case 5:
                    manageBorrowing(readerManagement, bookManagement);
                    break;
                case 6:
                    sortBorrowingsByReaderName();
                    break;
                case 7:
                    sortBorrowingsByBookQuantityDescending();
                    break;
                case 8:
//                    BorrowingManagement.listBorrowingsByReaderName(borrowings);
                    break;
                case 9:
                    Map<Book, Integer> borrowedBooks = readAndWriteFile.readBorrowingManagementFile(); // Lấy danh sách sách đã mượn

                    // Giả sử bạn đã tạo danh sách BorrowingManagement từ borrowedBooks
                    List<BorrowingManagement> borrowingList = new ArrayList<>();
                    for (Map.Entry<Book, Integer> entry : borrowedBooks.entrySet()) {
                        // Giả định rằng bạn có ID người đọc từ đâu đó, ví dụ: thông qua một biến
                        Reader reader = new Reader("Phạm Văn Mạnh", "Hoài Ân ", "0987546466", ReaderType.GIAO_VIEN); // Lấy thông tin người đọc tương ứng
                        BorrowingManagement borrowingManagement = new BorrowingManagement(reader);
                        borrowingManagement.addBook(entry.getKey(), entry.getValue());
                        borrowingList.add(borrowingManagement);
                    }

                    // Lấy danh sách người đọc
                    List<Reader> allReaders = getAllReaders(borrowingList);
                    System.out.println("Danh sách người đã mượn sách: " + allReaders);
                    break;
            }
        }while (selectGeneral != 0);
    }

    public static List<Reader> getAllReaders(List<BorrowingManagement> borrowingList) {
        return borrowingList.stream()
                .map(BorrowingManagement::getReader)
                .distinct()
                .collect(Collectors.toList());
    }

    public static void sortBorrowingsByBookQuantityDescending() {
        if (!borrowings.isEmpty()) {
            BorrowingManagement.sortByBookQuantityDescending(borrowings);
            // Tương tự hàm sắp xếp theo tên, in ra sau khi sắp xếp
        } else {
            System.out.println("Không có thông tin mượn sách.");
        }
    }

    public static void addBorrowing(BorrowingManagement borrowing) {
        borrowings.add(borrowing);
    }

    public static void sortBorrowingsByReaderName() {
        if (!borrowings.isEmpty()) {
            BorrowingManagement.sortByReaderName(borrowings);
            for (BorrowingManagement borrowing : borrowings) {
                System.out.println("----- Thông tin người đọc -----");
                System.out.println("ID Người đọc: " + borrowing.getReader().getIdReader() + ", "
                        + borrowing.getReader().getFullName() + ", "
                        + borrowing.getReader().getAddress() + ", "
                        + borrowing.getReader().getPhone() + ", "
                        + borrowing.getReader().getReaderType());

                System.out.println("----- Danh sách sách đã mượn -----");
                for (Map.Entry<Book, Integer> entry : borrowing.getBooksBorrowed().entrySet()) {
                    Book book = entry.getKey();
                    int quantity = entry.getValue();
                    System.out.println("ID Sách: " + book.getIdBook() + ", "
                            + book.getName() + ", "
                            + book.getAuthor() + ", "
                            + book.getSpecialized() + ", "
                            + book.getPublishYear() + ", đã được mượn với số lượng là " + quantity + " cuốn");
                }
            }
        } else {
            System.out.println("Không có thông tin mượn sách.");
        }
    }

    private static void manageBorrowing(ReaderManagement readerManagement, BookManagement bookManagement) {
        System.out.println("-------------- Mượn tối đa 5 cuốn sách khác nhau và 3 cuốn cho mỗi loại --------------");
        System.out.print("Nhập ID người đọc để quản lí cho mượn: ");
        int readerId = scanner.nextInt();
        scanner.nextLine();
        Reader reader = readerManagement.getAllReaders().stream().
                filter(r -> r.getIdReader() == readerId)
                .findFirst()
                .orElse(null);

        if (reader == null) {
            System.out.println("Không tìm thấy người đọc.");
            return;
        }

        BorrowingManagement borrowing = new BorrowingManagement(reader);
        while (true) {
            System.out.print("Nhập ID sách để quản lí cho mượn (hoặc nhập -1 để kết thúc yêu cầu): ");
            int bookId = scanner.nextInt();
            if (bookId == -1) {
                break;
            }
            Book book = bookManagement.getAllBooks().stream()
                    .filter(b -> b.getIdBook() == bookId)
                    .findFirst()
                    .orElse(null);

            if (book != null) {
                System.out.print("Nhập số lượng sách: ");
                int quantity = scanner.nextInt();
                borrowing.addBook(book, quantity);
            } else {
                System.out.println("Không tìm thấy sách.");
            }
        }
        borrowings.add(borrowing);
        System.out.println(borrowing);
    }

    private static void addNewReader(ReaderManagement readerManagement) {
        scanner.nextLine();
        System.out.println("Nhập tên người đọc: ");
        String nameReader = scanner.nextLine();
        System.out.println("Nhập địa chỉ người dùng: ");
        String address = scanner.nextLine();
        System.out.println("Nhập số điện thoại người dùng: ");
        String phone = scanner.nextLine();
        System.out.println("Loại người đọc (0: SINH_VIEN, 1: HOC_VIEN_CAO_HOC, 2: GIAO_VIEN): ");
        int readerTypeChoice = scanner.nextInt();
        ReaderType readerType = ReaderType.values()[readerTypeChoice];
        scanner.nextLine();
        Reader newReader = new Reader(nameReader, address, phone, readerType);
        readerManagement.addReader(newReader);
        System.out.println("-------------------- Thêm người đọc mới thành công -------------------- !");
    }

    private static void addNewBook(BookManagement bookManagement) {
        scanner.nextLine();
        System.out.println("Nhập tên sách: ");
        String nameBook = scanner.nextLine();
        System.out.println("Nhập tên tác giả: ");
        String author = scanner.nextLine();
        System.out.println("Nhập chuyên ngành của sách (0: KHTN, 1: VAN_HOC_VA_NGHE_THUAT, 2: DIEN_TU_VIEN_THONG, 3: CONG_NGHE_THONG_TIN): ");
        int specializedChoice = scanner.nextInt();
        Specialized specialized = Specialized.values()[specializedChoice];
        scanner.nextLine();
        System.out.println("Nhập năm xuất bản của sách: ");
        String publishYear = scanner.nextLine();
        Book newBook = new Book(nameBook, author, specialized, publishYear);
        bookManagement.addBook(newBook);
        System.out.println("-------------------- Thêm sách mới thành công -------------------- !");
    }

}
