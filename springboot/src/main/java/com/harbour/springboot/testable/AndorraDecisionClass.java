package com.harbour.springboot.testable;

public class AndorraDecisionClass {
    private TaxCalculator taxCalculator = new TaxCalculator(new VatProvider());

    public boolean toBuyOrNotToBuy(String income) {
        int incomeInt = IntParser.Parse(income);
        return taxCalculator.calculateTax(incomeInt) > 1000;
    }
}
