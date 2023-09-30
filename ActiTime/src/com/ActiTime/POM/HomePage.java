package com.ActiTime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebElement getTimeTrack() {
		return timeTrack;
	}

	public WebElement getTasks() {
		return tasks;
	}

	public WebElement getReports() {
		return reports;
	}

	public WebElement getUsers() {
		return users;
	}

	public WebElement getLogOut() {
		return logOut;
	}

	@FindBy(xpath = "//div[.='Time-Track']")
	private WebElement timeTrack;
	
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement tasks;
	
	@FindBy(xpath = "//div[.='Reports']")
	private WebElement reports;
	
	@FindBy(xpath = "//div[.='Users']")
	private WebElement users;
	
	@FindBy(partialLinkText = "Logout")
	private WebElement logOut;
	
	public HomePage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
}