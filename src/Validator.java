public class Validator {

    static PasswordValidation validator = PasswordValidation.NONE;
    public static String validate(String username, String password) { 
        String message = "";
        if (username.isBlank() && password.isBlank()) { 
            message = PasswordValidation.EMPTY_USERNAME_AND_PASSWORD.rawValue;
            validator = PasswordValidation.EMPTY_USERNAME_AND_PASSWORD;
        } else if (username.isBlank()) { 
            message = PasswordValidation.EMPTY_USERNAME.rawValue;
            validator = PasswordValidation.EMPTY_USERNAME;
        } else if (password.isBlank()) { 
            message = PasswordValidation.EMPTY_PASSWORD.rawValue;
            validator = PasswordValidation.EMPTY_PASSWORD;
        } else if (!password.equals(UserCredentials.VALID_PASSWORD.rawValue) 
                || !username.equals(UserCredentials.VALID_USERNAME.rawValue)) {
            message = PasswordValidation.INVALID_USERNAME_OR_PASSWORD.rawValue;
            validator = PasswordValidation.INVALID_USERNAME_OR_PASSWORD;
        } else if (password.equals(UserCredentials.VALID_PASSWORD.rawValue) 
                && username.equals(UserCredentials.VALID_USERNAME.rawValue)) { 
            message = PasswordValidation.VALID_LOGIN_CREDENTIALS.rawValue;
            validator = PasswordValidation.VALID_LOGIN_CREDENTIALS;
        } 
        return message;
    }
}
