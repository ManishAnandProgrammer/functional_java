package optimizing_recursion.tailcalls;

import java.math.BigInteger;

public class MainTest {
    public static void main(String[] args) {
        System.out.println(Factorial.factorial(5));

        System.out.println(BigFactorial.factorial(new BigInteger("20000")));
    }
}
