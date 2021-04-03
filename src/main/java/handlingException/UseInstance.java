package handlingException;

public interface UseInstance<T, X extends Throwable> {
    void accept(T value) throws X;
}
