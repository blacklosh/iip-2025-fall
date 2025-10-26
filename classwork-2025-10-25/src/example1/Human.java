package example1;

public abstract class Human {

    int age;

    abstract public String getProfession();
    abstract public void sayName();

    public Human() {
        age = 0;
    }

    public void shout() {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }

}
