package monads.example1;

import java.util.Optional;

public class Example04 {
    public static void main(String[] args) {
        Optional<Integer> optionInt = Optional.of(10);
        Optional<String> optionStr = optionInt.map(i -> i + "");
        System.out.println("Output = " + optionStr.get());
    }
}
