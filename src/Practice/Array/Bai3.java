package Practice.Array;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử có trong 1 mảng bạn mong muốn: ");
        int number = scanner.nextInt();

        int[] numbers = new int[number];

        for (int i = 0; i < number; i++) {
            System.out.print("numbers[" + i + "] = ");
            numbers[i] = scanner.nextInt();
        }

        Map<Integer, Integer> frequenMap = new HashMap<>();
        for (int num : numbers) {
            frequenMap.put(num, frequenMap.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = 0;
        int mostFrequentElement = numbers[0];
        for (Map.Entry<Integer, Integer> entry : frequenMap.entrySet()) {
            if(entry.getValue() > maxFrequency){
                maxFrequency = entry.getValue();
                mostFrequentElement = entry.getKey();
            }
        }

        System.out.println("Phần tử có số lần xuất hiện nhiều nhất: " + mostFrequentElement);
        System.out.println("Xuất hiện " + maxFrequency + " lần.");

    }
}
