package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import net.proteanit.sql.*;

public class UpdateCheck extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JTextField roomtf , nametf , checktf , amountPaidtf , pendingAmounttf;
    JButton check , update , back;
    
    UpdateCheck(){
        setSize(1100 , 600);
        setLocation(150 , 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
//        #### Adding Image #####
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(600 , 70 , 400 , 400);
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
        
        
        JLabel name = new JLabel("Name : ");
        name.setBounds(30 , 240 , 200 , 30);
        name.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(name);
        
        nametf = new JTextField();
        nametf.setBounds(200 , 240 , 200 , 30);
        nametf.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(nametf);
        
        
        JLabel checkInTime = new JLabel("Check In Time : ");
        checkInTime.setBounds(30 , 300 , 200 , 30);
        checkInTime.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(checkInTime);
        
        checktf = new JTextField();
        checktf.setBounds(200 , 300 , 200 , 30);
        checktf.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(checktf);
        
        
        JLabel amountPaid = new JLabel("Amount Paid : ");
        amountPaid.setBounds(30 , 360 , 200 , 30);
        amountPaid.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(amountPaid);
        
        amountPaidtf = new JTextField();
        amountPaidtf.setBounds(200 , 360 , 200 , 30);
        amountPaidtf.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(amountPaidtf);
        
        
        JLabel pendingAmount = new JLabel("Pending Paid : ");
        pendingAmount.setBounds(30 , 420 , 200 , 30);
        pendingAmount.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(pendingAmount);
        
        pendingAmounttf = new JTextField();
        pendingAmounttf.setBounds(200 , 420 , 200 , 30);
        pendingAmounttf.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(pendingAmounttf);
        
        
        check = new JButton("Check");
        check.setBounds(50 , 500 , 100 , 30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBounds(200 , 500 , 100 , 30);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(350 , 500 , 100 , 30);
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
                    nametf.setText(rs.getString("name"));
                    checktf.setText(rs.getString("checkintime"));
                    amountPaidtf.setText(rs.getString("deposite"));
                    
                }
                String query2 = "select * from rooms where roomNumber = '"+roomtf.getText()+"'";
                ResultSet rs2 = c.s.executeQuery(query2);
                
                while(rs2.next()){
                    String amount = rs2.getString("price");
                    int amountPending = Integer.parseInt(amount) - Integer.parseInt(amountPaidtf.getText());
                    pendingAmounttf.setText("" + amountPending);
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == update){
            String number = ccustomer.getSelectedItem();
            String name  = nametf.getText();
            String room = roomtf.getText();
            String checkin = checktf.getText();
            String deposite = amountPaidtf.getText();
            
            try{
                
                Conn c = new Conn();
                
                c.s.executeUpdate("update customer set room = '"+room+"' , name = '"+name+"' , number = '"+number+"' , checkintime = '"+checkin+"' , deposite = '"+deposite+"'");
                
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
        new UpdateCheck();
    }
    
}
