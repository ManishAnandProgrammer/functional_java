package monads.example1;

import java.util.Optional;

public class Example05 {
    public static Double multiplyBy2(double n) {
        return n * 2;
    }

    public static Double divideBy3(double n) {
        return n / 3;
    }

    public static Double round(double n) {
        return (double) Math.round(n);
    }

    public static Optional<Double> applyOperation(double n1) {
        return Optional.of(n1).map(n -> multiplyBy2(n1)).map(n -> divideBy3(n)).map(n -> round(n));
    }

    public static void main(String[] args) {
        System.out.println("Output = " + applyOperation(12).get());
    }
}

