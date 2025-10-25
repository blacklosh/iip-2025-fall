import java.util.Scanner;

public class TaskV2Z4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int sum = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int k = sc.nextInt();
                if((i+j) % 2 == 1) {
                    sum += k;
                }
            }
        }
        System.out.println(sum);
    }
}
