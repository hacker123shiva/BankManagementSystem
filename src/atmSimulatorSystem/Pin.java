package atmSimulatorSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener{
	//create instance varaible to access globally
	    JPasswordField t1,t2;
	    JButton b1,b2;                               
	    JLabel l1,l2,l3;
	    String cardno;
public 	Pin(String cardno)
	{setLayout(null);
	    this.cardno = cardno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atmSimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 960, 1080);
        add(l4);
       
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        l1.setBounds(280,330,800,35);
        l4.add(l1); //Since we are adding label above the image
        
        //add label for enter new pin
        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        l2.setBounds(180,390,150,35);
        l4.add(l2);
        //add passworrdtext field
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        t1.setBounds(350,390,180,25);
        l4.add(t1);
        
        //add label for renter pin
        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);
        l3.setBounds(180,440,200,35);
        l4.add(l3);
        //add password text field
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        t2.setBounds(350,440,180,25);
        l4.add(t2);
        
        //add Change and Back button
        b1 = new JButton("CHANGE");
        b1.setBounds(390,588,150,35);
        b1.addActionListener(this);
        l4.add(b1);
        
        b2 = new JButton("BACK");
        b2.setBounds(390,633,150,35);
        b2.addActionListener(this);
        l4.add(b2);
        
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
	}
public void actionPerformed(ActionEvent ae)
{try {
	String npin=t1.getText();
	String rpin=t2.getText();
	
	if(!npin.equals(rpin))
	{
		JOptionPane.showMessageDialog(null, "Enter Pin does not Match");
		t1.setText("");
		t2.setText("");
	}
	else {
	  if(ae.getSource()==b1){
          if (t1.getText().trim().equals("")){
              JOptionPane.showMessageDialog(null, "Field cannot be empty");
          }
          if (t2.getText().trim().equals("")){
              JOptionPane.showMessageDialog(null, "Field cannot be empty");
          }
          Conn c1 = new Conn();
          String q2 = "update login set pin = '"+rpin+"' where cardnumber = '"+cardno+"' ";
          String q3 = "update signupthree set pin = '"+rpin+"' where cardnumber = '"+cardno+"' ";

 
          c1.statement.executeUpdate(q2);
          c1.statement.executeUpdate(q3);

          JOptionPane.showMessageDialog(null, "PIN changed successfully");
          setVisible(false);
          new Transactions(cardno).setVisible(true);
	  }
	  else if(ae.getSource()==b2){
          new Transactions(cardno).setVisible(true);
          setVisible(false);  
	  }
	}
}
	catch(Exception e)
	{
		System.out.println(e);
	}
 
}

 
}
