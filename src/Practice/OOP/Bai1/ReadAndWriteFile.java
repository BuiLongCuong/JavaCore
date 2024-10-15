package Practice.OOP.Bai1;

import java.io.*;
import java.util.*;

public class ReadAndWriteFile {
    File readerFile = new File("data/Readers.csv");
    File bookFile = new File("data/Books.csv");
    File borrowingManagementFile = new File("data/BorrowingManagement.csv");

    public void writeBookFile(ArrayList<Book> list) {
        try {
            FileWriter fileWriter = new FileWriter(bookFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Book book : list) {
                line += book.getIdBook() + "," + book.getName() + "," + book.getAuthor() + "," + book.getSpecialized() + "," + book.getPublishYear() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Book> readBookFile() {
        ArrayList<Book> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(bookFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Specialized specialized = Enum.valueOf(Specialized.class, data[3].trim().toUpperCase());
                Book book = new Book(data[1], data[2], specialized, data[4]);
                list.add(book);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void writeReaderFile(ArrayList<Reader> list) {
        try {
            FileWriter fileWriter = new FileWriter(readerFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Reader reader : list) {
                line += reader.getIdReader() + "," + reader.getFullName() + "," + reader.getAddress() + "," + reader.getPhone() + "," + reader.getReaderType() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Reader> readReaderFile() {
        ArrayList<Reader> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(readerFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                ReaderType readerType = Enum.valueOf(ReaderType.class, data[4].trim().toUpperCase());
                Reader reader = new Reader(data[1], data[2], data[3], readerType);
                list.add(reader);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void writeBorrowingManagementFile(BorrowingManagement borrowingManagement) {
        try {
            FileWriter fileWriter = new FileWriter(borrowingManagementFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Reader reader = borrowingManagement.getReader();
            if (!hasReaderInfoInFile(reader.getIdReader())) {
                String readerInfo = "----- Thông tin người đọc -----\n" + "ID người đọc: " + reader.getIdReader() + "," + reader.getFullName() + "," + reader.getAddress() + "," + reader.getPhone() + "," + reader.getReaderType() + "\n";
                bufferedWriter.write(readerInfo);
            }
            bufferedWriter.write("----- Danh sách sách đã mượn -----\n");

            for (Map.Entry<Book, Integer> entry : borrowingManagement.getBooksBorrowed().entrySet()) {
                Book book = entry.getKey();
//                if (!hasBookInfoInFile(book.getIdBook())) {
                int quantity = entry.getValue();
                String bookStatus = borrowingManagement.getBookStatus().get(book) ? " đã được mượn " : " chưa được mượn ";
                String bookInfo = "ID sách: " + book.getIdBook() + "," + book.getName() + "," + book.getAuthor() + "," + book.getSpecialized() + "," + book.getPublishYear() + "," + bookStatus + "với số lượng là " + "," + quantity + ", " + "cuốn" + "\n";
                bufferedWriter.write(bookInfo);
//                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Map<Book, Integer> readBorrowingManagementFile() {
        BorrowingManagement borrowingManagement = null;
        try {
            FileReader fileReader = new FileReader(borrowingManagementFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            if ((line = bufferedReader.readLine()) != null && !line.equals("----- Thông tin người đọc -----")) {
                String[] dataReader = line.split(",");
                ReaderType readerType = Enum.valueOf(ReaderType.class, dataReader[4].trim().toUpperCase());
                Reader reader = new Reader(dataReader[1], dataReader[2], dataReader[3], readerType);
                borrowingManagement = new BorrowingManagement(reader);
            }

            while ((line = bufferedReader.readLine()) != null) {
                // Bỏ qua các dòng không cần thiết
                if (line.equals("----- Danh sách sách đã mượn -----") || line.equals("----- Thông tin người đọc -----")) {
                    continue;
                }
                if (line.startsWith("ID người đọc:")) {
                    continue;
                }

                String[] dataBook = line.split(",");
//                System.out.println("sách"+ Arrays.toString(dataBook));
                Specialized specialized = Enum.valueOf(Specialized.class, dataBook[3].trim().toUpperCase());
                Book book = new Book(dataBook[1], dataBook[2], specialized, dataBook[4]);
                int quantity = Integer.parseInt(dataBook[6]);

                if (borrowingManagement != null) {
                    borrowingManagement.addBook(book, quantity);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return borrowingManagement != null ? borrowingManagement.getBooksBorrowed() : new HashMap<>();
    }

    private boolean hasReaderInfoInFile(int readerId) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(borrowingManagementFile));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("ID Người đọc: " + readerId)) {
                reader.close();
                return true;
            }
        }
        reader.close();
        return false;
    }

    private boolean hasBookInfoInFile(int bookId) throws IOException {
        BufferedReader book = new BufferedReader(new FileReader(borrowingManagementFile));
        String line;
        while ((line = book.readLine()) != null) {
            if (line.contains("ID Sách: " + bookId)) {
                book.close();
                return true;
            }
        }
        book.close();
        return false;
    }

    public ArrayList<Reader> readReaderBorrowedFile() {
        ArrayList<Reader> list = new ArrayList<>();
        ArrayList<Reader> list2 = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(borrowingManagementFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            System.out.println("hello");
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("----- Danh sách sách đã mượn -----") || line.equals("----- Thông tin người đọc -----")) {
                    continue;
                }
                if (line.startsWith("ID Người đọc: ")) {
                    String[] data = line.split(",");
                    ReaderType readerType = Enum.valueOf(ReaderType.class, data[4].trim().toUpperCase());
                    Reader reader = new Reader(data[1], data[2], data[3], readerType);
                    list.add(reader);
                }
            }
            bufferedReader.close();
            System.out.println("Dữ liệu người đọc đã đọc từ file: " + list);

            for (Reader reader : list) {
                if (!list2.contains(reader)) {
                    list2.add(reader);
                }
            }
            System.out.println(list2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list2;
    }
}

