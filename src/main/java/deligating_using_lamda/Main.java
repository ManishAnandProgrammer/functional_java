package deligating_using_lamda;

import java.math.BigDecimal;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, BigDecimal> function =
                ticker -> new BigDecimal("6.01");

        // we can delegate calculation of stock calculation on lambda
        // if we want to calculate price throw any external service
        // than we can create a lambda for it, or we can create a class and
        // use that class method as method reference.
        CalculateNav calculateNav = new CalculateNav(function);
        BigDecimal localResult = calculateNav.computeStockWorth("goo", 1000);
        System.out.println(localResult);


        // Here we are using YahooFinance's method getPrice as a function.
        // YahooFinance can be any class which is talking to some microservice.
        CalculateNav calculateNavUsingYahoo = new CalculateNav(YahooFinance::getPrice);
        BigDecimal yahooResult = calculateNavUsingYahoo.computeStockWorth("goo", 1000);

        System.out.println(yahooResult);
    }
}
