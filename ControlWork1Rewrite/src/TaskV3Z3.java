public class TaskV3Z3 {

    public static void main(String[] args) {
        System.out.println(sumDigits(1280));
    }

    public static long sumDigits(int number) {
        if(number < 10) return number;
        return number % 10 + sumDigits(number / 10);
    }
}
