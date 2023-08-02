package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Reception extends JFrame implements ActionListener{
    
    JButton newCustomer , rooms , department , employee , customerInfo , managerInfo , checkout , update , roomStatus , pickup , search , logout;
    
    Reception(){
        setSize(900 , 600);
        setLocation(250 , 100 );
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
//        ###### Add new Customer Button ######
        newCustomer = new JButton("New Customer Form ");
        newCustomer.setBounds(20 , 20 , 200 , 40);
        newCustomer.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        newCustomer.setForeground(Color.WHITE);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        
//        ###### Add new Customer Button ######
        rooms = new JButton("Rooms ");
        rooms.setBounds(20 , 65 , 200 , 40);
        rooms.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        rooms.setForeground(Color.WHITE);
        rooms.setBackground(Color.BLACK);
        rooms.addActionListener(this);
        add(rooms);
        
        
//        ######## Add Depertment Button ########
        department = new JButton("Department ");
        department.setBounds(20 , 110 , 200 , 40);
        department.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        department.setForeground(Color.WHITE);
        department.setBackground(Color.BLACK);
        department.addActionListener(this);
        add(department);
        
//        ######## Add Employee Button ####### 
        employee = new JButton("All Employee ");
        employee.setBounds(20 , 155 , 200 , 40);
        employee.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        employee.setForeground(Color.WHITE);
        employee.setBackground(Color.BLACK);
        employee.addActionListener(this);
        add(employee);
        
//        ####### Add Customer Info Button #####
        customerInfo = new JButton("Customer Info");
        customerInfo.setBounds(20 , 200 , 200 , 40);
        customerInfo.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        customerInfo.setForeground(Color.WHITE);
        customerInfo.setBackground(Color.BLACK);
        customerInfo.addActionListener(this);
        add(customerInfo);
        
//        ###### Add Manager Info Button ###### 
        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(20 , 245 , 200 , 40);
        managerInfo.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        managerInfo.setForeground(Color.WHITE);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.addActionListener(this);
        add(managerInfo);
        
        
//        ###### Add Check Out Button #########
        checkout = new JButton("Checkout");
        checkout.setBounds(20 , 290 , 200 , 40);
        checkout.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.BLACK);
        checkout.addActionListener(this);
        add(checkout);
        
        
//        ##### Add Update Status #######
        update = new JButton("Update Status");
        update.setBounds(20 , 335 , 200 , 40);
        update.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.addActionListener(this);
        add(update);
        
        
//        ######## Add Update Room Status ####
        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(20 , 380 , 200 , 40);
        roomStatus.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        roomStatus.setForeground(Color.WHITE);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.addActionListener(this);
        add(roomStatus);
        
        
//        ######### Add Pickup Service Button ######
        pickup = new JButton("Pickup Service");
        pickup.setBounds(20 , 425 , 200 , 40);
        pickup.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        pickup.setForeground(Color.WHITE);
        pickup.setBackground(Color.BLACK);
        pickup.addActionListener(this);
        add(pickup);
        
        
//        ##### Add search Rooms Button #####
        search = new JButton("Search Rooms");
        search.setBounds(20 , 470 , 200 , 40);
        search.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        search.setForeground(Color.WHITE);
        search.setBackground(Color.BLACK);
        search.addActionListener(this);
        add(search);
        
//        #### Add Logout Button ###
        logout = new JButton("Logout");
        logout.setBounds(20 , 515 , 200 , 40);
        logout.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        logout.setForeground(Color.WHITE);
        logout.setBackground(Color.BLACK);
        logout.addActionListener(this);
        add(logout);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250 , 30 , 600 , 500);
        add(image);
        

        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == logout){
//            setVisible(false);
            System.exit(0);
        }
        else if(ae.getSource() == newCustomer){
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource() == rooms){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource() == department){
            setVisible(false);
            new Department();
        }
        else if(ae.getSource() == employee){
            setVisible(false);
            new EmployeeInfo();
        }
        else if(ae.getSource() == managerInfo){
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource() == customerInfo){
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource() == search){
            setVisible(false);
            new SearchRoom();
        }
        else if(ae.getSource() == update){
            setVisible(false);
            new UpdateCheck();
        }
        else if(ae.getSource() == roomStatus){
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource() == pickup){
            setVisible(false);
            new PickUp();
        }
        else{
            setVisible(false);
            new CheckOut();
        }
    }
    
    
    public static void main(String[] args){
        new Reception();
    }
}
