package Practice.OOP.Bai1;

import java.util.ArrayList;

public class BorrowedManagement {
    private ArrayList<Reader> readersBorrowed;
    private ReadAndWriteFile readAndWriteFile;

    public BorrowedManagement() {
        readAndWriteFile = new ReadAndWriteFile();
        this.readersBorrowed = readAndWriteFile.readReaderBorrowedFile();
    }

    public void showAll(){
        System.out.println(readersBorrowed);
        System.out.println("----------------------- Danh sách sách đọc đang mượn sách -----------------------");
        if(readersBorrowed.isEmpty()){
            System.out.println("Chưa có người đọc nào cả ??!!");
        } else {
            for (Reader reader : readersBorrowed) {
                System.out.println(reader.toString());

            }
        }
        System.out.println("-------------------------------------------------------------------");
    }
}
