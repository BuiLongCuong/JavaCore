package Practice.Array;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Bai2 {
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
            for (int j = i; j > 0; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    int temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}
