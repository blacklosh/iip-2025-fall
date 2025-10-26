package example1;

public class Superhuman extends Human {

    private String superPower;

    @Override
    public String getProfession() {
        return "HERO";
    }

    @Override
    public void sayName() {
        System.out.println("IM SUPERHUMAN!");
    }
}
