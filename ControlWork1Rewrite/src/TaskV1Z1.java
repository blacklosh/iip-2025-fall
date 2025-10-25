import java.util.Scanner;

public class TaskV1Z1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n <= 0) {
            System.out.println("Error");
            return;
        }

        int sum = 0;
        for(int i = 1; i <= n; i++) {
            if(i % 2 == 0 || i % 7 == 0) sum += i;
        }
        System.out.println(sum);
    }
}
