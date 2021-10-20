package functional_java_basic_strong_udemy;

import java.util.Locale;

public class MyFunctionTest {
    public static void main(String[] args) {
//        withoutChaining();
//        withChaining();
//        multipleChaining();
//
        withoutComposing();
        withComposing();
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

    private static void multipleChaining() {
        MyFunction<String, Integer> stringParser = value -> Integer.parseInt(value);
        MyFunction<Integer, Integer> doubleIt = value -> value * 2;

        MyFunction<String, Integer> parseAndDoubleTwoTimes = stringParser.andThen(doubleIt).andThen(doubleIt);
        Integer twoTimesDoubledValue = parseAndDoubleTwoTimes.apply("2");
        System.out.println(twoTimesDoubledValue);
    }

    private static void withoutComposing() {
        MyFunction<String, String> upperCase = value -> value.toUpperCase(Locale.ROOT);
        MyFunction<String, String> trim = value -> value.trim();

        String trimmedValue = trim.apply(" neeraj ");
        String upperCased = upperCase.apply(trimmedValue);

        System.out.println(upperCased);
    }

    private static void withComposing() {
        MyFunction<String, String> upperCase = value -> value.toUpperCase(Locale.ROOT);
        MyFunction<String, String> trim = value -> value.trim();

        MyFunction<String, String> upperCaseTrimmedValue = upperCase.compose(trim);
        String trimmedUpperCaseValue = upperCaseTrimmedValue.apply(" neeraj ");
        System.out.println(trimmedUpperCaseValue);
    }
}
