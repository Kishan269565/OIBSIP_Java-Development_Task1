import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginForm() {
        setTitle("Online Reservation - Login");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(e -> authenticate());
        add(loginBtn);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> System.exit(0));
        add(cancelBtn);
    }

    private void authenticate() {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        if ("admin".equals(user) && "1234".equals(pass)) {
            new ReservationForm(user).setVisible(true); // Pass username here
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Login");
        }
    }

    public static void main(String[] args) {
        new LoginForm().setVisible(true);
    }
}
