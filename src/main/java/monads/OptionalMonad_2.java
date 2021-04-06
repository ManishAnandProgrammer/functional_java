package monads;

import java.util.Optional;
import java.util.function.Function;

public class OptionalMonad_2 {
    public static void main(String[] args) {
        Function<Integer, Optional> add = y -> Optional.of(y + 1);
        boolean result = Optional.of(5).flatMap(integer -> Optional.of(integer + 1))
                .equals(add.apply(5)); // returns true
        System.out.println(result);
    }
}
