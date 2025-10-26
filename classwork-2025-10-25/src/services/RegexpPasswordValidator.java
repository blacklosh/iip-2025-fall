package services;

public class RegexpPasswordValidator implements PasswordValidator {

    private String regexp;

    public RegexpPasswordValidator(String r) {
        regexp = r;
    }

    public boolean validate(String password) {
        return password.matches(regexp);
    }

}
