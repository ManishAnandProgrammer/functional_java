package functional_java_basic_strong_udemy;

import java.util.Locale;

public class MyFunctionComposeMethodTest {
    public static void main(String[] args) {
        withoutComposing();
        withComposing();
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
