package ForLoop;

import java.util.ArrayList;

public class ForLoop {

    public void forI() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }

    public void forEachCar(String[] cars) {
        for (String car : cars) {
            System.out.println(car);
        }
    }

    public void forEachNumber(ArrayList<Integer> numbers){
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}
