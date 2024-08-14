package codsoft_task5;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentManagementSystem extends JFrame  implements ActionListener{
    
    Choice crollno;
  
    JTable  table;
    JButton search ,print,update,add,cancel,remove,display;
    
    StudentManagementSystem() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM student1");
            
            while (rs.next()) {
                crollno.add(rs.getString("rollno")); // Add roll number to JComboBox
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error accessing student details: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
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
        jsp.setBounds(0,100,1305,600);
        add(jsp);
        
       // JScrollPane jsp = new JScrollPane(table);
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        search.setBackground(Color.BLUE);
        search.setForeground(Color.yellow);
        search.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(search);
   
         add = new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add.setBackground(Color.BLUE);
        add.setForeground(Color.yellow);
        add.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(add);
        
        
         update = new JButton("Edit");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        update.setBackground(Color.BLUE);
        update.setForeground(Color.yellow);
        update.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(update);
        
        remove = new JButton("Remove");
        remove.setBounds(520, 70, 80, 20);
       remove.addActionListener(this);
       remove.setBackground(Color.BLUE);
        remove.setForeground(Color.yellow);
        remove.setFont(new Font("Serif", Font.BOLD, 13));
        add(remove);
        
         print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        print.setBackground(Color.BLUE);
        print.setForeground(Color.yellow);
        print.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(print);

    
         cancel = new JButton("Exit");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        cancel.setBackground(Color.BLUE);
        cancel.setForeground(Color.yellow);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(cancel);


// Inside the constructor
display = new JButton("Display");
display.setBounds(620, 70, 80, 20);
display.addActionListener(this);
display.setBackground(Color.BLUE);
        display.setForeground(Color.yellow);
        display.setFont(new Font("Tahoma", Font.BOLD, 12));
add(display);

        
        
        
        
       
        setSize(1400, 1000);
        setLocation(50, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == search)
        {
          String query =" select * from student1 where rollno = '"+crollno.getSelectedItem()+"'";  
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
             adjustColumnWidths(table);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       }
        
        
        else if(ae.getSource() == add)
        {
            
            new AddStudent();
        }
        else if(ae.getSource() == update)
        {
            
            new UpdateStudent();
        }
        
         else if(ae.getSource() == print)
        {
            try
            {
              table.print() ; 
            }catch(Exception e )
            {
                e.printStackTrace();
            }
        }
        
        else if (ae.getSource() == remove) {
        String rollno = crollno.getSelectedItem();
        if (rollno == null || rollno.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a roll number to remove.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove the student with roll number " + rollno + "?", "Confirm Removal", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Conn c = new Conn();
                String query = "DELETE FROM student1 WHERE rollno = '" + rollno + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                // Refresh the Choice and JTable
                crollno.remove(crollno.getSelectedIndex());
                //refreshTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error removing student: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
        
       
       
        }
    else if (ae.getSource() == display) {
            SwingUtilities.invokeLater(() -> new Student());
        } 
        else
        {
            setVisible(false);
        }
        
        
        
        
    }
    
    public static void main(String[] args) {
        new StudentManagementSystem();
    }

    private void adjustColumnWidths(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}