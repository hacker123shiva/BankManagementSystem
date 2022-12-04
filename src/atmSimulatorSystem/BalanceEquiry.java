package atmSimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BalanceEquiry extends JFrame implements ActionListener{
JTextField t1,t2;
JButton b1,b2,b3;
JLabel l1,l2,l3;
String cardno;
public BalanceEquiry(String cardno)
{
	setTitle("Balance Enquiry");
	setLayout(null);
	
	this.cardno =cardno;
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atmSimulatorSystem/icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel l3=new JLabel(i3);
    l3.setBounds(0,0,960,1080);
    add(l3);
    
    l1 = new JLabel();
    l1.setForeground(Color.WHITE);
    l1.setFont(new Font("System", Font.BOLD, 16));
    l1.setBounds(190, 350, 400, 35);
    l3.add(l1);
    
    b1 = new JButton("BACK");
    b1.setBounds(390, 633, 150, 35);
    b1.addActionListener(this);
    l3.add(b1);
    
    int balance = 0;
    try{
        Conn c1 = new Conn();
        String query="select * from bank where cardnumber = '"+cardno+"'";
        ResultSet rs = c1.statement.executeQuery( query);
        while (rs.next()) {
            if (rs.getString("type").equals("Deposit")) {
                balance += Integer.parseInt(rs.getString("amount"));
            } else {
                balance -= Integer.parseInt(rs.getString("amount"));
            }
        }
    }catch(Exception e){}
    l1.setText("Your Current Account Balance is Rs "+balance);
    
    setSize(960, 1080);
    setUndecorated(true);
    setLocation(500, 0);
    setVisible(true);
	
}
 

@Override
public void actionPerformed(ActionEvent e) {
    setVisible(false);
    new Transactions(cardno).setVisible(true);
	
}
	
}
