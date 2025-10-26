package services;

public class AlwaysTruePasswordValidator implements PasswordValidator{
    @Override
    public boolean validate(String password) {
        return true;
    }
}
