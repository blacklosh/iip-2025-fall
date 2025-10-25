public class TaskV1Z3 {

    public static void main(String[] args) {
        System.out.println(roundToN(Math.PI, 3));
    }

    public static double roundToN(double number, int precision) {
        double scale = Math.pow(10, precision);
        return Math.round(number * scale) / scale;
    }
}
