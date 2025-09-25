import java.util.*;

public class LinearSearchInArrayTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (array[i] == 42) {
                System.out.println("YES");
                return;
            }
        }
        System.out.print("NO");

    }
}
