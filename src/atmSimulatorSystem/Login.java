package atmSimulatorSystem;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame  implements ActionListener{
	JLabel l1,l2,l3;
	JTextField tf1;
	JPasswordField pf2;
	JButton b1,b2,b3;
	
	Login(){
setTitle("AUTOMATD TELLER MACHINE");	
//setLayout(null) by deafult it is in middle
setLayout(null);
 

//add image icon
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atmSimulatorSystem/icons/logo2.png"));
//convert imageicon to scaled image 
Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
//convert image ito icon so that we can give ImageIcon object in JLabel
ImageIcon i3=new ImageIcon(i2);
JLabel l11=new JLabel(i3);
l11.setBounds(70,10,100,100);
add(l11);

//add Top heading of this application i.e WELCOME TO ATM
l1=new JLabel("WELCOME TO ATM");
//Font class is in awt package
l1.setFont(new Font("Osward", Font.BOLD, 38));
l1.setBounds(220,20,450,100);
add(l1);

l2=new JLabel("Card NO:");
l2.setFont(new Font("Railway",Font.BOLD,28));
l2.setBounds(125,150,375,30);
add(l2);

tf1=new JTextField(15);
tf1.setBounds(300,150,230,30);
tf1.setFont(new Font("Arial", Font.BOLD, 14));
add(tf1);

l3=new JLabel("PIN:");
l3.setFont(new Font("Railway",Font.BOLD,28));
l3.setBounds(125,220,375,30);
add(l3);

pf2 =new JPasswordField(15);
pf2.setFont(new Font("Arial",Font.BOLD,28));
pf2.setBounds(300,220,230,30);
add(pf2);

//add button for Signn in
b1=new JButton("SIGN IN");
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
b1.setBounds(300,300,100,30);
b1.addActionListener(this);
add(b1);

//add button for clear
b2=new JButton("CLEAR");
b2.setBackground(Color.BLACK);
b2.setForeground(Color.WHITE);
b2.setBounds(430,300,100,30);
b2.addActionListener(this);
add(b2);

//add button for signup
b3=new JButton("SIGN UP");
b3.setBackground(Color.BLACK);
b3.setForeground(Color.WHITE);
b3.setBounds(300,350,230,30);
b3.addActionListener(this);
add(b3);

//first we save size of frame
		setSize(800,480);
//Set location 450 from left and 150 from top
		setLocation(350,200);
//By default visibilty is false
	    setVisible(true);
//set Background color frame white
getContentPane().setBackground(Color.WHITE);
 
	}
//override the implement method actionPerformed
@Override
public void actionPerformed(ActionEvent ae){
    try{        
        if(ae.getSource()==b1){
            Conn c1 = new Conn();
            String cardno  = tf1.getText();
            String pin  = pf2.getText();
            String q  = "select * from login where cardnumber = '"+cardno+"' and pin = '"+pin+"'";

            ResultSet rs = c1.statement.executeQuery(q);
            if(rs.next()){
                setVisible(false);
                new Transactions(cardno).setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
            }
        }else if(ae.getSource()==b2){
            tf1.setText("");
            pf2.setText("");
        }else if(ae.getSource()==b3){
            setVisible(false);
            new Signup().setVisible(true);
        }
    }catch(Exception e){
        e.printStackTrace();
    }
}
    public static void main(String[] args){
       new Login().setVisible(true);
    }
	 

    
}
