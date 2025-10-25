import java.util.Scanner;

public class TaskV1Z2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        line = line.replace(" ", "");
        line = line.replace("(", "");
        line = line.replace(")", "");
        line = line.replace("-", "");

        boolean succ = line.length() == 10 && check(line);
        System.out.println(succ ? "YES" : "NO");
    }

    public static boolean check(String line) {
        for(char c : line.toCharArray()) {
            if(!('0' <= c && c <= '9')) return false;
        }
        return true;
    }

}
