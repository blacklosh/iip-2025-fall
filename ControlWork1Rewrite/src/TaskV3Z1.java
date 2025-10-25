import java.util.Scanner;

public class TaskV3Z1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int k = sc.nextInt();
            if(max < k) max = k;
            if(min > k) min = k;
        }

        System.out.println(max + " " + min);

    }
}
