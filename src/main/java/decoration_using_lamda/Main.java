package decoration_using_lamda;

import java.awt.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        final Camera camera = new Camera();

        final Consumer<String> printCaptured =
                (filterInfo) -> System.out.println(String.format("with %s: %s", filterInfo,
                        camera.capture(new Color(200, 100, 200))));

        printCaptured.accept("no filter");

        camera.setFilter(Color::brighter);

        printCaptured.accept("brighter");

        camera.setFilter(Color::darker);

        printCaptured.accept("darker");

        camera.setFilter(Color::brighter, Color::darker);

        printCaptured.accept("brighter and darker");
    }
}
