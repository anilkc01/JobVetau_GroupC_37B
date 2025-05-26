import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

public class CompanyRegister {
    public static void main(String[] args) {
        // Create the main window (frame)
        JFrame frame = new JFrame("Job Portal Listing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);

        // Create the main panel with vertical layout and background color
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(173, 216, 230)); // Light blue

        // Create the title label
        JLabel title = new JLabel("Register");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.BLACK);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create role selection panel (Company | Seeker)
        JPanel rolePanel = new JPanel();
        rolePanel.setBackground(new Color(173, 216, 230));
        rolePanel.setLayout(new BoxLayout(rolePanel, BoxLayout.X_AXIS));
        rolePanel.setMaximumSize(new Dimension(300, 30));

        // Company label - selected by default
        JLabel companyLabel = new JLabel("Company");
        companyLabel.setFont(new Font("Arial", Font.BOLD, 15));
        companyLabel.setOpaque(true);
        companyLabel.setBackground(new Color(128, 0, 128)); // Purple for selected
        companyLabel.setForeground(Color.WHITE);
        companyLabel.setHorizontalAlignment(JLabel.CENTER);
        companyLabel.setPreferredSize(new Dimension(150, 30));
        companyLabel.setMaximumSize(new Dimension(150, 30));
        companyLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Seeker label - unselected
        JLabel seekerLabel = new JLabel("Seeker");
        seekerLabel.setFont(new Font("Arial", Font.BOLD, 14));
        seekerLabel.setOpaque(true);
        seekerLabel.setBackground(Color.WHITE);
        seekerLabel.setForeground(Color.BLACK);
        seekerLabel.setHorizontalAlignment(JLabel.CENTER);
        seekerLabel.setPreferredSize(new Dimension(150, 30));
        seekerLabel.setMaximumSize(new Dimension(150, 30));
        seekerLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        // Add both role labels to rolePanel
        rolePanel.add(companyLabel);
        rolePanel.add(seekerLabel);
        rolePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create Company Name field
        JPanel companyPanel = createFieldPanel("Company Name:");
        JTextField companyField = createTextField();
        companyPanel.add(companyField);

        // Create Username field
        JPanel userPanel = createFieldPanel("Username:");
        JTextField userField = createTextField();
        userPanel.add(userField);

        // Create Contact No field
        JPanel contactPanel = createFieldPanel("Contact No:");
        JTextField contactField = createTextField();
        contactPanel.add(contactField);

        // Create Email field
        JPanel emailPanel = createFieldPanel("Email:");
        JTextField emailField = createTextField();
        emailPanel.add(emailField);

        // Create Address field
        JPanel addressPanel = createFieldPanel("Address:");
        JTextField addressField = createTextField();
        addressPanel.add(addressField);

        // Create Password field
        JPanel passPanel = createFieldPanel("Password:");
        JPasswordField passField = createPasswordField();
        passPanel.add(passField);

        // Create Confirm Password field
        JPanel confirmPanel = createFieldPanel("Confirm Password:");
        JPasswordField confirmField = createPasswordField();
        confirmPanel.add(confirmField);

        // Create Register button
        JButton btn = new JButton("Register");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setBackground(new Color(128, 0, 128)); // Purple
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 16));
        btn.setMaximumSize(new Dimension(150, 30));

        // Create text for login prompt with "Login here" in blue
        JLabel text = new JLabel("<html>Already have account? <font color='blue'>Login here</font></html>");
        text.setFont(new Font("Arial", Font.PLAIN, 12));

        // Put the login prompt inside a panel and center it
        JPanel textPanel = new JPanel();
        textPanel.setBackground(new Color(173, 216, 230));
        textPanel.add(text);
        textPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add all components to the main panel with spacing
        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // space after title
        panel.add(rolePanel);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // space after role selection
        panel.add(companyPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(userPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(contactPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(emailPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(addressPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(passPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(confirmPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(textPanel);

        // Add the main panel to the frame and show it
        frame.add(panel);
        frame.setVisible(true);
    }

    // Helper method to create field panel with label
    private static JPanel createFieldPanel(String labelText) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(173, 216, 230));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label = new JLabel(labelText);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(label);

        return panel;
    }

    // Helper method to create a text input field
    private static JTextField createTextField() {
        JTextField textField = new JTextField(20);
        textField.setMaximumSize(new Dimension(300, 30));
        textField.setFont(new Font("Verdana", Font.PLAIN, 14));
        textField.setAlignmentX(Component.LEFT_ALIGNMENT);
        return textField;
    }

    // Helper method to create a password input field
    private static JPasswordField createPasswordField() {
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setMaximumSize(new Dimension(300, 30));
        passwordField.setFont(new Font("Verdana", Font.PLAIN, 14));
        passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);
        return passwordField;
    }
}