package Practice.Array;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử có trong 1 mảng bạn mong muốn: ");
        int number = scanner.nextInt();
        int[] numbers = new int[number];

        for (int i = 0; i < number; i++) {
            System.out.print("numbers[" + i + "] = ");
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Mảng chúng ta có được: [");
        for (int i = 0; i < numbers.length; i++) {
            if (i != numbers.length - 1) {
                System.out.print(numbers[i] + ",");
            } else {
                System.out.println(numbers[i] + "]");
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        System.out.print("Mảng sau khi được sắp xếp: ");
        System.out.println(Arrays.toString(numbers));

        System.out.print("Nhập 1 số nguyên bất kì: ");
        int XNumber = scanner.nextInt();

        boolean inserted = false;

        int[] newNumbers = new int[number + 1];
        for (int i = 0, j = 0; i < number; i++, j++) {
            if (!inserted && numbers[i] > XNumber) {
                newNumbers[i] = XNumber;
                inserted = true;
                j++;
            }
            newNumbers[j] = numbers[i];
        }

        if (!inserted) {
            newNumbers[newNumbers.length - 1] = XNumber;
        }

        System.out.print("Mảng sau khi chèn: ");
        System.out.println(Arrays.toString(newNumbers));
    }
}
