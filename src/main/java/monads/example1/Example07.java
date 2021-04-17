package monads.example1;

import java.util.Optional;

public class Example07 {
    public static void main(String[] args) {
        mapWhenReturnTypeIsNotOptional();
        mapWhenReturnTypeIsOptional();
        flatMapWhenReturnTypeIsOptional();
        flatMapWhenReturnTypeIsOptionalChaining();
    }

    public static void mapWhenReturnTypeIsNotOptional() {
        Optional<String> name = Optional.of("manish anand");
        Optional<String> upperCaseName = name.map(String::toUpperCase);
        Optional<String> spaceIntoDollar =
                upperCaseName.map((myUpperCaseName) -> myUpperCaseName.replace(" ", "$"));
        spaceIntoDollar.ifPresent(System.out::println);
    }

    /*
    * Here is the problem with map. if the return type of
    * calling method is also a optional than there will be
    * nested optional, and they are hard to deal with.
    * we have to check the value is present or not every time.
    * This can be solve by flat map.
    * */
    public static void mapWhenReturnTypeIsOptional() {
        Optional<String> name = Optional.of("manish anand");
        Optional<Optional<String>> upperCaseName = name.map(Example07::toUpperCase);

        Optional<Optional<String>> nameWithDollar =
            upperCaseName.map((stringOptional -> fillEmptySpaceWithDollar(stringOptional.get())));

        nameWithDollar.ifPresent(stringOptional -> stringOptional.ifPresent(System.out::println));
    }

    /*
    * FlatMap will handler map issue with nested Optionals
    * */
    public static void flatMapWhenReturnTypeIsOptional() {
        Optional<String> name = Optional.of("manish anand");
        Optional<String> upperCaseName = name.flatMap(Example07::toUpperCase);
        Optional<String> nameWithDollar = upperCaseName.flatMap(Example07::fillEmptySpaceWithDollar);
        nameWithDollar.ifPresent(System.out::println);
    }

    public static void flatMapWhenReturnTypeIsOptionalChaining() {
        Optional.of("manish anand")
                .flatMap(Example07::toUpperCase)
                .flatMap(Example07::fillEmptySpaceWithDollar)
                .ifPresent(System.out::println);
    }

    public static Optional<String> toUpperCase(final String name) {
        if(name != null)
            return Optional.of(name.toUpperCase());
        else
            return Optional.empty();
    }

    public static Optional<String> fillEmptySpaceWithDollar(final String stringOptional) {
        return Optional.of(stringOptional.replace(" ", "$"));
    }
}
