package FileHandling;

import java.io.File;
import java.io.IOException;

public class FileMain {
    public static void main(String[] args) throws IOException {
        // Create file:
        File myObj = new File("filename.txt");
        myObj.createNewFile();

        FileHandling fileHandling = new FileHandling();
        fileHandling.WriteFile(myObj);
        fileHandling.ReadFile(myObj);
    }
}
