import java.util.Scanner;

public class ArrayBinarySearchTask {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int left = 0;
        int right = n-1;
        while(left <= right) {
            int middle = left + (right-left)/2;
            if(array[middle] == 42) {
                System.out.println("YES");
                return;
            } else if(array[middle] < 42) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        System.out.println("NO");
    }
}
