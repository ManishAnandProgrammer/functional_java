package functional_java_basic_strong_udemy;

import java.util.Objects;

public interface MyFunction<T, R> {
    R apply(T value);

    default <V> MyFunction<T, V> andThen(MyFunction<? super R, ? extends V> next) {
        Objects.requireNonNull(next);
        return (T value) -> next.apply(this.apply(value));
    }

    default <V> MyFunction<V, R> compose(MyFunction<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V value) -> apply(before.apply(value));
    }
}
