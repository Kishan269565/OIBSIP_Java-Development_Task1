import javax.swing.*; // For JFrame, JButton, JTextField, JLabel, JComboBox, JOptionPane
import java.awt.*; // For GridLayout
import java.awt.event.*; // For FocusAdapter, FocusEvent
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ReservationForm extends JFrame {
    private JTextField nameField, trainNumberField, dateField, fromField, toField;
    private JComboBox<String> classTypeBox;
    private String username; // store logged-in username

    // Constructor takes username from LoginForm
    public ReservationForm(String username) {
        this.username = username;

        setTitle("Reservation Form");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 10, 10));
        setLocationRelativeTo(null);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Train Number:"));
        trainNumberField = new JTextField();
        trainNumberField.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                String trainName = "Express Train"; // Simulated DB lookup
                JOptionPane.showMessageDialog(null, "Train Name: " + trainName);
            }
        });
        add(trainNumberField);

        add(new JLabel("Class Type:"));
        classTypeBox = new JComboBox<>(new String[] { "First Class", "Second Class", "Sleeper" });
        add(classTypeBox);

        add(new JLabel("Date of Journey (YYYY-MM-DD):"));
        dateField = new JTextField();
        add(dateField);

        add(new JLabel("From:"));
        fromField = new JTextField();
        add(fromField);

        add(new JLabel("To:"));
        toField = new JTextField();
        add(toField);

        JButton insertBtn = new JButton("Insert");
        insertBtn.addActionListener(e -> insertReservation());
        add(insertBtn);
    }

    private void insertReservation() {
        int trainNo = Integer.parseInt(trainNumberField.getText());
        String classType = (String) classTypeBox.getSelectedItem();
        String dateOfJourney = dateField.getText();
        String source = fromField.getText();
        String destination = toField.getText();

        // ✅ Your database credentials
        String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12794970";
        String dbUser = "sql12794970";
        String dbPass = "7uwdtxm4TB";

        try {
            // Explicitly load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
                String sql = "INSERT INTO reservations (username, train_no, class_type, date_of_journey, source, destination) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setInt(2, trainNo);
                stmt.setString(3, classType);
                stmt.setString(4, dateOfJourney);
                stmt.setString(5, source);
                stmt.setString(6, destination);

                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Reservation Successful!");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // for direct testing without login
            new ReservationForm("testUser").setVisible(true);
        });
    }
}
