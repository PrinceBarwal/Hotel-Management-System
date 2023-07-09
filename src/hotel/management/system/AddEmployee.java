package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tfname , tfage , tfsalary , tfphone , tfemail ,tfaadhar ;
    JButton submit , cancel;
    JRadioButton rbmale , rbfemale;
    JComboBox cbjob;
    
    
    AddEmployee(){
        setSize(750,500);
        setLocation(350,180);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
//        ####### Name field ######
        
        JLabel lblname = new JLabel("Name : ");
        lblname.setBounds(30 , 20 , 70 , 30 );
        lblname.setFont(new Font("Tahoma" , Font.PLAIN , 17));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(150 , 20 , 200 , 30);
        add(tfname);
        
        
//        ######## Age Field ########
        
        JLabel lblage = new JLabel("Age : ");
        lblage.setBounds(30 , 70 , 70 , 30 );
        lblage.setFont(new Font("Tahoma" , Font.PLAIN , 17));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(150 , 70 , 200 , 30);
        add(tfage);
        
        
//        ###### Gender Field ########

        JLabel lblgender = new JLabel("Gender : ");
        lblgender.setBounds(30 , 120 , 70 , 30 );
        lblgender.setFont(new Font("Tahoma" , Font.PLAIN , 17));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(150 , 120 , 70 , 30);
        rbmale.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(240 , 120 , 100 , 30);
        rbfemale.setFont(new Font("Tahoma" , Font.PLAIN , 15));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup group = new ButtonGroup();
        group.add(rbmale);
        group.add(rbfemale);
        
        
        
//        ######  Job Field ######

        JLabel lbljob = new JLabel("Job : ");
        lbljob.setBounds(30 , 170 , 70  ,30);
        lbljob.setFont(new Font("Tahoma" , Font.PLAIN , 17));
        add(lbljob);
        
        String[] jobComboValues = {"Front Desk Clerks" , "Porters" , "HouseKeeping" , "Kitchen Staff" , "Room Service" , "Chefs" , "Waiter/Waitress" , "Manager" , "Accountant"};
        cbjob = new JComboBox(jobComboValues);
        cbjob.setBounds(150 , 170 , 200 , 30);
        cbjob.setBackground(Color.WHITE);
        cbjob.setSelectedItem(null);
        add(cbjob);
        
        
//        ######## Salary Field #########
        JLabel lblsalary = new JLabel("Salary :");
        lblsalary.setBounds(30 , 220 , 70 , 30);
        lblsalary.setFont(new Font("Tahoma" , Font.PLAIN , 17));
        add(lblsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(150 , 220 , 200 , 30);
        add(tfsalary);
        
        
//        ######## Phone Field #########
        JLabel lblphone = new JLabel("Phone :");
        lblphone.setBounds(30 , 270 , 70 , 30);
        lblphone.setFont(new Font("Tahoma" , Font.PLAIN , 17));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(150 , 270 , 200 , 30);
        add(tfphone);


        
//        ######## Email Field #########
        JLabel lblemail = new JLabel("Email :");
        lblemail.setBounds(30 , 320 , 70 , 30);
        lblemail.setFont(new Font("Tahoma" , Font.PLAIN , 17));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(150 , 320 , 200 , 30);
        add(tfemail);
        
        
//        ######## Aadhar Field #########
        JLabel lblaadhar = new JLabel("Aadhar :");
        lblaadhar.setBounds(30 , 370 , 70 , 30);
        lblaadhar.setFont(new Font("Tahoma" , Font.PLAIN , 17));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(150 , 370 , 200 , 30);
        add(tfaadhar);
        
        
//        ######### Add Image #########

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400 , 30 , 300 ,400);
        add(image);

        
//        ####### Add submit Button ########
        submit = new JButton("Submit");
        submit.setBounds(70 , 420 , 100 , 30);
        submit.setFont(new Font("Tahoma" , Font.PLAIN , 17));
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(250 , 420 , 100 , 30);
        cancel.setFont(new Font("Tahoma" , Font.PLAIN , 17));
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);
        

        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = null;
            if(rbmale.isSelected()){
                gender = "Male";
            }
            else if(rbfemale.isSelected()){
                gender = "Female";
            }
            String job = (String)cbjob.getSelectedItem();
            String salary = tfsalary.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String aadhar = tfaadhar.getText();
            
            Pattern emailpattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
            Matcher emailmatcher = emailpattern.matcher(email);
            
            Pattern phonepattern = Pattern.compile("^[0-9]{10}$");
            Matcher phonematcher = phonepattern.matcher(phone);
            
            
            Pattern salarypattern = Pattern.compile("^[0-9]{2,10}$");
            Matcher salarymatcher = salarypattern.matcher(salary);
            
            Pattern aadharpattern = Pattern.compile("[0-9]{12}$");
            Matcher aadharmatcher = aadharpattern.matcher(aadhar);
            
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else if(age.equals("")){
                JOptionPane.showMessageDialog(null, "Age is Required");
            }
            else if(!(rbmale.isSelected()) && !(rbfemale.isSelected())){
                JOptionPane.showMessageDialog(null, "Gender is Required");
            }
            else if(job == null){
                JOptionPane.showMessageDialog(null, "Job is required" ); 
            }
            else if(!(salarymatcher.matches())){
                JOptionPane.showMessageDialog(null, "Enter Correct Salary");
            }
            else if(!(emailmatcher.matches())){
                JOptionPane.showMessageDialog(null, "Enter Correct Email");
            }
            else if(!(phonematcher.matches())){
                JOptionPane.showMessageDialog(null , "Enter Correct Phone Number");
            }
            else if(!(aadharmatcher.matches())){
                JOptionPane.showMessageDialog(null , "Enter a valid aadhar number ");
            }

            else{
                try{
                    Conn c = new Conn();

                    String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";

                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Employee Added Successfully");

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
        new AddEmployee();
    }
}
