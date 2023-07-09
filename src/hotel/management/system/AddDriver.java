package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddDriver extends JFrame implements ActionListener{
    
    
    JButton add , cancel ;
    JTextField tfname , tfage , tfcompany , tfmodel , tflocation;
    JComboBox   gendercombo , availablecombo ;
    
    AddDriver(){
        setSize(1050 , 550);
        setLayout(null);
        setLocation(200,170);
        getContentPane().setBackground(Color.WHITE);
        
        
//        ###### Add Heading ########
        
        JLabel heading = new JLabel("Add Driver");
        heading.setBounds(130 , 20 , 200 , 30);
        heading.setFont(new Font("Tahoma" , Font.BOLD , 30));
        add(heading);
        
        
//        ####### Add Name Filed #####

        JLabel lblname = new JLabel("Name ");
        lblname.setBounds(30 , 100 , 150 , 30);
        lblname.setFont(new Font("Raleway" , Font.PLAIN , 20));
        add(lblname);
        
        
        tfname = new JTextField();
        tfname.setBounds(190 ,100 , 150 , 30 );
        add(tfname);
        
        
//        ####### Add Age Filed ########
        
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(30 , 150 , 150 , 30);
        lblage.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(190 , 150 , 150 , 30 );
        add(tfage);
        
        
//        ##### Add Gender ######
        
        JLabel lblgender = new JLabel("Gender ");
        lblgender.setBounds(30 , 200 , 150 , 30);
        lblgender.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(lblgender);
        
        String[] genderoption = {"Male" , "Female"};
        gendercombo = new JComboBox(genderoption);
        gendercombo.setBounds(190 , 200 , 150 , 30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        
        
//        ###### Add Car Company Filed #########
        JLabel lblcompany = new JLabel("Car Company ");
        lblcompany.setBounds(30 , 250 , 150 , 30);
        lblcompany.setFont(new Font("Raleway" , Font.PLAIN , 20));
        add(lblcompany);
        
        
        tfcompany= new JTextField();
        tfcompany.setBounds(190 ,250 , 150 , 30 );
        add(tfcompany);
        
        
        
//        ##### Car Model ##########

        JLabel lblmodel = new JLabel("Car Model ");
        lblmodel.setBounds(30 , 300 , 150 , 30);
        lblmodel.setFont(new Font("Raleway" , Font.PLAIN , 20));
        add(lblmodel);
        
        
        tfmodel= new JTextField();
        tfmodel.setBounds(190 ,300 , 150 , 30 );
        add(tfmodel);
        
        
//        ######## Add Bed Type Field #######
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setBounds(30 , 350 , 150 , 30);
        lblavailable.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(lblavailable);
        
        String[] availableoption = {"Available" , "Busy"};
        availablecombo = new JComboBox(availableoption);
        availablecombo.setBounds(190 , 350 , 150 , 30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        
//        ########## Add Location #########

        JLabel lbllocation = new JLabel("Location ");
        lbllocation.setBounds(30 , 400 , 150 , 30);
        lbllocation.setFont(new Font("Raleway" , Font.PLAIN , 20));
        add(lbllocation);
        
        
        tflocation= new JTextField();
        tflocation.setBounds(190 ,400 , 150 , 30 );
        add(tflocation);
        
        
        
        
        
//        #### Add AddRooms Button ########
        add = new JButton("Add Driver");
        add.setBounds(60 ,470 , 100 , 30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add(add);
        
        
//        ##### Add Cancel Button ######
        cancel = new JButton("Cancel");
        cancel.setBounds(170 , 470 , 100 , 30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
//        ##### Add Image #######

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400 , 40 , 600 , 450);
        add(image);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String)gendercombo.getSelectedItem();
            String car_company = tfcompany.getText();
            String car_model = tfmodel.getText();
            String available = (String)availablecombo.getSelectedItem();
            String location = tflocation.getText();
            
            try{
                Conn c = new Conn();
                
                String query = "insert into driver values('"+name +"','"+age+"','"+gender+"','"+car_company+"','"+car_model+"','"+available+"','"+location+"')";
                
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Driver Added Successfully");
                
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddDriver();
    }
}
