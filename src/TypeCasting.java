public class TypeCasting {

    // convert a smaller type to a larger type size:
    // byte -> short -> chart -> int -> long -> float -> double
    double myDouble = 11.8;
    int myInt = (int) myDouble;

    public void printValues() {
        System.out.println(myDouble);
        System.out.println(myInt);
    }
}
