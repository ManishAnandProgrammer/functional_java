package monads.example1;

public class Example01 {
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
        final double n2 = multiplyBy2(n1);
        final double n3 = divideBy3(n2);
        final double n4 = round(n3);
        return n4;
    }

    public static void main(String[] args) {
        System.out.println("Output = " + applyOperation(12));
    }
}
