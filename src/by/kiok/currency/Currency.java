package by.kiok.currency;

import java.math.BigDecimal;

public class Currency {

    private String title;
    private String abbreviation;
    private BigDecimal amount;
    private BigDecimal amountMajor;

    public Currency(String title, String abbreviation, BigDecimal amount, BigDecimal amountMajor) {
        this.title = title;
        this.abbreviation = abbreviation;
        this.amountMajor = amountMajor;
        this.amount = amount;
    }

    public BigDecimal getRate(){
        return amount.divide(amountMajor, 2, BigDecimal.ROUND_HALF_DOWN);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmountToMajor(BigDecimal amountMajor) {
        this.amountMajor = amountMajor;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getTitle() {
        return title;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public BigDecimal getAmountMajor() {
        return amountMajor;
    }
}
