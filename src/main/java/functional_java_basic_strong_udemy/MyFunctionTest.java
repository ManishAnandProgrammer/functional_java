package functional_java_basic_strong_udemy;

public class MyFunctionTest {
    public static void main(String[] args) {
        withoutChaining();
        withChaining();
    }

    private static void withoutChaining() {
        MyFunction<String, String> trimFunction = value -> value.trim();
        MyFunction<String, String> upperCaseFunction = value -> value.toUpperCase();

        String trimmed = trimFunction.apply(" manish ");
        String upperCased = upperCaseFunction.apply(trimmed);

        System.out.println(upperCased);
    }

    private static void withChaining() {
        MyFunction<String, String> trimFunction = value -> value.trim();
        MyFunction<String, String> upperCaseFunction = value -> value.toUpperCase();

        MyFunction<String, String> trimThanUpperCase = trimFunction.andThen(upperCaseFunction);
        String trimmedAndUpperCased = trimThanUpperCase.apply(" manish ");
        System.out.println(trimmedAndUpperCased);
    }
}
