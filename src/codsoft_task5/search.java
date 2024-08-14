
package codsoft_task5;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class search extends JFrame  implements ActionListener{
    Choice crollno;
    JButton search;
     JTable  table;
    search()
    
    {
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

    
    search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
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
             //adjustColumnWidths(table);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       }
}
    public static void main(String[] args) {
        new search();
}
}
