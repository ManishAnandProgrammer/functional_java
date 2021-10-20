package functional_java_basic_strong_udemy;

public class Currying {
    public static void main(String[] args) {
        MyFunction<Integer, MyFunction<Integer, MyFunction<Integer, Integer>>> myFunction
                = value -> value1 -> value2 -> value * value1 * value2;

        Integer result = myFunction.apply(2).apply(3).apply(4);
        System.out.println(result);
    }
}
