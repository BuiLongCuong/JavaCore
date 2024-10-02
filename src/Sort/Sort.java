package Sort;

import java.util.Arrays;

public class Sort {
    public void BubbleSort(int[] number){
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number.length; j++) {
                if(number[i] < number[j]) {
                    int temp = number[i];
                    number[i] = number[j];
                    number[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(number));
    }

    public void SelectionSort(int[] number){
        for (int i = 0; i < number.length; i++) {
            int min = i;
            for (int j = i + 1; j < number.length; j++) {
                if(number[j] < number[min]) {
                    min = j;
                }
            }
            int temp = number[i];
            number[i] = number[min];
            number[min] = temp;
        }
        System.out.println(Arrays.toString(number));
    }

    public void InsertSort(int[] number){
        for (int i = 0; i < number.length; i++) {
            for (int j = i; j > 0; j--) {
                if(number[j] < number[j- 1]) {
                    int temp = number[j-1];
                    number[j-1] = number[j];
                    number[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(number));
    }
}
