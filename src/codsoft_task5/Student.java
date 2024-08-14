
package codsoft_task5;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Student extends JFrame  {
    
    Choice crollno;
  
    JTable  table;
    
    Student() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Individual Student Details");
        heading.setBounds(400, 5, 600, 100);
        heading.setFont(new Font("Tahoma", Font.BOLD, 40));
        add(heading);
        
        table = new JTable();
       
          
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM student1");
            
           table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error accessing student details: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
         
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,90,1310,600);
        add(jsp);
     
        setSize(1320, 1000);
        setLocation(10, 90);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Student();
    }

    private void adjustColumnWidths(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}