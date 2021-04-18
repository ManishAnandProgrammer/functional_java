package optimizing_recursion.tailcalls;

import static optimizing_recursion.tailcalls.TailCalls.call;

public class Factorial{
    private static TailCall<Integer> factorialTailRec(final int factorial, final int number) {
        if (number == 1)
            return TailCalls.done(factorial);
        else
            return call(() -> factorialTailRec(factorial * number, number - 1));
    }

    public static int factorial(final int number) {
        return factorialTailRec(1, number).invoke();
    }

}