import java.util.*;
public class ArrayShiftTask {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }
        for(int i = 1; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.print(arr[0]);
    }
}
