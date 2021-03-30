package deligating_using_lamda;

import java.math.BigDecimal;

public class YahooFinance {
    public static BigDecimal getPrice(final String ticker) {
        try {
            return new BigDecimal("5.55");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}