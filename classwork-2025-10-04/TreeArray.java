import java.util.Scanner;

public class TreeArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = n-1; i >= 0; i-- ){
            print(i,' ');
            print(2*n-1-2*i, '*');
            print(i,' ');
            System.out.println();
        }
    }
    public static void print(int n, char c){
        for (int i = 0; i < n; i++){
            System.out.print(c);
        }
    }
}
