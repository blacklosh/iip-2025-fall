import java.util.Scanner;

public class GcdLcmFunctions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("GCD:");
        System.out.println(gcd(a, b));
        System.out.println("LCM:");
        System.out.println(lcm(a, b));
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

}
