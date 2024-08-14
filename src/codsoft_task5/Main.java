package codsoft_task5;

import java.awt.*;

import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {
    private JButton login;
    private Object username;
    private Object password;

    public Main() {
        // Set up the frame
        super("Simple Frame");
        this.getContentPane().setBackground(Color.WHITE); // Set background color
        this.setSize(1400, 1000);
        this.setLayout(null); // Use null layout to set bounds manually
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the labels
        JLabel heading1 = new JLabel("WELCOME TO", SwingConstants.CENTER);
        heading1.setBounds(90, 20, 1000, 50); // Positioning the heading at the top
        heading1.setFont(new Font("Verdana", Font.BOLD, 45)); // Large font size
        heading1.setForeground(Color.YELLOW);
        this.add(heading1);

        JLabel heading = new JLabel("STUDENT MANAGEMENT SYSTEM", SwingConstants.CENTER);
        heading.setBounds(0, 100, 1300, 80); // Positioning the heading at the top
        heading.setFont(new Font("Verdana", Font.BOLD, 66)); // Large font size
        heading.setForeground(new Color(0, 102, 204));
        this.add(heading);

        // Set up the login button
        login = new JButton("Login");
        login.setBounds(510, 530, 200, 60);
        login.setBackground(Color.ORANGE); // Background color
        login.setForeground(Color.WHITE); // Text color
        login.setFont(new Font("Tahoma", Font.BOLD, 38));
        login.addActionListener(this);
        this.add(login);

        // Set up the image
        File imgFile1 = new File("C:\\Users\\Administrator\\Downloads\\icons\\sms1.jfif");
        if (!imgFile1.exists()) {
            System.err.println("File not found: " + imgFile1.getAbsolutePath());
        } else {
            ImageIcon i1 = new ImageIcon(imgFile1.getAbsolutePath());
            Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT); // Scale to desired size
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(400, 200, 400, 300); // Set bounds
            this.add(image);
        }

        // Make the frame visible
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
           
           new Login();}
       
        //else if (username.equals("admin") && password.equals("*N@tw@*;")) 
        else if (username.equals("username") && password.equals("password"))
        {
                System.out.println("Credentials correct. Opening Project frame.");
                setVisible(false); // Hide the current frame
                new StudentManagementSystem(); // Open the Project frame
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
                System.out.println("Invalid credentials");
            }
        
        
        } 
    public static void main(String[] args) {
        new Main(); // Create an instance of Main to display the frame
    }
}
