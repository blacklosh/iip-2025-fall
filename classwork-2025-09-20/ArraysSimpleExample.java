public class ArraysSimpleExample {
    public static void main(String[] args) {
        int[] array = new int[20];
        for(int i = 0; i < array.length; i++) {
            array[i] = i * i;
        }
        for(int i = array.length-1; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }
}