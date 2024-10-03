package Sort;

import java.io.IOException;

public class SortMain {
    public static void main(String[] args) throws IOException{
        int[] number = new int[]{2,26,4,21,3,7};
        Sort sort = new Sort();
        sort.BubbleSort(number);
        sort.SelectionSort(number);
        sort.InsertSort(number);
    }
}
