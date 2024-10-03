package Practice.Array;

import java.io.IOException;
import java.util.Scanner;

public class Baii5 {
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
        System.out.println("Nhập 1 số bất kì:");
        int XNumber = scanner.nextInt();

        int closestPrime = -1;
        int closestIndex = -1;
        int minDifference = Integer.MAX_VALUE;

        for (int i = 0; i < number; i++) {
            if (isPrime(numbers[i])) {
                int difference = Math.abs(numbers[i] - XNumber);
                if (difference < minDifference) {
                    minDifference = difference;
                    closestPrime = numbers[i];
                    closestIndex = i;
                }
            }
        }

        if (closestPrime != -1) {
            System.out.println("Số nguyên tố gần nhất với X là: " + closestPrime + " ở vị trí " + closestIndex);
        } else {
            System.out.println("Không có số nguyên tố nào trong mảng.");
        }

    }

    public static boolean isPrime(int number) {
        int countFactors = 0;
        if (number <= 1) {
            return false;
        }

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                countFactors++;
            }
        }

        if (countFactors == 2) {
            return true;
        } else {
            return false;
        }
    }
}
