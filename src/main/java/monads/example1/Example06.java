package monads.example1;

import java.util.Optional;

public class Example06 {
    public static Optional<Double> multiplyBy2(double n) {
        return Optional.of(n * 2);
    }

    public static Optional<Double> divideBy3(double n) {
        return Optional.of(n / 3);
    }

    public static Optional<Double> round(double n) {
        return Optional.of((double) Math.round(n));
    }

    public static void main(String[] args) {
        Optional<Optional<Double>> optMap = multiplyBy2(12).map(n -> divideBy3(n));
        Optional<Double> optFlatMap = multiplyBy2(12).flatMap(n -> divideBy3(n));
    }
}

