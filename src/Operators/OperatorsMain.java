package Operators;

import java.io.IOException;

public class OperatorsMain {
    public static void main(String[] args) throws IOException {
        int a = 10;
        int b = 19;
        double c = 7.4;
        float d = 12f;
        Operators operators = new Operators();
        System.out.println(operators.addition(a, b));
        System.out.println(operators.multiplication(a, c, c));
        System.out.println(operators.remainder(a, b));
        System.out.println(operators.compare(a, d));
        System.out.println(operators.logic(3, 2, 1));
        System.out.println(operators.logic(1, 2 ,3));
        System.out.println(operators.logic(15, 9, 9));
        System.out.println(operators.logic(14, 14, 14));
        a += 5;
        System.out.println(a);
        double e = 9.6;
        e *= 5;
        System.out.println(e);
        double f = 21;
        f /= 5;
        System.out.println(f);
        double k = 26;
        k %= 5;
        System.out.println(k);
    }
}
