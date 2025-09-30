import java.util.Scanner;

public class ToUpperCaseExample {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String upper = str.toUpperCase();
        String lower = str.toLowerCase();

        System.out.println(upper);
        System.out.println(lower);
    }
}
