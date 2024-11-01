package by.kiok.currency;

import java.math.BigDecimal;

public class ExchangeRateCalculator {

    public static BigDecimal getTargetCount(Currency start, BigDecimal startAmount, Currency target) {
        BigDecimal startToMajorRate = start.getRate();
        BigDecimal targetToMajorRate = target.getRate();

        return startToMajorRate.multiply(startAmount)
                .divide(targetToMajorRate,2, BigDecimal.ROUND_HALF_DOWN);
    }
}
