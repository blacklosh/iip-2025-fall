import java.util.Scanner;

public class TaskV4Z4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            int secMax = Integer.MIN_VALUE;
            for(int j = 0; j < m; j++) {
                int a = arr[i][j];
                if(a > max) {
                    secMax = max;
                    max = a;
                } else if(a > secMax) {
                    secMax = a;
                }
            }
            System.out.print(secMax + ", ");
        }
    }
}
