import java.util.Scanner;

public class TaskV3Z2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String[] parts = line.split(" ");
        if(parts.length != 3) {
            System.out.println("NO");
            return;
        }

        boolean succ = check(parts[0]) && check(parts[1]) && check(parts[2]);

        System.out.println(succ ? "YES" : "NO");
    }

    public static boolean check(String name) {
        char first = name.charAt(0);
        if(Character.isLowerCase(first)) return false;

        for(int i = 1; i < name.length(); i++) {
            if(Character.isUpperCase(name.charAt(i))) return false;
        }

        return true;
    }

}
