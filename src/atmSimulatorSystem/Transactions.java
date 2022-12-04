package atmSimulatorSystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String cardno;
 public   Transactions(String cardno)
    {  setLayout(null);
    	this.cardno=cardno;
    	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atmSimulatorSystem/icons/atm.jpg"));
    	Image i2=i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
    	ImageIcon i3=new ImageIcon(i2);
    	JLabel l2=new JLabel(i3);
    	l2.setBounds(0, 0, 960, 1080);
    	add(l2);
    	
        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(235,400,700,35);
        l2.add(l1);
        
        b1 = new JButton("DEPOSIT");
        b1.setBounds(170,499,150,35);
        b1.addActionListener(this);
        l2.add(b1);
        
        b2 = new JButton("CASH WITHDRAWL");
        b2.setBounds(390,499,150,35);
        b2.addActionListener(this);
        l2.add(b2);
        
        b3 = new JButton("FAST CASH");
        b3.setBounds(170,543,150,35);
        b3.addActionListener(this);
        l2.add(b3);
        
        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(390,543,150,35);
        b4.addActionListener(this);
        l2.add(b4);
        
        b5 = new JButton("PIN CHANGE");
        b5.setBounds(170,588,150,35);
        b5.addActionListener(this);
        l2.add(b5);
        
        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(390,588,150,35);
        b6.addActionListener(this);
        l2.add(b6);
        
        b7 = new JButton("EXIT");
        b7.setBounds(390,633,150,35);
        b7.addActionListener(this);
        l2.add(b7);
        
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    }
 
	@Override
	  public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){ 
            setVisible(false);
            new Deposit(cardno).setVisible(true);
        }else if(ae.getSource()==b2){ 
            setVisible(false);
            new Withdrawl(cardno).setVisible(true);
        }else if(ae.getSource()==b3){ 
            setVisible(false);
            new FastCash(cardno).setVisible(true);
        }else if(ae.getSource()==b4){ 
            new MiniStatement(cardno).setVisible(true);
        }else if(ae.getSource()==b5){ 
            setVisible(false);
            new Pin(cardno).setVisible(true);
        }else if(ae.getSource()==b6){ 
            this.setVisible(false);
            new BalanceEquiry(cardno).setVisible(true);
        }else if(ae.getSource()==b7){ 
            System.exit(0);
        }
    }
	
  
 
}
