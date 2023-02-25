import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Frame extends JFrame implements ActionListener {
    private static JLabel userLabel;
    private static JLabel passwordLabel;
    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel sucessLabel;

    Frame() {
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
        button.addActionListener(this);

        sucessLabel = new JLabel("");
        sucessLabel.setBounds(16, 120, 300, 25);
        sucessLabel.setVerticalAlignment(JLabel.CENTER);
        sucessLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(sucessLabel);

        panel.add(button);

        defaultViewSetup();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void defaultViewSetup() {
        Border defaultBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
        sucessLabel.setForeground(Color.red);
        userText.setBorder(defaultBorder);
        passwordText.setBorder(defaultBorder);
    }

    private static void setErrorBorderOn(LoginFields field) {
        Border errorBorder = BorderFactory.createLineBorder(Color.RED, 1);
        if (field == LoginFields.USERNAME) {
            userText.setBorder(errorBorder);
        } else if (field == LoginFields.PASSWORD) {
            passwordText.setBorder(errorBorder);
        }
    }

    private static void setSuccessfulLabel() {
        sucessLabel.setForeground(Color.GREEN);
    }

    public void validateUser() {
        String username = userText.getText();
        String password = passwordText.getText();
        // Default setup
        defaultViewSetup();
        // User Validation
        validateFields(username, password);
    }

    public void validateFields(String username, String password) {
        String message = Validator.validate(username, password);
        // Show Error / Success message
        sucessLabel.setText(message);

        switch (Validator.validator) {
            case EMPTY_USERNAME_AND_PASSWORD:
                setErrorBorderOn(LoginFields.PASSWORD);
                setErrorBorderOn(LoginFields.USERNAME);
                break;
            case EMPTY_USERNAME:
                setErrorBorderOn(LoginFields.USERNAME);
                break;
            case EMPTY_PASSWORD:
                setErrorBorderOn(LoginFields.PASSWORD);
                break;
            case INVALID_USERNAME_OR_PASSWORD:
                setErrorBorderOn(LoginFields.PASSWORD);
                setErrorBorderOn(LoginFields.USERNAME);
                break;
            case VALID_LOGIN_CREDENTIALS:
                setSuccessfulLabel();
                break;
            case NONE:
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validateUser();
    }
}
