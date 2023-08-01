package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class SearchRoom extends JFrame implements ActionListener{
    
    JTable table;
    JButton back , submit;
    JComboBox bedCombo;
    JCheckBox rb;
    
    SearchRoom(){
        setSize(1300 , 600);
        setLocation(50,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
//        ######Heading Text Filed###########
        JLabel heading = new JLabel("Search For Room");
        heading.setBounds(500 , 20 , 300 , 40);
        heading.setFont(new Font("Raleway" , Font.BOLD , 25));
        add(heading);
        
//        ######## DEb Text Field########
        JLabel bedtf = new JLabel("Bed Type");
        bedtf.setBounds(50 , 100 , 100 , 30);
        bedtf.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(bedtf);
        
//        ######## Bed Type Combo Field #######
//        String[] values = {"Single Bed " , "Double Bed"};
        String[] typeoption = {"Single Bed" , "Double Bed"};
        bedCombo = new JComboBox(typeoption);
        bedCombo.setBackground(Color.WHITE);
        bedCombo.setBounds(150 , 100 , 200 , 30);
        bedCombo.setFont(new Font("Tahoma" , Font.PLAIN , 20));
//        bedCombo.setSelectedItem(null);
        add(bedCombo);
        
        
        
//        ##### Add Radio Button ###

        rb = new JCheckBox("only display available");
        rb.setBounds(900 , 100 , 250 , 30);
        rb.setFont(new Font("Tahoma" , Font.BOLD , 15));
        rb.setBackground(Color.WHITE);
        add(rb);
        
        
//        #### Add Text to check box #####

//        JLabel text = new JLabel("only display available");
//        text.setBounds(920 , 100 , 200 , 30);
//        text.setFont(new Font("Tahoma" , Font.PLAIN , 20));
//        add(text);
        
        
//        #### Table Heading #####

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(150 , 160 , 200 , 30);
        l1.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(l1);
        
        
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(390 , 160 , 200 , 30);
        l2.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(l2);
        
        
        
        JLabel l3 = new JLabel("Cleaning Status");
        l3.setBounds(600 , 160 , 200 , 30);
        l3.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(l3);
        
        
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(800 , 160 , 200 , 30);
        l4.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(l4);
        
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(1000 , 160 , 200 , 30);
        l5.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(l5);
        
        
        
//        ##### Create table ####

        table = new JTable();
        table.setBounds(100 , 200 , 1100 , 300);
        table.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        add(table);
        
        try{
            Conn c = new Conn();
            
            String query = "select * from rooms";
            
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
                String bedtype = (String)bedCombo.getSelectedItem();
                String query = "select * from rooms where bed_type = '"+bedtype+"'";
                String query2 = "select * from rooms where available = 'Available' AND bed_type = '"+bedtype+"'";
                
                Conn c = new Conn();
                ResultSet rs ;
                
                if(rb.isSelected()){
                    rs = c.s.executeQuery(query2);
                }
                else{
                    rs = c.s.executeQuery(query);
                }
                
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
        new SearchRoom();
    }
}
