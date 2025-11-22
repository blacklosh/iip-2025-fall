package cmd;

public class NotEnoughMoneyException extends Exception {

    public NotEnoughMoneyException(int s) {
        super("Не хватило денег совсем чуть-чуть: " + s + "Р");
    }

}
