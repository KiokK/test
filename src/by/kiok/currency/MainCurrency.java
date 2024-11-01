package by.kiok.currency;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class MainCurrency {

    public static void main(String[] args) {
        Currency usd = new Currency("USA dollar", "USD", BigDecimal.ONE, BigDecimal.ONE);
        Currency rub = new Currency("Russian ruble", "RUB", BigDecimal.valueOf(100.00), BigDecimal.ONE);
        Currency byn = new Currency("Belarusian ruble", "BYN", BigDecimal.valueOf(3.18), BigDecimal.ONE);
        HashMap<String, Currency> currencies = new HashMap<>(){{
            put(usd.getAbbreviation(), usd);
            put(rub.getAbbreviation(), rub);
            put(byn.getAbbreviation(), byn);
        }};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Start currency: ");
        String titleStart = scanner.next();
        System.out.print("Start currency amount: ");
        BigDecimal amountStart = BigDecimal.valueOf(scanner.nextInt());
        System.out.print("Target currency: ");
        String titleTarget = scanner.next();

        Currency startCurr = currencies.get(titleStart);
        Currency targetCurr = currencies.get(titleTarget);

        System.out.print("Result target currency amount: ");
        System.out.println(ExchangeRateCalculator.getTargetCount(startCurr, amountStart, targetCurr));
    }
}
