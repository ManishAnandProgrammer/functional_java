package memoization;

import java.util.function.Function;

public class DzoneMemoizerTest {

    private final Function<Integer, Integer> f = integer -> longCalculation(integer);

    private final Function<Integer, Integer> g = Memoizer.memoize(f);

    public static void main(String[] args) {
        DzoneMemoizerTest test = new DzoneMemoizerTest();
        test.automaticMemoizationExample();
    }

    private Integer longCalculation(Integer x) {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException ignored) {
        }
        return x * 2;
    }


    public void automaticMemoizationExample() {
        long startTime = System.currentTimeMillis();
        Integer result1 = g.apply(5);
        long time1 = System.currentTimeMillis() - startTime;
        startTime = System.currentTimeMillis();
        Integer result2 = g.apply(5);
        long time2 = System.currentTimeMillis() - startTime;
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(time1);
        System.out.println(time2);
    }

}
