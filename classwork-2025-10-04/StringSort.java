import java.util.*;
public class StringSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] array = new String[n];
        for (int i=0; i<array.length; i++) {
            array[i] = sc.nextLine();
        }
        for(int i=0; i<n;i++) {
            for(int j=0; j<i; j++) {
                if (array[j].length()>array[i].length()) {
                    String tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        System.out.print(Arrays.toString(array));
    }
}
