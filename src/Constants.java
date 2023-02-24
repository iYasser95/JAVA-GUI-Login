public enum Constants {
    USER("User"),
    PASSWORD("Password"),
    LOGIN("Login");

    String rawValue;
    Constants(String rawValue) { 
        this.rawValue = rawValue;
    }
}
