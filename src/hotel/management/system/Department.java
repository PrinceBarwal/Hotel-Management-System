package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;



public class Department extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    Department(){
        setSize(800 , 500);
        setLocation(300 , 200) ;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        

        
//        ###### Adding Label #########
        JLabel l1 = new JLabel("Department");
        l1.setBounds(150 , 30 , 100 , 20);
        add(l1);
        
        JLabel l2 = new JLabel("Budget");
        l2.setBounds(425 , 30 , 100 , 20);
        add(l2);
        
        
        
        
        table = new JTable();
        table.setBounds(30,60,700,200);
        add(table);
        
        
        try{
            Conn c = new Conn();
            
            String query = "select * from department";
            
            ResultSet rs = c.s.executeQuery(query);
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
//        ###### Add Button #######

        back = new JButton("Back");
        back.setBounds(300 , 400 ,100 , 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception().setVisible(true);
    }
    
    public static void main(String[] args){
        new Department();
    }
    
}
