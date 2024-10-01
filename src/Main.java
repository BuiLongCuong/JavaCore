import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // TypeCasting
//        TypeCasting typeCasting = new TypeCasting();
//        typeCasting.printValues();

        // Operators
//        int a = 10;
//        int b = 19;
//        double c = 7.4;
//        float d = 12f;
//        Operators operators = new Operators();
//        System.out.println(operators.addition(a, b));
//        System.out.println(operators.multiplication(a, c, c));
//        System.out.println(operators.remainder(a, b));
//        System.out.println(operators.compare(a, d));
//        System.out.println(operators.logic(3, 2, 1));
//        System.out.println(operators.logic(1, 2 ,3));
//        System.out.println(operators.logic(15, 9, 9));
//        System.out.println(operators.logic(14, 14, 14));
//        a += 5;
//        System.out.println(a);
//        double e = 9.6;
//        e *= 5;
//        System.out.println(e);
//        double f = 21;
//        f /= 5;
//        System.out.println(f);
//        double k = 26;
//        k %= 5;
//        System.out.println(k);


        // SwitchCase:
//        SwitchCase switchCase = new SwitchCase();
//        System.out.println(switchCase.resultDay(3));

        // WhileLoop:
//        int whileLoop = 4;
//        while (whileLoop < 10) {
//            System.out.println(whileLoop);
//            whileLoop++;
//        }

        // DoWhile:
//        int doWhile = 1;
//        do {
//            System.out.println("In lần đầu");
//            System.out.println(doWhile);
//            doWhile++;
//        } while (doWhile < 7);


        // for i:
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }

        // forEach:
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(1);
//        arrayList.add(26);
//        arrayList.add(5);
//        arrayList.add(7);
//        arrayList.add(21);
//
//        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
//        for (String car : cars) {
//            System.out.println(car);
//        }
//        for (Integer quantity: arrayList) {
//            System.out.println(quantity);
//        }


        // Break/Continue:
//        for (int i = 0; i < 7; i++) {
//            System.out.println(i);
//            if(i == 3) {
//                break;
//            }
//        }

//        for (int j = 0; j < 7; j++) {
//            if(j == 3) {
//                continue;
//            }
//            System.out.println(j);
//        }

//        int[] number = new int[]{2,26,4,21,3,7,10};
        // BubbleSort:
//        for (int i = 0; i < number.length; i++) {
//            for (int j = 0; j < number.length; j++) {
//                if(number[i] < number[j]) {
//                    int temp = number[i];
//                    number[i] = number[j];
//                    number[j] = temp;
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(number));

        // SelectionSort:
//        for (int i = 0; i < number.length; i++) {
//            int min = i;
//            for (int j = i + 1; j < number.length; j++) {
//                if(number[j] < number[min]) {
//                    min = j;
//                }
//            }
//            int temp = number[i];
//            number[i] = number[min];
//            number[min] = temp;
//        }
//        System.out.println(Arrays.toString(number));

        // InsertSort:
//        for (int i = 0; i < number.length; i++) {
//            for (int j = i; j > 0; j--) {
//                if(number[j] < number[j- 1]) {
//                    int temp = number[j-1];
//                    number[j-1] = number[j];
//                    number[j] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(number));
    }
}