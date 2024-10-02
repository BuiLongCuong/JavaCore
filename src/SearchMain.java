import java.io.IOException;

public class SearchMain {
    public static void main(String[] args) throws IOException {
        int[] number = {1,2,4,6,7,9,12,15,21,26};
        int index = 26;

        SearchIndex searchIndex = new SearchIndex();
        System.out.println(searchIndex.linearSearch(number, index));
        System.out.println(searchIndex.binarySearch(number, index));
    }
}
