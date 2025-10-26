import java.util.Scanner;

public class FactorialFunction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long result = factorial(n);
        System.out.println(result);
    }

    public static long factorial(long n) {
        if(n == 1) return 1;
        return n * factorial(n-1);
    }
}
