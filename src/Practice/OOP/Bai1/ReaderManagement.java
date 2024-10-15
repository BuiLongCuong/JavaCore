package Practice.OOP.Bai1;

import java.util.ArrayList;

public class ReaderManagement {
    private ArrayList<Reader> readersList;
    private ReadAndWriteFile readAndWriteFile;

    public ReaderManagement(){
        readAndWriteFile = new ReadAndWriteFile();
        this.readersList = readAndWriteFile.readReaderFile();
    }

    public void addReader(Reader newReader){
        readersList.add(newReader);
        System.out.println(newReader);
        readAndWriteFile.writeReaderFile(readersList);
    }

    public void showAll(){
        System.out.println("----------------------- Danh sách người đọc -----------------------");
        if(readersList.isEmpty()){
            System.out.println("Chưa có người đọc nào cả !!");
        } else {
            for (Reader reader: readersList) {
                System.out.println(reader.toString());

            }
        }
        System.out.println("---------------------------------------------------------------------");
    }

    public ArrayList<Reader> getAllReaders(){
        return readersList;
    }
}
