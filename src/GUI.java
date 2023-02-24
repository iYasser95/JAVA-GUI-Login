import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;
public class GUI {
    public static void main(String[] args) throws Exception {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(panel);

        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);
       
       JTextField userText = new JTextField(20);
       userText.setBounds(100, 20, 165, 25);
       panel.add(userText);

       JLabel passwordLabel = new JLabel("Password");
       passwordLabel.setBounds(10, 50, 80, 25);
       panel.add(passwordLabel);

       JPasswordField passwordText = new JPasswordField();
       passwordText.setBounds(100, 50, 165, 25);
       panel.add(passwordText);

        JButton button = new JButton("Login");
        button.setBounds(130, 90, 80, 25);
        panel.add(button);

       frame.setVisible(true);
    }
}
