import services.AlwaysTruePasswordValidator;
import services.PasswordValidator;
import services.RandomPasswordValidator;
import services.RegexpPasswordValidator;

public class Main2 {

    public static void main(String[] args) {
        PasswordValidator[] validators = new PasswordValidator[3];
        validators[0] = new RandomPasswordValidator(2);
        validators[1] = new AlwaysTruePasswordValidator();
        validators[2] = new RegexpPasswordValidator(".*");

        String password = "Hello world";

        boolean success = true;
        for(PasswordValidator validator : validators) {
            success = success && validator.validate(password);
        }

        System.out.println(success);

    }

}
