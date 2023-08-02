package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class PickUp extends JFrame implements ActionListener{
    
    JTable table;
    JButton back , submit;
//    JComboBox bedCombo;
    JCheckBox rb;
    Choice typeofcar;
    
    PickUp(){
        setSize(1300 , 600);
        setLocation(50,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
//        ######Heading Text Filed###########
        JLabel heading = new JLabel("PickUp Service");
        heading.setBounds(500 , 20 , 300 , 40);
        heading.setFont(new Font("Raleway" , Font.BOLD , 25));
        add(heading);
        
//        ######## DEb Text Field########
        JLabel bedtf = new JLabel("Type of Car");
        bedtf.setBounds(50 , 100 , 150 , 30);
        bedtf.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(bedtf);
        
//        ######## Bed Type Combo Field #######
//        String[] values = {"Single Bed " , "Double Bed"};
//        String[] typeoption = {"Single Bed" , "Double Bed"};
        typeofcar = new Choice();
        typeofcar.setBackground(Color.WHITE);
        typeofcar.setBounds(200 , 100 , 200 , 30);
        typeofcar.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(typeofcar);
        
        try{
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from driver");
            
            while(rs.next()){
                typeofcar.add(rs.getString("car_model"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        

        
        
//        #### Add Text to check box #####

//        JLabel text = new JLabel("only display available");
//        text.setBounds(920 , 100 , 200 , 30);
//        text.setFont(new Font("Tahoma" , Font.PLAIN , 20));
//        add(text);
        
        
//        #### Table Heading #####

        JLabel l1 = new JLabel("Name");
        l1.setBounds(150 , 160 , 200 , 30);
        l1.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(l1);
        
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(290 , 160 , 200 , 30);
        l2.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(l2);
        
        
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(450 , 160 , 200 , 30);
        l3.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(l3);
        
        
        
        JLabel l4 = new JLabel("Car Company ");
        l4.setBounds(600 , 160 , 200 , 30);
        l4.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(l4);
        
        
        JLabel l5 = new JLabel("Model");
        l5.setBounds(750 , 160 , 200 , 30);
        l5.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(l5);
        
        JLabel l6 = new JLabel("Available");
        l6.setBounds(900 , 160 , 200 , 30);
        l6.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(l6);
        
        JLabel l7 = new JLabel("Location");
        l7.setBounds(1100 , 160 , 200 , 30);
        l7.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(l7);
        
        
        
//        ##### Create table ####

        table = new JTable();
        table.setBounds(100 , 200 , 1100 , 300);
        table.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        add(table);
        
        try{
            Conn c = new Conn();
            
            String query = "select * from driver";
            
            ResultSet rs = c.s.executeQuery(query);
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        back = new JButton("Back");
        back.setBounds(500 , 500 , 100 , 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        back.addActionListener(this);
        add(back);
        
        submit = new JButton("Submit");
        submit.setBounds(700 , 500 , 100 , 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        submit.addActionListener(this);
        add(submit);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
//                String cartype = typeofcar.getSelectedItem();
                String query = "select * from driver where car_model = '"+typeofcar.getSelectedItem()+"'";
                
                Conn c = new Conn();
                ResultSet rs ;
                
                rs = c.s.executeQuery(query);
                
                
                table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
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
        new PickUp();
    }
}
