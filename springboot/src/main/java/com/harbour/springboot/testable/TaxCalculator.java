package com.harbour.springboot.testable;

public class TaxCalculator {

    private final VatProvider vatProvider;

    public TaxCalculator(VatProvider vatProvider) {
        this.vatProvider = vatProvider;
    }

    public double calculatePriceWithoutVat(double price) {
        return price * (1 - vatProvider.getVat());
    }

    public boolean shouldIGoToSki(double income) {
        emitMetric("incorrect metric");
        return !(income < 5000);
    }

    private void emitMetric(String incorrectMetric) {

    }

    public double calculateTax(double income) {
        if (income < 10000) {
            return 0;
        } else if (income < 20000) {
            return income * 0.1;
        } else if (income < 50000) {
            return income * 0.2;
        } else {
            return income * 0.3;
        }
    }
}
