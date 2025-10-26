import services.AlwaysTruePasswordValidator;
import services.PasswordValidator;
import services.RandomPasswordValidator;
import services.RegexpPasswordValidator;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        PasswordValidator validator = new AlwaysTruePasswordValidator();

        System.out.println(validator.validate(UUID.randomUUID().toString()));
        System.out.println(validator.validate(UUID.randomUUID().toString()));
        System.out.println(validator.validate(UUID.randomUUID().toString()));
        System.out.println(validator.validate(UUID.randomUUID().toString()));
        System.out.println(validator.validate(UUID.randomUUID().toString()));
        System.out.println(validator.validate(UUID.randomUUID().toString()));
        System.out.println(validator.validate(UUID.randomUUID().toString()));
        System.out.println(validator.validate(UUID.randomUUID().toString()));
        System.out.println(validator.validate(UUID.randomUUID().toString()));
        System.out.println(validator.validate(UUID.randomUUID().toString()));
        System.out.println(validator.validate(UUID.randomUUID().toString()));
        System.out.println(validator.validate(UUID.randomUUID().toString()));
        System.out.println(validator.validate(UUID.randomUUID().toString()));
    }
}