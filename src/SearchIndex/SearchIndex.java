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

    public int binarySearch(int[] number, int index) {
        int left = 0;
        int right = number.length - 1;
        while (right >= left) {
            int mid = (right + left)/2;
            if(index == number[mid]) {
                return mid;
            }
            if(index > number[mid]) {
                left = mid + 1;
            }
            if(index < number[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
