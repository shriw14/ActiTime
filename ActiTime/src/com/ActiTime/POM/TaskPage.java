package com.ActiTime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	public WebElement getTaskButton() {
		return TaskButton;
	}

	public WebElement getAddNewButton() {
		return addNewButton;
	}

	public WebElement getNewCust() {
		return NewCust;
	}

	public WebElement getNewCustTxt() {
		return newCustTxt;
	}

	public WebElement getNewCustDespTxt() {
		return newCustDespTxt;
	}

	public WebElement getClickButton() {
		return ClickButton;
	}

	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement TaskButton;
	
	@FindBy(xpath = "//div[.='Add New']")
			private WebElement addNewButton;
	
	@FindBy(xpath ="//div[.='+ New Customer']")
			private WebElement NewCust;
	
	@FindBy(xpath = "//input[@class='inputFieldWithPlaceholder newNameField inputNameField']")
			private WebElement newCustTxt;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement newCustDespTxt;
	
	@FindBy(xpath = "//div[.='Create Customer']")
	private WebElement ClickButton;
	
	public TaskPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	
	
	
}