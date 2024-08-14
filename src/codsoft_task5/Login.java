
package codsoft_task5;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,cancel;//global decleration of login and cancel button 
    JTextField tfusername,tfpassword;//global decleration
    
    Login()
{
    getContentPane().setBackground(Color.white);
    
    setLayout(null);
    JLabel lblusername = new JLabel("Username");
    lblusername.setBounds(40,20,100,20);
    add(lblusername);
    
     tfusername = new JTextField();//global decleration above
    tfusername.setBounds(150,20,150,20);
    add(tfusername);
    
    JLabel lblpassword = new JLabel("Password");
    lblpassword.setBounds(40,70,100,20);
    add(lblpassword);
    
    tfpassword = new JPasswordField();
    tfpassword.setBounds(150,70,150,20);
    add(tfpassword);
    
    login = new JButton("Login");
    login.setBounds(40,170,120,30);
    login.setBackground(Color.BLUE);
    login.setForeground(Color.white);
    login.setFont(new Font("Tahoma", Font.BOLD ,15));
    login.addActionListener(this);
    add(login);
    
    cancel = new JButton("cancel");
    cancel.setBounds(180,170,120,30);
    cancel.setBackground(Color.BLUE);
    cancel.setForeground(Color.white);
    cancel.setFont(new Font("Tahoma", Font.BOLD ,15));
    cancel.addActionListener(this);
    add(cancel);
    
    
        
        File imgFile1 = new File("C:\\Users\\Administrator\\Downloads\\icons\\second.jpg");
        if (!imgFile1.exists()) {
            System.err.println("File not found: " + imgFile1.getAbsolutePath());
        } else {
            ImageIcon i1 = new ImageIcon(imgFile1.getAbsolutePath());
            Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // Scale to desired size
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(350, 0, 200, 200); // Set bounds
            this.add(image);
        }
        
        
    
setSize(600,300);
setLocation(500,250);
setVisible(true);
}
    
        
public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String correctUsername = System.getenv("DB_USERNAME"); // Get from environment
            String correctPassword = System.getenv("DB_PASSWORD"); // Get from environment
            
            String inputUsername = tfusername.getText(); // Get username from input field
            String inputPassword = new String(tfpassword.getText()); // Get password from input field
            
            // Validate credentials
            if (inputUsername.equals(correctUsername) && inputPassword.equals(correctPassword)) {
                System.out.println("Credentials correct. Opening Project frame.");
                setVisible(false); // Hide the current frame
                new StudentManagementSystem().setVisible(true); // Open the Project frame
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
                System.out.println("Invalid credentials");
            }     
        }
         

else if (ae.getSource()==cancel)    
{
setVisible(false);
}
       
           }
    
public static void main(String[]args)
{
new Login();
}
}
