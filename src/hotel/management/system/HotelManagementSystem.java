package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class HotelManagementSystem extends JFrame implements ActionListener  {
    
    JButton next;
    
    HotelManagementSystem(){
        setLayout(null);
        setSize(1366 , 565);
        setLocation(0,50);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1366,565);
        add(image);
        
        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(20,450,700 , 50);
        text.setFont(new Font("Raleway" , Font.BOLD , 40));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        
        next = new JButton("Next");
        next.setBounds(1150 , 450 , 150 , 50);
        next.setBackground(Color.WHITE);
        next.setFont(new Font("serif" , Font.PLAIN , 20));
        next.addActionListener(this);
        image.add(next);
        
        setVisible(true);
         
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            } 
            catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            } 
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login().setVisible(true);
    } 
    
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
