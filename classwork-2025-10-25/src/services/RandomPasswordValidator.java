package services;


import java.util.Random;

public class RandomPasswordValidator implements PasswordValidator {

    private int chance;

    public RandomPasswordValidator(int c) {
        chance = c;
    }

    public boolean validate(String pass) {
        Random random = new Random();
        return random.nextInt(chance) == 0;
    }

}
