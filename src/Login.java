import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Login implements ActionListener {

    // GUI Elements
    private static JLabel userLabel;
    private static JLabel passwordLabel;
    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel sucessLabel;
    // Validation
    private static String validUsername = "admin";
    private static String validPassword = "admin123";

    public static void main(String[] args) throws Exception {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);
       
        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(135, 90, 80, 25);
        button.addActionListener(new Login());

        sucessLabel = new JLabel("");
        sucessLabel.setBounds(75, 120, 300, 25);
        panel.add(sucessLabel);

        panel.add(button);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userText.getText();
        String password = passwordText.getText();
        String message = "";
        // By default it's an error color.
        sucessLabel.setForeground(Color.red); 
        // User Validation
        if (username.isBlank() && password.isBlank()) { 
            message = PasswordValidation.EMPTY_USERNAME_AND_PASSWORD.rawValue;
        } else if (username.isBlank()) { 
            message = PasswordValidation.EMPTY_USERNAME.rawValue;
        } else if (password.isBlank()) { 
            message = PasswordValidation.EMPTY_PASSWORD.rawValue;
        } else if (!password.equals(validPassword) || !username.equals(validUsername)) {
            message = PasswordValidation.INVALID_USERNAME_OR_PASSWORD.rawValue;
        } else if (password.equals(validPassword) && username.equals(validUsername)) { 
            message = PasswordValidation.VALID_LOGIN_CREDENTIALS.rawValue;
            // Set Successful color.
            sucessLabel.setForeground(Color.green);
        } 
        
        sucessLabel.setText(message);
        
    }
}
