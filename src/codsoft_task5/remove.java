
package codsoft_task5;

import java.awt.Choice;
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

public class remove extends JFrame implements ActionListener {
 Choice crollno;
    JButton remove;
    JTable table;
    JButton search;
    remove(){
    
         setSize(1540, 850);
        setTitle("University Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
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

    
        
        remove = new JButton("Remove");
        remove.setBounds(520, 70, 80, 20);
        remove.addActionListener(this);
        add(remove);
        
         setSize(1400, 900); // Match frame size to bounds of image
        setLocation(0, 0);
        setVisible(true);
    }

        public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
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
                    crollno.remove(crollno.getSelectedIndex());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error removing student: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
            }
            }

    private void adjustColumnWidths(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        

   // @Override
   // public void actionPerformed(ActionEvent e) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}

public static void main(String[] args) {
        new remove();
    }
}



