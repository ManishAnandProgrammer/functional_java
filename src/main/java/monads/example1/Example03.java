package monads.example1;

import java.util.Optional;
import java.util.function.Function;

public class Example03 {
    public static Optional<Double> multiplyBy2(double n) {
        return Optional.of(n * 2);
    }

    public static Optional<Double> divideBy3(double n) {
        return Optional.of(n / 3);
    }

    public static Optional<Double> round(double n) {
        return Optional.of(Double.valueOf(Math.round(n)));
    }

    public static Optional<Double> applyOperation(double n1) {
        return multiplyBy2(n1)
                .flatMap(n -> divideBy3(n))
                .flatMap(n -> round(n));
    }

    public static void main(String[] args) {
        System.out.println("Output = " + applyOperation(12).get());
    }
}
