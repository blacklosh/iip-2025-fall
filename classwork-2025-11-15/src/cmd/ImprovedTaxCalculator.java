package cmd;

public class ImprovedTaxCalculator extends TaxCalculator {

    @Override
    public int calculateTax(int sum) throws Exception {
        if(sum < 0) {
            throw new RuntimeException("Invalid income sum!!!");
        }
        return super.calculateTax(sum);
    }
}
