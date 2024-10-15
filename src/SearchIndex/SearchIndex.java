package SearchIndex;

public class SearchIndex {
    public int linearSearch(int[] number,int index) {
        for (int i = 0; i < number.length; i++) {
            if(number[i] == index) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int[] numbers, int number) {
        int left = 0;
        int right = numbers.length - 1;
        while (right >= left) {
            int mid = (right + left)/2;
            if(number == numbers[mid]) {
                return mid;
            }
            if(number > numbers[mid]) {
                left = mid + 1;
            }
            if(number < numbers[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
