package atmSimulatorSystem;

import java.awt.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {
    JButton b1, b2;
    JLabel l1;
    
    //create constructor with parameter contain pin
    MiniStatement(String cardno)
    {   setTitle("MiniStatement");
    l1 = new JLabel();
    l1.setBounds(20, 140, 400, 200);
    add(l1);
    
    JLabel l2 = new JLabel("GLA BANK");
    l2.setBounds(150, 20, 100, 20);
    add(l2);
    
    JLabel l3 = new JLabel();
    l3.setBounds(20, 80, 300, 20);
    add(l3);
    
    JLabel l4 = new JLabel();
    l4.setBounds(20, 400, 300, 20);
    add(l4);
    
    try {//sql part to check pin equal to given pin
    	Conn c=new Conn();
        String query="select * from login where cardnumber = '"+cardno+"'";
    	ResultSet rs=c.statement.executeQuery(query);
    	while(rs.next())
    	{
    		l3.setText("Card Number:    " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
    	}
    }
    catch(SQLException e)
    {
    	System.out.println(e);
    }
    
    try {
    	int balance=0;
        Conn c =new Conn();
        String query="select * from bank where cardnumber = '"+cardno+"'";
        ResultSet rs=c.statement.executeQuery(query);
        while(rs.next()){
            l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
            //if 
            if(rs.getString("type").equals("Deposit")){
                balance += Integer.parseInt(rs.getString("amount"));
            }else{
                balance -= Integer.parseInt(rs.getString("amount"));
            }
        }
        l4.setText("Your total Balance is Rs "+balance);
    }
    
    catch(SQLException e)
    {
    	e.printStackTrace();
    }
    
    b1 = new JButton("Exit");
    b1.setBounds(20, 500, 100, 25);
    b1.addActionListener(this);
    add(b1);
    	setLayout(null); 
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);	
	}
	
	 
}
