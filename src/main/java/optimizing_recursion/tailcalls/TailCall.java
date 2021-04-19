package optimizing_recursion.tailcalls;

import java.util.stream.Stream;

public interface TailCall<T> {

    TailCall<T> apply();

    default  boolean isComplete() {
        return  false;
    }

    default T result() {
        throw new Error("Not Implemented Yet..!");
    }

    default T invoke() {
        return Stream.iterate(this, TailCall::apply)
                     .filter(TailCall::isComplete)
                     .findFirst()
                     .get()
                     .result();
    }

    /**
     * invoke without stream
        default T invoke() {
            TailCall<T> tailCall = this;
            while(!tailCall.isComplete()) {
                tailCall = tailCall.apply();
            }
            return tailCall.result();
        }
     */

}
