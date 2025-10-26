import java.util.Scanner;

public class TrimExample {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String c = sc.nextLine();

        c = c.trim();
        System.out.println(c);
    }

}
