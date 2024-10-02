package ForLoop;

import java.io.IOException;
import java.util.ArrayList;

public class ForLoopMain {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(26);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(21);

        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

        ForLoop forLoop = new ForLoop();
        forLoop.forI();
        forLoop.forEachCar(cars);
        forLoop.forEachNumber(arrayList);

    }
}
