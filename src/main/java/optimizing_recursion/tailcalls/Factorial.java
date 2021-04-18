package optimizing_recursion.tailcalls;

import static optimizing_recursion.tailcalls.TailCalls.call;

public class Factorial{
    public static TailCall factorialTailRec(final int factorial, final int number) {
        if (number == 1)
            return TailCalls.done(factorial);
        else
            return call(() -> factorialTailRec(factorial * number, number - 1));
    }

}