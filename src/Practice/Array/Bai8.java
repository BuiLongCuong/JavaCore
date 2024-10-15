package Practice.Array;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chiều dài của mảng 1: ");
        int number1 = scanner.nextInt();
        int[] arrayNumber1 = new int[number1];

        for (int i = 0; i < number1; i++) {
            System.out.print("arrayNumber1[" + i + "] = ");
            arrayNumber1[i] = scanner.nextInt();
        }

        System.out.print("Nhập chiều dài mảng 2: ");
        int number2 = scanner.nextInt();
        int[] arrayNumber2 = new int[number2];

        for (int i = 0; i < number2; i++) {
            System.out.print("arrayNumber2[" + i + "] = ");
            arrayNumber2[i] = scanner.nextInt();
        }

        System.out.println("Ta có mảng đầu tiên như sau: arrayNumber1" + Arrays.toString(arrayNumber1));
        System.out.println("Ta có mảng thứ 2 như sau: arrayNumber2" + Arrays.toString(arrayNumber2));

        System.out.print("Nhập vị trí p mà bạn muốn chèn mảng 2 vào mảng 1, điều kiện (0≤p< chiều dài của mảng 1): ");
        int p = scanner.nextInt();

        if(p < 0 || p > arrayNumber1.length) {
            System.out.println("Bạn đã nhập sai điều kiện !");
        }

        int[] newArray = new int[number1 + number2];

        for (int i = 0; i < p; i++) {
            newArray[i] = arrayNumber1[i];
        }

        for (int i = 0; i < number2; i++) {
            newArray[p + i] = arrayNumber2[i];
        }

        for (int i = p; i < number1; i++) {
            newArray[number2 + i] = arrayNumber1[i];
        }

        System.out.println("Mảng sau khi chèn arrayNumber2 vào vị trí " + p + " của arrayNumber1: " + Arrays.toString(newArray));
    }
}
