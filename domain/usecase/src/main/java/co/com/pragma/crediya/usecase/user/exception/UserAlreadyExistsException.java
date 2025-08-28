package co.com.pragma.crediya.usecase.user.exception;

public class UserAlreadyExistsException extends BusinessException {
    private final String email;

    public UserAlreadyExistsException(String email) {
        super("USER_ALREADY_EXISTS", " A user with that email already exists." + email);
        this.email = email;
    }
    public String getEmail() { return email; }
}
