public enum PasswordValidation {
    EMPTY_USERNAME("Please Enter User Name"),
    EMPTY_PASSWORD("Please Enter Password"),
    EMPTY_USERNAME_AND_PASSWORD("Please Enter User name & Password"),
    INVALID_USERNAME_OR_PASSWORD("Invalid Username or Password"),
    VALID_LOGIN_CREDENTIALS("Logged In Successfully");



    String rawValue = new String();
    PasswordValidation(String rawValue) { 
        this.rawValue = rawValue;
    }
}