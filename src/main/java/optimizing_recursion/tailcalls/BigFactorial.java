package optimizing_recursion.tailcalls;

import java.math.BigInteger;

import static optimizing_recursion.tailcalls.TailCalls.call;
import static optimizing_recursion.tailcalls.TailCalls.done;

public class BigFactorial {
    private static BigInteger decrement(final BigInteger number) {
        return number.subtract(BigInteger.ONE);
    }

    private static BigInteger multiply(final BigInteger first,
                                      final BigInteger second) {
        return first.multiply(second);
    }

    private static final BigInteger ONE = BigInteger.ONE;

    private static TailCall<BigInteger> factorialTailRec(final BigInteger factorial,
                                                         final BigInteger number) {
        if(number.equals(ONE))
            return done(factorial);
        else
            return call(() -> factorialTailRec(multiply(factorial, number), decrement(number)));
    }

    public static BigInteger factorial(final BigInteger number) {
        return factorialTailRec(ONE, number).invoke();
    }
}
