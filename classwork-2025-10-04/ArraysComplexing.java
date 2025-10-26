import java.util.Arrays;
import java.util.Scanner;

public class ArraysComplexing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrN = new int[n];
        for(int i=0; i<n; i++){
            arrN[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arrM = new int[m];
        for(int i=0; i<m; i++){
            arrM[i] = sc.nextInt();
        }

        int[] arrFinal = new int[n+m];
        for(int i=0; i< n; i++){
            arrFinal[i] = arrN[i];
        }
        for(int i=0; i<m; i++){
            arrFinal[n+ i] = arrM[i];
        }
        System.out.println(Arrays.toString(arrFinal));
    }
}
