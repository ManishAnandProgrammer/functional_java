package lazy;

import java.util.function.Supplier;

public class EvaluateWithAndWithoutLazy {
    public static boolean evaluate(final int value) {
        System.out.println("Evaluating :: "+value);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value > 100;
    }

    /*
    * This method is going to take 4 seconds
    * */
    public static void eagerEvaluate(final boolean test1, final boolean test2) {
        System.out.println("Eager Evaluate Called..!");
        System.out.println("Accept? :: " + (test1 && test2));
    }

    /*
    * Same thing achieve with lazy evaluation but it
    * will take only 2 seconds.
    * */
    public static void lazyEvaluate(final Supplier<Boolean> test1,
                                     final Supplier<Boolean> test2) {
        System.out.println("Lazy Evaluate Called..!");
        System.out.println("Accept?:: " + (test1.get() && test2.get()));
    }

    public static void main(String[] args) {
        eagerEvaluate(evaluate(5), evaluate(10));
        lazyEvaluate(() -> evaluate(5), () -> evaluate(10));
    }
}
