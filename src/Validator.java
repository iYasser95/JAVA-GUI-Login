public class Validator {
    public static String validate(String username, String password) { 
        String message = "";
        if (username.isBlank() && password.isBlank()) { 
            message = PasswordValidation.EMPTY_USERNAME_AND_PASSWORD.rawValue;
        } else if (username.isBlank()) { 
            message = PasswordValidation.EMPTY_USERNAME.rawValue;
        } else if (password.isBlank()) { 
            message = PasswordValidation.EMPTY_PASSWORD.rawValue;
        } else if (!password.equals(UserCredentials.VALID_PASSWORD.rawValue) 
                || !username.equals(UserCredentials.VALID_USERNAME.rawValue)) {
            message = PasswordValidation.INVALID_USERNAME_OR_PASSWORD.rawValue;
        } else if (password.equals(UserCredentials.VALID_PASSWORD.rawValue) 
                && username.equals(UserCredentials.VALID_USERNAME.rawValue)) { 
            message = PasswordValidation.VALID_LOGIN_CREDENTIALS.rawValue;
        } 
        return message;
    }
}
