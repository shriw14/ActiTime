package com.ActiTime.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ActiTime.GenericLibrary.BaseClass;
import com.ActiTime.GenericLibrary.FileLibrary;
import com.ActiTime.POM.HomePage;
import com.ActiTime.POM.TaskPage;

public class CreateCustomer extends BaseClass {
		@Test
		public void createCustomer() throws EncryptedDocumentException, IOException
		{
		HomePage hp = new HomePage(dr);
		hp.getTasks().click();
		TaskPage tp = new TaskPage(dr);
		tp.getAddNewButton().click();
		tp.getNewCust().click();
		FileLibrary fl = new FileLibrary();
		String Name = fl.readDataFromExcelSheet("Sheet1", 1, 2);
		tp.getNewCustTxt().sendKeys(Name);
		String Desp = fl.readDataFromExcelSheet("Sheet1", 2, 2);
		tp.getNewCustDespTxt().sendKeys(Desp);
		tp.getClickButton().click();
		String ExpectedResult = Name;
		String ActualResult = dr.findElement(By.xpath("(//div[.='"+Name+"'])[2]")).getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ExpectedResult, ActualResult);
		sa.assertAll();
		}
}