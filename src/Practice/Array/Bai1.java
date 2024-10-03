package Practice.Array;

import java.io.IOException;

public class Bai1 {
    public static void main(String[] args) throws IOException {
        int[] number = {1,2,3,4,5,4,3,2,1};
        boolean check = true;

        for (int i = 0; i < number.length / 2; i++) {
           if(number[i] != number[number.length - i - 1]) {
               check = false;
               break;
           }
        }

        if (check) {
            System.out.println("Là mảng đối xứng");
        } else {
            System.out.println("Không phải mảng đối xứng");
        }

    }
}
