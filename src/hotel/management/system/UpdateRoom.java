package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import net.proteanit.sql.*;

public class UpdateRoom extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JTextField roomtf , availabilitytf , cleaningStatustf ;
    JButton check , update , back;
    
    UpdateRoom(){
        setSize(1100 , 600);
        setLocation(150 , 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
//        #### Adding Image #####
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450 , 70 , 600 , 400);
        add(image);
        
        
//        ####### Add Heading#####
        JLabel heading = new JLabel("Update Status");
        heading.setBounds(100 , 30 , 300 , 40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Raleway" , Font.BOLD , 30));
        add(heading);
        
        
//        ##### Adding Form Field ####
        JLabel customerlbl = new JLabel("Customer ID : ");
        customerlbl.setBounds(30 , 120 , 150 , 30);
        customerlbl.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(customerlbl);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200 , 120 , 200 , 30);
        ccustomer.setBackground(Color.WHITE);
//        ccustomer.setSelectedItem(null);
        ccustomer.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(ccustomer);
        
        
        try{
            
            Conn c = new Conn();
            
            String query = "select * from customer";
            
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JLabel room = new JLabel("Room No. : ");
        room.setBounds(30 , 180 , 200 , 30);
        room.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(room);
        
        roomtf = new JTextField();
        roomtf.setBounds(200 , 180 , 200 , 30);
        roomtf.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(roomtf);
        
        
        JLabel name = new JLabel("Availablity : ");
        name.setBounds(30 , 240 , 200 , 30);
        name.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(name);
        
        availabilitytf = new JTextField();
        availabilitytf.setBounds(200 , 240 , 200 , 30);
        availabilitytf.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(availabilitytf);
        
        
        JLabel checkInTime = new JLabel("Cleaning Status  : ");
        checkInTime.setBounds(30 , 300 , 200 , 30);
        checkInTime.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(checkInTime);
        
        cleaningStatustf = new JTextField();
        cleaningStatustf.setBounds(200 , 300 , 200 , 30);
        cleaningStatustf.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(cleaningStatustf);
        
        
        
        
        
        check = new JButton("Check");
        check.setBounds(50 , 400 , 100 , 30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBounds(300 , 400 , 100 , 30);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(180 , 500 , 100 , 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == check){
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            
            try{
                Conn c = new Conn();
                
                ResultSet rs = c.s.executeQuery(query);
                
                while(rs.next()){
                    roomtf.setText(rs.getString("room"));
                }
                String query2 = "select * from rooms where roomNumber = '"+roomtf.getText()+"'";
                ResultSet rs2 = c.s.executeQuery(query2);
                
                while(rs2.next()){
                    availabilitytf.setText(rs2.getString("available"));
                    cleaningStatustf.setText(rs2.getString("status"));
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == update){
            String number = ccustomer.getSelectedItem();
//            String name  = nametf.getText();
            String room = roomtf.getText();
            String availabiliy = availabilitytf.getText();
            String cleaningStatus = cleaningStatustf.getText();
            
            try{
                
                Conn c = new Conn();
                
                c.s.executeUpdate("update rooms set  available = '"+availabiliy+"' , status = '"+cleaningStatus+"' where roomNumber = '"+room+"' ");
                
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                
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
        new UpdateRoom();
    }
    
}
