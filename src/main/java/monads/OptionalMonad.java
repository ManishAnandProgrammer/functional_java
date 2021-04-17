package monads;

import java.util.Optional;

public class OptionalMonad {
    public static void main(String[] args) {

        Optional<Integer> result =
                addTwoNumbersWithMonad(Optional.of(5), Optional.of(5));

        if(result.isPresent()) {
            System.out.println("The Result Is :: " + result.get());
        } else {
            System.out.println("No Result Found..!");
        }
    }

    public static Optional<Integer> addTwoNumbersWithoutMonad
            (final Optional<Integer> value1, final Optional<Integer> value2) {

        if(value1.isPresent() && value2.isPresent()) {
            return Optional.of(value1.get() + value2.get());
        }

        return Optional.empty();
    }

    public static Optional<Integer> addTwoNumbersWithMonad
            (final Optional<Integer> value1, final Optional<Integer> value2) {

        return value1.flatMap(first ->
                value2.flatMap(second -> Optional.of(first + second)));
    }
}
