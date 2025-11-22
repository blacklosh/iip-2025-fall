import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strochka = sc.nextLine();
        Map<Character, Integer> spisok = new HashMap<>();
        for(char bukva : strochka.toCharArray()) {
            if (spisok.containsKey(bukva)) {
                spisok.put(bukva, spisok.get(bukva) + 1);
            } else {
                spisok.put(bukva, 1);
            }
        }
        for(Map.Entry pair : spisok.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }
}
