package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;



public class Room extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    Room(){
        setSize(1300 , 600);
        setLocation(50 , 100) ;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
//        ####### Add image ########
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(650 , 10 , 600 , 500);
        add(image);
        
        
//        ###### Adding Label #########
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(15 , 30 , 100 , 20);
        add(l1);
        
        JLabel l2 = new JLabel("Available");
        l2.setBounds(125 , 30 , 100 , 20);
        add(l2);
        
        JLabel l3 = new JLabel("Status");
        l3.setBounds(230 , 30 , 100 , 20);
        add(l3);
       
        JLabel l4 = new JLabel("Price");
        l4.setBounds(380 , 30 , 100 , 20);
        add(l4);
       
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(450 , 30 , 100 , 20);
        add(l5);
        
        
        table = new JTable();
        table.setBounds(10,60,550,200);
        add(table);
        
        
        try{
            Conn c = new Conn();
            
            String query = "select * from rooms";
            
            ResultSet rs = c.s.executeQuery(query);
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
//        ###### Add Button #######

        back = new JButton("Back");
        back.setBounds(250 , 500 , 100 , 30);
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
        new Room();
    }
    
}
