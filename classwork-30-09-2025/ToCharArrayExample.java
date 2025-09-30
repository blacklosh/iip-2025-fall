import java.util.Arrays;

public class ToCharArrayExample {

    public static void main(String[] args) {
        String str = "Hello world from java";

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for(char c : chars) {
            System.out.print(c);
        }
    }
}
