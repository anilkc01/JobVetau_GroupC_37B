import java.awt.*;
import javax.swing.*;

public class CompanyRegister1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Job Portal Listing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 650);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(173, 216, 230));

        JLabel title = new JLabel("Register");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.BLACK);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

       
        JPanel rolePanel = new JPanel();
        rolePanel.setLayout(new BoxLayout(rolePanel, BoxLayout.X_AXIS));
        rolePanel.setBackground(new Color(173, 216, 230));
        rolePanel.setMaximumSize(new Dimension(300, 40));

        JButton companyBtn = new JButton("Company");
        JButton seekerBtn = new JButton("Seeker");

        companyBtn.setBackground(new Color(128, 0, 128));
        companyBtn.setForeground(Color.WHITE);
        seekerBtn.setBackground(Color.WHITE);
        seekerBtn.setForeground(Color.BLACK);

        companyBtn.setFont(new Font("Arial", Font.BOLD, 14));
        seekerBtn.setFont(new Font("Arial", Font.BOLD, 14));

        companyBtn.setFocusPainted(false);
        seekerBtn.setFocusPainted(false);

        rolePanel.add(companyBtn);
        rolePanel.add(seekerBtn);
        rolePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(rolePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 25)));

      
        JPanel formPanel = new JPanel(new CardLayout());

       
        JPanel companyForm = createRegistrationForm("Company Name:");

       
        JPanel seekerForm = createRegistrationForm("Full Name:");

        formPanel.add(companyForm, "Company");
        formPanel.add(seekerForm, "Seeker");

        
        mainPanel.add(formPanel);

       
        CardLayout cl = (CardLayout) (formPanel.getLayout());
        companyBtn.addActionListener(e -> {
            cl.show(formPanel, "company");
            companyBtn.setBackground(new Color(130, 1, 128));
            companyBtn.setForeground(Color.WHITE);
            seekerBtn.setBackground(Color.WHITE);
            seekerBtn.setForeground(Color.BLACK);
        });

        seekerBtn.addActionListener(e -> {
            cl.show(formPanel, "seeker");
            seekerBtn.setBackground(new Color(130, 1, 128));
            seekerBtn.setForeground(Color.WHITE);
            companyBtn.setBackground(Color.WHITE);
            companyBtn.setForeground(Color.BLACK);
        });

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    
    private static JPanel createRegistrationForm(String firstFieldLabel) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(173, 216, 230));

        panel.add(createLabeledField(firstFieldLabel));
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(createLabeledField("Username:"));
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(createLabeledField("Contact No:"));
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(createLabeledField("Email:"));
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(createLabeledField("Address:"));
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(createLabeledPasswordField("Password:"));
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(createLabeledPasswordField("Confirm Password:"));

        JButton registerButton = new JButton("Register");
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setBackground(new Color(128, 0, 128));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Arial", Font.BOLD, 16));
        registerButton.setMaximumSize(new Dimension(150, 30));

        JLabel loginText = new JLabel("<html>Already have account? <font color='blue'>Login here</font></html>");
        loginText.setFont(new Font("Arial", Font.PLAIN, 12));

        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(new Color(173, 216, 230));
        loginPanel.add(loginText);
        loginPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(registerButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(loginPanel);

        return panel;
    }

    private static JPanel createLabeledField(String labelText) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(173, 216, 230));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField textField = new JTextField(20);
        textField.setMaximumSize(new Dimension(300, 30));
        textField.setFont(new Font("Verdana", Font.PLAIN, 14));

        panel.add(label);
        panel.add(textField);
        return panel;
    }

    private static JPanel createLabeledPasswordField(String labelText) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(173, 216, 230));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setMaximumSize(new Dimension(300, 30));
        passwordField.setFont(new Font("Verdana", Font.PLAIN, 14));

        panel.add(label);
        panel.add(passwordField);
        return panel;
    }

}


