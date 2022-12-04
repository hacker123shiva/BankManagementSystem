package atmSimulatorSystem;

import java.sql.*;
import java.util.Scanner;
import com.mysql.cj.jdbc.Driver;

public class Conn {
 
Connection conn=null;
Statement statement=null;
String url="jdbc:mysql://localhost:3306"; 
String username="root";
String password="root";

public Conn()
{try 
{//create Driver object
	Driver driver =new Driver();
//register driver
	DriverManager.registerDriver(driver);
conn=DriverManager.getConnection(url, username, password);
statement=conn.createStatement();
//create database if not exist
String query="Create Database if not exists bms";
//execute query 
statement.executeUpdate(query);

//use bms database
query="use bms";
statement.executeUpdate(query);

//create table signup
query="create table if not exists signup(formno varchar(20), name varchar(20), father_name varchar(20), dob varchar(30), gender varchar(20),email varchar(30), marital_status varchar(20), address varchar(40), city varchar(25), pincode varchar(20), state varchar(25))";
statement.executeUpdate(query);

//create table signuptwo
query="create table if not exists signuptwo(formno varchar(20), religion varchar(20), category varchar(20), income varchar(20), education varchar(20), occupation varchar(20), pan varchar(20), aadhar varchar(20), seniorcitizen varchar(20), existingaccount varchar(20))";
statement.executeUpdate(query);

//create table signupthree
query="create table if not exists signupthree(formno varchar(20), accountType varchar(40), cardnumber varchar(25), pin varchar(10), facility varchar(100))";
statement.executeUpdate(query);

//create table login
query="create table if not exists login(formno varchar(20), cardnumber varchar(25), pin varchar(10))";
statement.executeUpdate(query);

//create bank table
query="create table if not exists bank(pin varchar(10), date varchar(50), type varchar(20), amount varchar(20))";
statement.executeUpdate(query);
}

catch(SQLException e)
{
	System.out.println(e);
}
 
}
}
