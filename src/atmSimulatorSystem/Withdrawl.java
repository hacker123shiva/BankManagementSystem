package atmSimulatorSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.util.Date; 
//Date class present in both sql and util package that why import full path java.util.Date;
public class Withdrawl extends JFrame implements ActionListener {
//creating instance varible of textfield, button , label and string 
	JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String cardno;
    
 public Withdrawl(String cardno)
    {setLayout(null);
    	this.cardno=cardno;
    ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("atmSimulatorSystem/icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(1000, 1180,Image.SCALE_DEFAULT );
    ImageIcon i3=new ImageIcon(i2);
    JLabel l3=new JLabel(i3);
    l3.setBounds(0,0,960,1080);
    add(l3);
    
    l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
    l1.setForeground(Color.WHITE);
    l1.setFont(new Font("System", Font.BOLD, 16));
    l1.setBounds(190,350,400,20);
    l3.add(l1);
 
    l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
    l2.setForeground(Color.WHITE);
    l2.setFont(new Font("System", Font.BOLD, 16));
    l2.setBounds(190,400,400,20);
    l3.add(l2);
    
    t1 = new JTextField();
    t1.setFont(new Font("Raleway", Font.BOLD, 25));
    t1.setBounds(190,450,330,30);
    l3.add(t1);
    
    b1 = new JButton("WITHDRAW");
    b1.setBounds(390,588,150,35);
    b1.addActionListener(this);
    l3.add(b1);
    
    b2 = new JButton("BACK");
    b2.setBounds(390,633,150,35);
    b2.addActionListener(this);
    l3.add(b2);
   
    
    setSize(960,1080);
    setUndecorated(true);
    setLocation(500,0);
    setVisible(true);
    }

	@Override
    public void actionPerformed(ActionEvent ae){
		 String amount;
        try{        
            amount = t1.getText();
            boolean amountflag=false;
            for(int i=0;i<amount.length();i++)
            {
            	if(amount.charAt(i)>='0'&&amount.charAt(i)<='9')
            	{
            		
            	}
            	else
            	{
            		amountflag=true;
            		break;
            	}
            }
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }
                else if(amountflag)
                {
                	JOptionPane.showMessageDialog(null, "Please enter digit to withdraw the money");
                }
                else if(Long.parseLong(amount)>10000)
                {
                	JOptionPane.showMessageDialog(null, "Please enter withdrawl value less than 10000");
                }
                	
                else{
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.statement.executeQuery("select * from bank where cardnumber= '"+cardno+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.statement.executeUpdate("insert into bank values('"+cardno+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(cardno).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(cardno).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }
	
	 
}
