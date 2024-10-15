package Practice.Array;

import java.io.IOException;
import java.util.Scanner;

public class Bai22 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào 1 xâu kí tự bất kì: ");

        String inputChar = scanner.nextLine();
        
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < inputChar.length(); i++) {
            char currentChar = inputChar.charAt(i);
            if(i %2 == 0) {
                stringBuilder.append(Character.toUpperCase(currentChar));
            } else {
                stringBuilder.append(Character.toLowerCase(currentChar));
            }
        }

        System.out.println("Kết quả: " + stringBuilder.toString());

        scanner.close();
    }
}
