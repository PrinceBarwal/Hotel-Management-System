package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;


public class CheckOut extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JLabel roomlbl , checkintime;
    JButton checkout , back;
    
    CheckOut(){
        setSize(1100 , 500);
        setLocation(200 , 200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
       

//        ##### Heading Label ####
        
        JLabel heading = new JLabel("Check Out");
        heading.setBounds(100 , 30 , 200 , 40);
        heading.setFont(new Font("Raleway", Font.BOLD , 25));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel customerlbl = new JLabel("Customer ID : ");
        customerlbl.setBounds(30 , 100 , 150 , 30);
        customerlbl.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(customerlbl);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200 , 100 , 200 , 30);
        ccustomer.setBackground(Color.WHITE);
        ccustomer.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(ccustomer);
        
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(410 , 105 , 20 , 20);
        add(image);
        
        JLabel room = new JLabel("Room No. : ");
        room.setBounds(30 , 160 , 120 , 30);
        room.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(room);
        
        roomlbl = new JLabel();
        roomlbl.setBounds(200 , 160 , 100 , 30);
        roomlbl.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(roomlbl);
        
        
        JLabel checkInTime = new JLabel("Checkin Time : ");
        checkInTime.setBounds(30 , 220 , 150 , 30);
        checkInTime.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(checkInTime);
        
        
        checkintime = new JLabel();
        checkintime.setBounds(200 , 220 , 300 , 30);
        checkintime.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(checkintime);
        
        JLabel checkOutTime = new JLabel("Checkout Time : ");
        checkOutTime.setBounds(30 , 280 , 180 , 30);
        checkOutTime.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(checkOutTime);
        
        Date date = new Date();
        
        JLabel datelbl = new JLabel(""+date);
        datelbl.setBounds(200 , 280 , 300 , 30);
        datelbl.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(datelbl);
        
        checkout = new JButton("CheckOut");
        checkout.setBounds(50 , 350 , 150 , 30);
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.BLACK);
        checkout.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        checkout.addActionListener(this);
        add(checkout);
        
        
        back = new JButton("Back");
        back.setBounds(250 , 350 , 100 , 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(500 , 50 , 500 , 400);
        add(image2);
        
        try{
            
            Conn c = new Conn();
            
            String query = "select * from customer";
            
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
                roomlbl.setText(rs.getString("room"));
                checkintime.setText(rs.getString("checkintime"));
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkout){
            String id = ccustomer.getSelectedItem();
            String query = "delete from customer where number = '"+id+"'";
            String query2 = "update rooms set available = 'Available' where roomNumber = '"+roomlbl.getText()+"'";
            
            
            
            try{
                Conn c = new Conn();
                
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "CheckOut Done ");
                
                setVisible(false);
                new Reception().setVisible(true);
            }catch(Exception e){
                e.printStackTrace();
            }  
        }
        else{
            setVisible(false);
            new Reception().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new CheckOut();
    }
    
}
