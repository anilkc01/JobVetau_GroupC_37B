import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import javax.swing.*;

public class gui {
    public static void main(String[] args) {
        System.out.println("Working directory: " + System.getProperty("user.dir"));
        System.out.println("elon.jpg exists? " + new File("elon.jpg").exists());
        System.out.println("elon2.jpg exists? " + new File("elon2.jpg").exists());

        JFrame frame = new JFrame("Job Cha?");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);

        // App icon
        ImageIcon icon = new ImageIcon("elon2.jpg");
        frame.setIconImage(icon.getImage());

        // Image and label
        ImageIcon elonImage = new ImageIcon("elon.jpg");
        JLabel label = new JLabel("Job Cha?", elonImage, JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBounds(300, 20, 200, 250);
        frame.add(label);

        // Username field
        JTextField textField = new JTextField("Enter Username");
        textField.setBounds(50, 300, 200, 30);
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(textField);

        // Password field
        JTextField textField2 = new JTextField("Enter Password");
        textField2.setBounds(50, 350, 200, 30);
        textField2.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(textField2);

        // Clear placeholder text on focus
        addPlaceholderListener(textField, "Enter Username");
        addPlaceholderListener(textField2, "Enter Password");

        // Login button
        JButton button = new JButton("Login");
        button.setBounds(50, 400, 80, 30);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setForeground(Color.BLUE);
        button.setBackground(Color.LIGHT_GRAY);
        frame.add(button);

        frame.setVisible(true);
        System.out.println("Image load status: " + elonImage.getImageLoadStatus());
    }

    
    public static void addPlaceholderListener(JTextField textField, String placeholder) {
        textField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                }
            }
        });
    }
}
