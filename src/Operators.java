public class Operators {

    public int addition(int a, int b) {
        return a + b;
    }

    public double multiplication(int a, double b, double c) {
        return a * b * c;
    }

    public int remainder(int a, int b) {
        return a % b;
    }

    public boolean compare(int a, float b) {
        return a > b;
    }

    public int logic(int a, int b, int c) {
        if(a > b && b > c) {
            return 1;
        } else if (a < c || b > a) {
            return 2;
        } else if (a != b && c == 9){
            return 3;
        } else {
            return 4;
        }
    }
}
