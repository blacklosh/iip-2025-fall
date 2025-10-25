import java.util.Scanner;

public class TaskV4Z1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int original = n;
        int reverse = 0;

        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            reverse = reverse * 10 + digit;
        }

        System.out.println(original == reverse ? "YES" : "NO");
    }
}
