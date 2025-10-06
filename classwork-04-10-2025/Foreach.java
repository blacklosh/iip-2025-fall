public class Foreach {

    public static void main(String[] args) {
        int[] chisla = {1, 7, 15, -2, 0};

        for(int i = 0; i < chisla.length; i++) {
            System.out.println(chisla[i]);
        }

        for(int c : chisla) {
            System.out.println(c);
        }
    }
}
