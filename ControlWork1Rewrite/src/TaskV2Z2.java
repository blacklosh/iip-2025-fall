import java.util.Scanner;

public class TaskV2Z2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        if(line.length() != 8) {
            System.out.println("NO");
            return;
        }

        if(line.charAt(2) != ':' || line.charAt(5) != ':') {
            System.out.println("NO");
            return;
        }

        String[] parts = line.split(":");

        if(parts.length != 3) {
            System.out.println("NO");
            return;
        }

        boolean succ = checkPart(parts[0], 23) &&
                checkPart(parts[1], 59) &&
                checkPart(parts[2], 59);

        System.out.println(succ ? "YES" : "NO");
    }

    public static boolean checkPart(String part, int max) {
        if(part.length() != 2) return false;
        if(!('0' <= part.charAt(0) && part.charAt(0) <= '9')) return false;
        if(!('0' <= part.charAt(1) && part.charAt(1) <= '9')) return false;
        int num = Integer.parseInt(part);
        return num >= 0 && num <= max;
    }
}
