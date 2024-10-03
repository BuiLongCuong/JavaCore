package Practice.Array;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int[] numbers = new int[number];

        for (int i = 0; i < number; i++) {
            System.out.print("numbers[" + i + "] = ");
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Mảng mà chúng ta có được là: numbers[");
        for (int i = 0; i < numbers.length; i++) {

            if (i != numbers.length - 1) {
                System.out.print(numbers[i] + ",");
            } else {
                System.out.println(numbers[i] + "]");
            }
        }

        Map<Integer, Integer> countAppear = new HashMap<>();

        for (Integer num : numbers) {
            countAppear.put(num, countAppear.getOrDefault(num, 0) + 1);
        }

        System.out.println("Số lần xuất hiện của mỗi phần tử:");
        for (Map.Entry<Integer, Integer> entry : countAppear.entrySet()) {
            System.out.println("Phần tử " + entry.getKey() + " xuất hiện: " + entry.getValue() + " lần");
        }
    }
}
