import cmd.ImprovedTaxCalculator;
import cmd.Nologovaya;
import cmd.NotEnoughMoneyException;
import cmd.TaxCalculator;
import cmd.exceptions.*;

import javax.management.ServiceNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NotEnoughMoneyException {
        /*TaxCalculator taxCalculator = new ImprovedTaxCalculator();
        Nologovaya nologovaya = new Nologovaya(taxCalculator);

        List<Integer> income = List.of(100, 1000, 500, 80);

        for(int i : income) {
            if(i < 100) {
                throw new NotEnoughMoneyException(100-i);
            }
        }*/

        /*ServiceOperations operations = new ServiceOperations();

        try {
            operations.processOperation();
        } catch (UserNotFoundServiceException | ProductNotFoundServiceException e) {

        }*/

        int a[] = new int[] {1, 2, 3};

        try {
            System.out.println(a[1]);
            System.out.println("!!!!!!!");
            while (true) {

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Блин, мы за границами массива походу");
            throw new RuntimeException();
        } finally {
            System.out.println("Конец");
        }
    }
}