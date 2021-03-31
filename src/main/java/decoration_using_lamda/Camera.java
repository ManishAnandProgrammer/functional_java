package decoration_using_lamda;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Camera {
    private Function<Color, Color> filter;

    public Camera() {
        setFilter();
    }

    public void setFilter(final Function<Color, Color>... filters) {
        filter =
           Stream.of(filters)
                 .reduce((filter, next) -> filter.compose(next))
                 .orElseGet(Function::identity);
    }

    public Color capture(final Color inputColor) {
        final Color processedColor = filter.apply(inputColor);

        return processedColor;
    }
}
