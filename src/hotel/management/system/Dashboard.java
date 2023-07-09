package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
    
    JMenuItem addemployee;
    
    Dashboard(){
        setSize(1370 , 720);
        setLayout(null);
        
        
        
//        ######## Add Background Image#########
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1370, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0 ,0 ,1370 , 720);
        add(image);
        
//        ########## Add text on the background image ##########
        JLabel text = new JLabel("THE TAG GROUP WELCOME YOU");
        text.setBounds(370 , 80 , 700 , 60);
        text.setFont(new Font("Tahoma" , Font.PLAIN , 46));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        
        
//        ########## Add Menu bar to Dashboard  ############
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1370 , 40);
        image.add(mb);
        
        
//        ######## Add Menu Buttons #########
    
        JMenu hotel = new JMenu("Hotel Management");
        hotel.setForeground(Color.RED);
        mb.add(hotel);
        
        
        JMenu admin = new JMenu("Admin");
        admin.setForeground(Color.BLUE);
        mb.add(admin);
        
//        ######## Add Menu Item #########

        JMenuItem reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        hotel.add(reception);
        
        addemployee = new JMenuItem("Add Employee");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addrooms = new JMenuItem("Add Rooms");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        JMenuItem adddrivers = new JMenuItem("Add Drivers");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);
        
        
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Employee")){
            new AddEmployee();
        }
        else if (ae.getActionCommand().equals("Add Rooms")){
            new AddRooms();
        }
        else if(ae.getActionCommand().equals("Add Drivers")){
            new AddDriver();
        }
        else if(ae.getActionCommand().equals("Reception")){
            new Reception();
        }
    }
    
    public static void main(String[]  args){
        new Dashboard();
    } 
}