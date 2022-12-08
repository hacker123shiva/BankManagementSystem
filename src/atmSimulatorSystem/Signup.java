package atmSimulatorSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Signup extends JFrame implements  ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JRadioButton r1,r2,r3,r4,r5,r6;
	JButton b;
	JDateChooser dateChooser;
Random ran =new Random();
long first4 =Math.abs(ran.nextLong()%9000L)+1000L;
String first = ""+ first4;
{ResultSet rs;
boolean flag=false;
    Conn con = new Conn();
    String q1="Select formno from signup";
    try {
	rs=	con.statement.executeQuery(q1);
     while(rs.next()) {
    	if(first.equals(rs.getString("formno")))
    	{
    		
    	}
    	else
    	{
    		 flag=true;
    	}
        }
     if(flag)
     {
    	 first4 =Math.abs(ran.nextLong()%9000L)+1000L;
    	 first = ""+ first4;
     }
	} catch (SQLException e) {
	 
		e.printStackTrace();
	}
     
}
 

Signup(){
    setTitle("NEW ACCOUNT APPLICATION FORM");
//set default layout be null
    setLayout(null);
//load image 
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atmSimulatorSystem/icons/logo2.png"));
//Scaled the image
    Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l11 = new JLabel(i3);
//set position
    l11.setBounds(20, 0, 100, 100);
    add(l11);
 

    l1 = new JLabel("APPLICATION FORM NO. "+first);
    l1.setFont(new Font("Raleway", Font.BOLD, 38));
    l1.setBounds(140,20,600,40);
    add(l1);

 
    
    l2 = new JLabel("Page 1: Personal Details");
    l2.setFont(new Font("Raleway", Font.BOLD, 22));
    l2.setBounds(290,80,600,30);
    add(l2);
    
    l3 = new JLabel("Name:");
    l3.setFont(new Font("Raleway", Font.BOLD, 20));
    l3.setBounds(100,140,100,30);
    add(l3);
    
    //add text field for name
    t1=new JTextField();
    t1.setFont(new Font("Raleway",Font.BOLD,14));
    t1.setBounds(300,140,400,30);
    add(t1);
    
    l4 = new JLabel("Father's Name:");
    l4.setFont(new Font("Raleway", Font.BOLD, 20));
    l4.setBounds(100,190,200,30);
    add(l4);
    
    //add text field for fname
    t2=new JTextField();
    t2.setFont(new Font("Raleway",Font.BOLD,14));
    t2.setBounds(300,190,400,30);
    add(t2);
    
    l5 = new JLabel("Date of Birth:");
    l5.setFont(new Font("Raleway", Font.BOLD, 20));
    l5.setBounds(100,240,200,30);
    add(l5);
    
    //add calendar
    dateChooser=new JDateChooser();
    dateChooser.setBounds(300,240,200,29);
    add(dateChooser);
    
    
    l6 = new JLabel("Gender:");
    l6.setFont(new Font("Raleway", Font.BOLD, 20));
    l6.setBounds(100,290,200,30);
    add(l6);
    
    //add radio Button 
    r1=new JRadioButton("Male");
    r1.setFont(new Font("Raleway",Font.BOLD,14));
    r1.setBackground(Color.WHITE);
    r1.setBounds(300, 290, 60, 30);
    add(r1);
   
    r2=new JRadioButton("Female");
    r2.setFont(new Font("Raleway",Font.BOLD,14));
    r2.setBackground(Color.WHITE);
    r2.setBounds(450, 290, 80, 30);
    add(r2);
    
    r3=new JRadioButton("Others");
    r3.setFont(new Font("Raleway",Font.BOLD,14));
    r3.setBackground(Color.WHITE);
    r3.setBounds(635, 290, 80, 30);
    add(r3);
    
    //Group the button 
    ButtonGroup groupgender =new ButtonGroup();
    groupgender.add(r1);
    groupgender.add(r2);
    groupgender.add(r3);
    
 
    
    l7 = new JLabel("Email Address:");
    l7.setFont(new Font("Raleway", Font.BOLD, 20));
    l7.setBounds(100,340,200,30);
    add(l7);
    
    
    //add text field for email
    t3=new JTextField();
    t3.setFont(new Font("Raleway",Font.BOLD,14));
    t3.setBounds(300,340,400,30);
    add(t3);
    
    l8 = new JLabel("Marital Status:");
    l8.setFont(new Font("Raleway", Font.BOLD, 20));
    l8.setBounds(100,390,200,30);
    add(l8);
    
    r4=new JRadioButton("Married");
    r4.setFont(new Font("Raleway",Font.BOLD,14));
    r4.setBackground(Color.WHITE);
    r4.setBounds(300,390,100,30);
    add(r4);
    
    r5=new JRadioButton("Unmarried");
    r5.setFont(new Font("Raleway",Font.BOLD,14));
    r5.setBackground(Color.WHITE);
    r5.setBounds(450,390,100,30);
    add(r5);
    
    r6=new JRadioButton("Others");
    r6.setFont(new Font("Raleway",Font.BOLD,14));
    r6.setBackground(Color.WHITE);
    r6.setBounds(635,390,100,30);
    add(r6);
    
    ButtonGroup groupStatus=new ButtonGroup();
    groupStatus.add(r4);
    groupStatus.add(r5);
    groupStatus.add(r6);
    
    l9 = new JLabel("Address:");
    l9.setFont(new Font("Raleway", Font.BOLD, 20));
    l9.setBounds(100,440,200,30);
    add(l9);
    
    //add text field for name
    t4=new JTextField();
    t4.setFont(new Font("Raleway",Font.BOLD,14));
    t4.setBounds(300,440,400,30);
    add(t4);
    
    l10 = new JLabel("City:");
    l10.setFont(new Font("Raleway", Font.BOLD, 20));
    l10.setBounds(100,490,200,30);
    add(l10);
    
    //add text field for name
    t5=new JTextField();
    t5.setFont(new Font("Raleway",Font.BOLD,14));
    t5.setBounds(300,490,400,30);
    add(t5);
    
    l11 = new JLabel("Pin Code:");
    l11.setFont(new Font("Raleway", Font.BOLD, 20));
    l11.setBounds(100,540,200,30);
    add(l11);
    
    //add text field for name
    t6=new JTextField();
    t6.setFont(new Font("Raleway",Font.BOLD,14));
    t6.setBounds(300,540,400,30);
    add(t6);
    
    l12 = new JLabel("State:");
    l12.setFont(new Font("Raleway", Font.BOLD, 20));
    l12.setBounds(100,590,200,30);
    add(l12);
    
    //add text field for state
    t7=new JTextField();
    t7.setFont(new Font("Raleway",Font.BOLD,14));
    t7.setBounds(300,590,400,30);
    add(t7);
    
    //add button 
    b=new JButton("Next");
    b.setFont(new Font("Raelway",Font.BOLD,14));
    b.setBackground(Color.BLACK);
    b.setForeground(Color.WHITE);
    b.setBounds(620,660,80,30);
    b.addActionListener(this);
    add(b);
    
    getContentPane().setBackground(Color.WHITE);
    
    setSize(850,800);
    setLocation(500,0);
    setVisible(true);
}

@Override
public void actionPerformed(ActionEvent ae) {
	 String formno =first;
	 String name =t1.getText();
	 boolean nameflag=false;
	 for(int i = 0; i < name.length(); i++)
     {
         if(name.charAt(i) >= 'a'&&name.charAt(i) <= 'z' || name.charAt(i) >= 'A'&& name.charAt(i)<='Z'||name.charAt(i)==' ')
         {
         
         }
         else
         {
        	 nameflag=true;
     		break;
         }
     }
	 String fname =t2.getText();
	 boolean fnameflag=false;
	 for(int i = 0; i < fname.length(); i++)
     {
		   if(fname.charAt(i) >= 'a'&&fname.charAt(i) <= 'z' || fname.charAt(i) >= 'A'&& fname.charAt(i)<='Z'||fname.charAt(i)==' ')
	         {
	         
	         }
	         else
	         {
	        	 fnameflag=true;
	     		break;
	         }
     }
	 String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
//	 calcaulate age of person 
	 String[] dobArray = dob.split("-");
      int day = Integer.parseInt(dobArray[0]);
  
      int month=switch(dobArray[1])
      {
      case "Jan" ->  1;  case "Feb" ->2; case "Mar" ->3;
      case "Apr" ->  4;  case "May" ->5; case "Jun" ->6;
      case "Jul" ->  7;  case "Aug" ->8; case "Sep" ->9;
      case "Oct" ->  10;  case "Nov" ->11; default ->12;
	 };
         
      int year = Integer.parseInt(dobArray[2]);
      Calendar dobCal = Calendar.getInstance();
      dobCal.set(year, month, day);
      Calendar today = Calendar.getInstance();
      int age = today.get(Calendar.YEAR) - dobCal.get(Calendar.YEAR);
      if (today.get(Calendar.DAY_OF_YEAR) < dobCal.get(Calendar.DAY_OF_YEAR)) {
          age--;
      }
      System.out.println(age);
	 String gender=null;
	 if(r1.isSelected())
	 {
		 gender="Male";
	 }
	 else  if(r2.isSelected())
	 {
		 gender ="Female";
	 }
	 else if(r3.isSelected())
	 {
		 gender="Others";
	 }
	 
	 String marital=null;
	 if(r4.isSelected())
	 {
		 marital="Married";
	 }
	 else  if(r5.isSelected())
	 {
		 marital ="Unmarried";
	 }
	 else if(r6.isSelected())
	 {
		 marital="Others";
	 }
 
	 String email=t3.getText();
     String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
             "[a-zA-Z0-9_+&*-]+)*@" +
             "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
             "A-Z]{2,7}$";
     Pattern pattern = Pattern.compile(regex);
     Matcher matcher = pattern.matcher(email);
     String address = t4.getText();
     String city = t5.getText();
     String pincode = t6.getText();
     boolean pinflag=false;
     if(pincode.charAt(0)!='0')
     {
        for(int i=0;i<pincode.length();i++)
     {
    	 if(pincode.charAt(i)>='0'&&pincode.charAt(i)<='9')
    	 {
    		 
    	 }
    	 else
    	 {
    		 pinflag=true;
    		 break;
    	 }
     }
     }
     else
     {
    	 pinflag=true;
     }
     String state = t7.getText();
     
     try{
    	 if(name.trim()=="")
    	 { 
             JOptionPane.showMessageDialog(null, "Empty field");
         }
    	 
          else if(nameflag)
          { 
           JOptionPane.showMessageDialog(null, "Enter proper name"); 
 	      }
    	 
          else if(fname.trim()=="")
          {
           JOptionPane.showMessageDialog(null, "Empty field");
          }
    	 
          else if(fnameflag )
          {
     	   JOptionPane.showMessageDialog(null, "Enter Proper Fname"); 
          }
    	 
          else if(age<18)
          {
           JOptionPane.showMessageDialog(null,"Your age should greater than or equal to 18");
          }
    	 
          else if(gender==null)
          {
           JOptionPane.showMessageDialog(null,"Choose Gender");
          }
    	 
          else if(!matcher.matches())
          {
           JOptionPane.showMessageDialog(null, "Enter proper email");   
          }
    	 
          else if(marital==null)
          {
           JOptionPane.showMessageDialog(null, "Choose Marital status");
          }
    	 
          else if(t4.getText().trim().equals(""))
          {
           JOptionPane.showMessageDialog(null, "Fill all the required fields");
          }
    	 
         else if(t5.getText().trim().equals(""))
         {
          JOptionPane.showMessageDialog(null, "Fill all the required fields");
         }
    	 
         else if(t6.getText().trim().equals(""))
         {
          JOptionPane.showMessageDialog(null, "Fill all the required fields");
        }
    	 
         else if(pinflag)
        {
	     JOptionPane.showMessageDialog(null,"pincode should only be digit");
        }
         else if(t6.getText().length()!=6)
       {
	    JOptionPane.showMessageDialog(null,"Pincode should be 6 digits");
       }
        else if(t7.getText().trim().equals(""))
      {
	   JOptionPane.showMessageDialog(null,"Field  should not be empty");
      }
       else
       {
             Conn con = new Conn();
             String q1="insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
             con.statement.executeUpdate(q1);
           
             new Signup2(first).setVisible(true);
             setVisible(false);
       }
         
     }catch(Exception e){
          e.printStackTrace();
     }
}
}
