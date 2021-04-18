package optimizing_recursion;

public class Factorial {
    public static int factorialRec(final int number) {
        if(number == 1)
            return 1;
        else
           return number * factorialRec(number - 1);
    }

    public static void main(String[] args) {
        try {
            System.out.println(factorialRec(200000));
        } catch (StackOverflowError exception) {
            System.out.println(exception);
        }

    }
}
