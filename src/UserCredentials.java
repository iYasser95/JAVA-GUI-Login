
public enum UserCredentials {
        VALID_USERNAME("admin"),
        VALID_PASSWORD("admin123");

        String rawValue = new String();
        UserCredentials(String rawValue) { 
            this.rawValue = rawValue;
        }
}