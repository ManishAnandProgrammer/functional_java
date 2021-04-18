package optimizing_recursion.tailcalls;

public class MainTest {
    public static void main(String[] args) {
        TailCall<Integer> tailCall = Factorial.factorialTailRec(1, 5);
        int result = tailCall.invoke();
        System.out.println(result);
    }
}
