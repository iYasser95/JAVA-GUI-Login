import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Login implements ActionListener {

    // GUI Elements
    private static JLabel userLabel;
    private static JLabel passwordLabel;
    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel sucessLabel;

    public static void main(String[] args) throws Exception {
        setupView();
    }

    private static void setupView() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel(Constants.USER.rawValue);
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel(Constants.PASSWORD.rawValue);
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button = new JButton(Constants.LOGIN.rawValue);
        button.setBounds(135, 90, 80, 25);
        button.addActionListener(new Login());

        sucessLabel = new JLabel("");
        sucessLabel.setBounds(75, 120, 300, 25);
        panel.add(sucessLabel);

        panel.add(button);

        defaultViewSetup();
        frame.setVisible(true);
    }

    private static void defaultViewSetup() {
        Border defaultBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
        sucessLabel.setForeground(Color.red);
        userText.setBorder(defaultBorder);
        passwordText.setBorder(defaultBorder);
    }

    private static void validateFields() { 
        Border errorBorder = BorderFactory.createLineBorder(Color.RED, 1);
        switch (Validator.validator) {
            case EMPTY_USERNAME_AND_PASSWORD:
                userText.setBorder(errorBorder);
                passwordText.setBorder(errorBorder);
                break;
            case EMPTY_USERNAME:
                userText.setBorder(errorBorder);
                break;
            case EMPTY_PASSWORD:
                passwordText.setBorder(errorBorder);
                break;
            case INVALID_USERNAME_OR_PASSWORD:
                userText.setBorder(errorBorder);
                passwordText.setBorder(errorBorder);
                break;
            case VALID_LOGIN_CREDENTIALS:
                sucessLabel.setForeground(Color.GREEN);
                break;
            case NONE:
                break;
        }
    }
    private static void validateUser() {
        String username = userText.getText();
        String password = passwordText.getText();
        String message = "";

        // Default setup
        defaultViewSetup();
        // User Validation
        message = Validator.validate(username, password);
        // Validate Fields
        validateFields();
        // Show Error / Success message
        sucessLabel.setText(message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validateUser();
    }
}
