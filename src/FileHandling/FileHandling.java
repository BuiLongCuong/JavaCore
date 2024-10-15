package FileHandling;

import java.io.*;
import java.util.Scanner;

public class FileHandling {
    public void WriteFile(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("Hello everyone");
        fileWriter.close();
        System.out.println("Wrote to file successfully");
    }

    public void ReadFile(File file) throws FileNotFoundException {
        Scanner readFile = new Scanner(file);
        while (readFile.hasNextLine()) {
            String line = readFile.nextLine();
            System.out.println(line);
        }
        readFile.close();
    }
}
