package com.ActiTime.GenericLibrary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import javax.sql.rowset.serial.SerialException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ActiTime.POM.LoginPage;

public class BaseClass 
{
	FileLibrary f = new FileLibrary();
	String url = "jdbc:mysql://localhost:3306?user=root&password=root"; 
	String fqcn = "com.mysql.jdbc.Driver";
	String qry = "select cust_name, cust_desc from customer.cust_info where cust_id = 1";
	protected static WebDriver dr;
	Connection con;
	Statement stmt;
	String s,s2;
	
	@BeforeSuite
	public void databaseConnection() throws ClassNotFoundException, SQLException 
	{
		Class.forName(fqcn);
		Connection con = DriverManager.getConnection(url);
		Reporter.log("Database connected ",true);		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(qry);
		while(rs.next())
		{
		String s = rs.getString("cust_name");
		String s2 =rs.getString("cust_desc");
		System.out.println(s);
		System.out.println(s2);
		}
	
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException
	{
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		FileLibrary f = new FileLibrary();
		String link = f.readDataFromPropertyFile("url");
		dr.get(link);
		Reporter.log("Browser Launched Successfully",true);
	}
	
	@BeforeMethod
	public void loginToActiTime() throws IOException
	{
		String un = f.readDataFromPropertyFile("username");
		String pw = f.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(dr); 
		lp.getUntbx().sendKeys(un);
		lp.getPwtbx().sendKeys(pw);
		lp.getLgbtn().click();
		Reporter.log("Logged In Successfully",true);		
	}
	
	@AfterMethod
	public void LogoutFromActiTime()
	{
		dr.findElement(By.id("logoutLink")).click();
		Reporter.log("Logged out Successfully",true);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		dr.close();
		Reporter.log("Browser Closed",true);
	}
	
	@AfterSuite
	public void closeDatabaseConn() throws SQLException
	{
		 if (con != null) {
		      try {
		        con.close();
		      }
		      catch (Throwable ex) {
		     
		      }
		Reporter.log("Database connection Closed",true);
	}
	}
}
