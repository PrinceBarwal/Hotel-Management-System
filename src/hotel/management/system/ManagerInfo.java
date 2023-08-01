package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener {
    
    JTable table;
    JButton back;
    
    ManagerInfo(){
        setSize(1300 , 600);
        setLocation(50,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(70 , 30 , 100 , 30);
        l1.setFont(new Font("Raleway" , Font.BOLD , 20));
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(240 , 30 , 50 ,30);
        l2.setFont(new Font("Raleway" , Font.BOLD , 20));
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(370 , 30 , 100 , 30);
        l3.setFont(new Font("Raleway" , Font.BOLD , 20));
        add(l3);
        
        
        JLabel l4 = new JLabel("Job");
        l4.setBounds(520 , 30 , 100 , 30);
        l4.setFont(new Font("Raleway" , Font.BOLD , 20));
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(690 , 30 , 100 , 30);
        l5.setFont(new Font("Raleway" , Font.BOLD , 20));
        add(l5);
        
        
        JLabel l6 = new JLabel("Phone");
        l6.setBounds(830 , 30 , 100 , 30);
        l6.setFont(new Font("Raleway" , Font.BOLD , 20));
        add(l6);
        
        
        JLabel l7 = new JLabel("Email Id");
        l7.setBounds(970 , 30 , 100 , 30);
        l7.setFont(new Font("Raleway" , Font.BOLD , 20));
        add(l7);
        
        
        JLabel l8 = new JLabel("Aadhar No.");
        l8.setBounds(1120 , 30 , 200 , 30);
        l8.setFont(new Font("Raleway" , Font.BOLD , 20));
        add(l8);
  


        table = new JTable();
        table.setBounds(50 , 70 , 1200 , 400);
        add(table);
        
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where job='Manager'";
            
            ResultSet rs = c.s.executeQuery(query);
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBounds(600 , 500 , 100 , 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
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
        new ManagerInfo();
    }
    
}
