package monads.example1;

public class Example02 {
    public static double multiplyBy2(double n) {
        return n * 2;
    }

    public static double divideBy3(double n) {
        return n / 3;
    }

    public static double round(double n) {
        return Math.round(n);
    }

    public static double applyOperation(double n1) {
        return round(divideBy3(multiplyBy2(n1)));
    }

    public static void main(String[] args) {
        System.out.println("Output = " + applyOperation(12));
    }
}
