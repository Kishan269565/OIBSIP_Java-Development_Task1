import javax.swing.*; // JFrame, JLabel, JTextField, JButton, JOptionPane
import java.awt.*; // FlowLayout

public class CancellationForm extends JFrame {
    private JTextField pnrField;

    public CancellationForm() {
        setTitle("Cancel Reservation");
        setSize(300, 150);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new JLabel("Enter PNR Number:"));
        pnrField = new JTextField(15);
        add(pnrField);

        JButton cancelBtn = new JButton("Cancel Ticket");
        cancelBtn.addActionListener(e -> cancelTicket());
        add(cancelBtn);
    }

    private void cancelTicket() {
        String pnr = pnrField.getText();
        int response = JOptionPane.showConfirmDialog(
                this,
                "Confirm Cancellation for PNR: " + pnr + "?",
                "Confirm",
                JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Ticket Cancelled Successfully.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CancellationForm().setVisible(true);
        });
    }
}
