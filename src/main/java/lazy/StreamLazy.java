package lazy;

import java.util.List;
import java.util.stream.Stream;

public class StreamLazy {
    private static int length(final String name) {
        System.out.println("Length Method Called..!");
        return name.length();
    }

    private static String toUpper(final String name) {
        System.out.println("To Upper Case..!");
        return name.toUpperCase();
    }

    public static void main(String[] args) {
        List<String> names = List.of("ab", "manish", "kim", "anand", "hello");

        // without terminal operation nothing will happen
        // because steams are lazy
        final String firstNameWith3Letters =
            names.stream()
                 .filter(name -> length(name) == 3)
                 .map(StreamLazy::toUpper)
                 .findFirst()
                 .orElseThrow();

        System.out.println(firstNameWith3Letters);

        // This stream will not do anything unless
        // terminal operations called on it.
        final Stream<String> filterMappedStream =
                names.stream()
                     .filter(name -> length(name) == 3)
                     .map(StreamLazy::toUpper);

        // length and upper method will be called after below
        // print statements because streams are lazy.
        System.out.println("Stream Created..!");
        System.out.println("Filtered And Mapped..!");

        final String firstNameWithThreeLetters =
            filterMappedStream.findFirst().orElseThrow();
        System.out.println(firstNameWithThreeLetters);
    }
}
