package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;


public class AddRooms extends JFrame implements ActionListener{
    
    
    JButton add , cancel ;
    JTextField tfrooms , tfprice;
    JComboBox availablecombo , cleancombo , typecombo;
    
    AddRooms(){
        setSize(1000 , 500);
        setLayout(null);
        setLocation(250,200);
        getContentPane().setBackground(Color.WHITE);
        
        
//        ###### Add Heading ########
        
        JLabel heading = new JLabel("Add Roooms");
        heading.setBounds(130 , 20 , 200 , 30);
        heading.setFont(new Font("Tahoma" , Font.BOLD , 30));
        add(heading);
        
        
//        ####### Add Room Filed #####

        JLabel lblrooms = new JLabel("Room Number ");
        lblrooms.setBounds(30 , 100 , 150 , 30);
        lblrooms.setFont(new Font("Raleway" , Font.PLAIN , 20));
        add(lblrooms);
        
        
        tfrooms = new JTextField();
        tfrooms.setBounds(190 ,100 , 150 , 30 );
        add(tfrooms);
        
        
//        ####### Add Available Filed ########
        
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setBounds(30 , 150 , 150 , 30);
        lblavailable.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(lblavailable);
        
        String[] availableoption = {"Available" , "Occupied"};
        availablecombo = new JComboBox(availableoption);
        availablecombo.setBounds(190 , 150 , 150 , 30);
        availablecombo.setBackground(Color.WHITE);
        availablecombo.setSelectedItem(null);
        add(availablecombo);
        
        
//        ##### Add Cleaning Status ######
        
        JLabel lblcleaning = new JLabel("Cleaning Status");
        lblcleaning.setBounds(30 , 200 , 150 , 30);
        lblcleaning.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(lblcleaning);
        
        String[] cleaningoption = {"Dirty" , "Clean"};
        cleancombo = new JComboBox(cleaningoption);
        cleancombo.setBounds(190 , 200 , 150 , 30);
        cleancombo.setBackground(Color.WHITE);
        cleancombo.setSelectedItem(null);
        add(cleancombo);
        
        
//        ###### Add Price Filed #########
        JLabel lblprice = new JLabel("Price ");
        lblprice.setBounds(30 , 250 , 150 , 30);
        lblprice.setFont(new Font("Raleway" , Font.PLAIN , 20));
        add(lblprice);
        
        
        tfprice= new JTextField();
        tfprice.setBounds(190 ,250 , 150 , 30 );
        add(tfprice);
        
        
//        ######## Add Bed Type Field #######
        JLabel lblbedtype = new JLabel("Bed Type");
        lblbedtype.setBounds(30 , 300 , 150 , 30);
        lblbedtype.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(lblbedtype);
        
        String[] typeoption = {"Single Bed" , "Double Bed"};
        typecombo = new JComboBox(typeoption);
        typecombo.setBounds(190 , 300 , 150 , 30);
        typecombo.setBackground(Color.WHITE);
        typecombo.setSelectedItem(null);
        add(typecombo);
        
        
//        #### Add AddRooms Button ########
        add = new JButton("Add Rooms");
        add.setBounds(60 , 370 , 100 , 30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add(add);
        
        
//        ##### Add Cancel Button ######
        cancel = new JButton("Cancel");
        cancel.setBounds(170 , 370 , 100 , 30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
//        ##### Add Image #######

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370 , 30 , 600 , 400);
        add(image);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String roomNumber = tfrooms.getText();
            String available = (String)availablecombo.getSelectedItem();
            String status = (String)cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String)typecombo.getSelectedItem();
            
            Pattern roompattern = Pattern.compile("^[0-9]{1,3}$");
            Matcher roommatcher = roompattern.matcher(roomNumber);
            
            Pattern pricepattern = Pattern.compile("[0-9]{2,5}$");
            Matcher pricematcher = pricepattern.matcher(price);
            
            
            if(roomNumber.equals("")){
                JOptionPane.showMessageDialog(null, "Room Number is Required");
            }
            else if(!(roommatcher.matches())){
                JOptionPane.showMessageDialog(null, "Emter Correct Room Number");
            }
            else if(available == null){
                JOptionPane.showMessageDialog(null, "Available Status is Required");
            }
            else if(status == null){
                JOptionPane.showMessageDialog(null, "Cleaninig Status is Required");
            }
            else if(price.equals("")){
                JOptionPane.showMessageDialog(null, "Price is Required");
            }
            else if(!(pricematcher.matches())){
                JOptionPane.showMessageDialog(null, "Enter Correct Price");
            }
            else if(type == null){
                JOptionPane.showMessageDialog(null, "Bed Type is Required");
            }
            else{
                try{
                Conn c = new Conn();
                
                String query = "insert into rooms values('"+roomNumber +"','"+available+"','"+status+"','"+price+"','"+type+"')";
                
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Rooms Added Successfully");
                
                setVisible(false);
                
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddRooms();
    }
}
