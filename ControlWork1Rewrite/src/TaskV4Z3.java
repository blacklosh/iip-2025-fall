import java.util.Scanner;

public class TaskV4Z3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        if(!check(line)) {
            System.out.println("NO");
            return;
        }

        char[] chars = line.toCharArray();

        boolean succ = chars[0] + chars[1] + chars[2] ==
                    chars[3] + chars[4] + chars[5];

        System.out.println(succ ? "YES" : "NO");
    }

    public static boolean check(String line) {
        if(line.length() != 6) return false;
        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(!Character.isDigit(c)) return false;
        }
        return true;
    }
}
