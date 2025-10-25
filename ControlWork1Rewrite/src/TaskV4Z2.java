import java.util.Scanner;

public class TaskV4Z2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        if(!check(line)) {
            System.out.println("Error");
            return;
        }

        System.out.println(line.substring(0, 4) + " " +
                line.substring(4, 8) + " " +
                line.substring(8, 12) + " " +
                line.substring(12));
    }

    public static boolean check(String line) {
        if(line.length() != 16) return false;
        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(!Character.isDigit(c)) return false;
        }
        return true;
    }
}
