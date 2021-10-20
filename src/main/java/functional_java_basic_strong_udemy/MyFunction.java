package functional_java_basic_strong_udemy;

import java.util.Objects;

public interface MyFunction<T, R> {
    R apply(T value);

    default <V> MyFunction<T, V> andThen(MyFunction<? super R, ? extends V> next) {
        Objects.requireNonNull(next);
        return value -> next.apply(this.apply(value));
    }
}
