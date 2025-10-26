public class TernarOperator {
    public static void main(String[] args) {
        boolean flag = 6 < 9;

        if(flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        String result = flag ? "YES" : "NO";
        System.out.println(result);

        System.out.println(flag ? "YES" : "NO");
    }
}