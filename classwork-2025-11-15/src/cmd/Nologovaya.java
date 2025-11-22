package cmd;

import java.util.List;

public class Nologovaya {

    public TaxCalculator taxCalculator;

    public Nologovaya(TaxCalculator t) {
        taxCalculator = t;
    }

    public int howMuchMoneyIMust(List<Integer> incomes) throws Exception {
        int sum = 0;
        for(int i : incomes) {
            sum += taxCalculator.calculateTax(i);
        }
        return sum;
    }

}
