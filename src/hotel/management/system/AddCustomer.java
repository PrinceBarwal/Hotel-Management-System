package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.util.regex.*;


public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfnumber , tfname , tfcountry , tfdeposite;
    JComboBox comboid ;
    JRadioButton male , female;
    JButton addCustomer , back;
    Choice croom;
    JLabel checkintime;
    
    AddCustomer(){
        setSize(800 ,550);
        setLocation(300 , 170);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
//        ##### Add heaing Label ####
        JLabel heading = new JLabel("New Customer Form");
        heading.setBounds(100 , 0 , 200 , 40);
        heading.setFont(new Font("Raleway" , Font.BOLD , 20));
        add(heading);
        
        
//        ###### Add id filed #######
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30 , 50 , 80 , 40 );
        lblid.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(lblid);
        
        String[] idComboValues = {"Passport" , "Aadhar Card" , "Driving License" , "Voter ID card" , "Ration Card" };
        comboid = new JComboBox(idComboValues);
        comboid.setBounds(150 , 50 , 200 , 40);
        comboid.setBackground(Color.WHITE);
        comboid.setSelectedItem(null);
        add(comboid);
        
        
//        ###### Add Number Field ####
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30 , 100 , 80 , 40 );
        lblnumber.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(150 , 100 , 200 , 40);
        add(tfnumber);
        
        
//        #### Add Name field ######
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30 , 150 , 80 , 40 );
        lblname.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(150 , 150 , 200 , 40);
        add(tfname);
        
        
//        ###### Add Gender Field ####
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30 , 200 , 80 , 40 );
        lblgender.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(lblgender);
        
        male = new JRadioButton("Male");
        male.setBounds(160 , 200 , 80 , 40);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Tahoma" , Font.PLAIN , 17));
        add(male);        
        
        
        female = new JRadioButton("Female");
        female.setBounds(250 , 200 , 80 , 40);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Tahoma" , Font.PLAIN , 17));
        add(female);  
        
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        
        
//        ####### Add Country field #####
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30 , 250 , 80 , 40 );
        lblcountry.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(150 , 250 , 200 , 40);
        add(tfcountry);

        
//        ####### Allocation Room Number ####
        JLabel lblallocation = new JLabel("Room");
        lblallocation.setBounds(30 , 300 , 80 , 40 );
        lblallocation.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(lblallocation);
        
        
        croom = new Choice();
        
        try{
            
            Conn c= new Conn();
            
            String query = "select * from rooms where available = 'Available'";
            
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                croom.add(rs.getString("roomNumber")); 
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        croom.setBounds(150 , 300 , 200 , 40);
        croom.setBackground(Color.WHITE);
        add(croom);
        
        
//        ###### Add Check In time ####
        JLabel lblTime = new JLabel("Checkin Time ");
        lblTime.setBounds(30 , 350 , 150 , 40 );
        lblTime.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(lblTime);
        
        Date date = new Date();
        
        checkintime = new JLabel(""+date);
        checkintime.setBounds(170 , 350 , 250 , 40);
        checkintime.setFont(new Font("raleway" , Font.BOLD , 17));
        add(checkintime);


//        ######## Add Deposite filed #####
        JLabel lbldeposite = new JLabel("Deposite");
        lbldeposite.setBounds(30 , 400 , 150 , 40 );
        lbldeposite.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(lbldeposite);
        
        
        tfdeposite = new JTextField();
        tfdeposite.setBounds(150 , 400 , 200 , 40);
        add(tfdeposite);
        
        
//        #### Add Buttons ######
        addCustomer = new JButton("Add Customer");
        addCustomer.setBackground(Color.BLACK);
        addCustomer.setForeground(Color.WHITE);
        addCustomer.setBounds(50 , 460 , 150 , 40);
        addCustomer.addActionListener(this);
        add(addCustomer);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(250 , 460 , 100 , 40);
        back.addActionListener(this);
        add(back);
        
        
//        ######## Add Image ####
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400 , 10 , 400 ,500 );
        add(image);
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addCustomer){
            String id = (String)comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            if(male.isSelected()){
                gender = "Male";
            }
            else if(female.isSelected()){
                gender = "Female";
            }
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposite = tfdeposite.getText();
            
//            ###### Add Validate field#####

            Pattern numberpattern = Pattern.compile("[0-9]{12}$");
            Matcher numbermatcher = numberpattern.matcher(number);
            
            Pattern namepattern = Pattern.compile("^[A-Za-z\\s'-]+$");
            Matcher namematcher = namepattern.matcher(name);
            
            Pattern countrypattern = Pattern.compile("^[A-Za-z\\s'-]+$");
            Matcher countrymatcher = countrypattern.matcher(country);
            
            Pattern roompattern = Pattern.compile("[0-9]{1,3}$");
            Matcher roommatcher = roompattern.matcher(room);
            
            Pattern depositepattern = Pattern.compile("[0-9]{3,5}$");
            Matcher depositematcher = depositepattern.matcher(deposite);
            
            
            if(id == null){
                JOptionPane.showMessageDialog(null, "Id is Required");
            }
            else if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Number is Required");
            }
            else if(!(numbermatcher.matches())){
                JOptionPane.showMessageDialog(null, "Enter Correct number");
            }
            else if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else if(!(namematcher.matches())){
                JOptionPane.showMessageDialog(null, "Enter Correct Name");
            }
            else if(!(male.isSelected()) && !(female.isSelected())){
                JOptionPane.showMessageDialog(null, "Gender is Required");
            }
            else if(country.equals("")){
                JOptionPane.showMessageDialog(null, "Country is Required");
            }
            else if(!(countrymatcher.matches())){
            JOptionPane.showMessageDialog(null, "Enter Correct Country Name");
            }
            else if(room.equals("")){
                JOptionPane.showMessageDialog(null, "Room number is Required");
            }
            else if(!(roommatcher.matches())){
                JOptionPane.showMessageDialog(null, "Room is Required");
            }
            else if(deposite.equals("")){
                JOptionPane.showMessageDialog(null, "Deposite amount is Required");
            }
            else if(!(depositematcher.matches())){
                JOptionPane.showMessageDialog(null, "Enter Correct Amount");
            }
            else {
                try{
                Conn c = new Conn();
                String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposite+"')";
                String query2 = "update rooms set available = 'Occupied' where roomNumber = '"+room+"'";
                
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Room Allocated Successfully ");
                
                setVisible(false);
                new Reception().setVisible(true);
                
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Reception().setVisible(true);
        }
        
    }
    
    public static void main(String[] args){
        new AddCustomer();
    }
    
}
