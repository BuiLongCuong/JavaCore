package Practice.Array;

import java.io.IOException;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử có trong 1 mảng bạn mong muốn: ");
        int number = scanner.nextInt();
        int[] numbers = new int[number];

        for (int i = 0; i < number; i++) {
            System.out.print("numbers[" + i + "] = ");
            numbers[i] = scanner.nextInt();
        }


        for (int i = 0; i < numbers.length; i++) {
            boolean checkUnique = true;
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    checkUnique = false;
                    break;
                }
            }
            if (checkUnique) {
                System.out.println(numbers[i] + " ");
            }
        }
    }
}
