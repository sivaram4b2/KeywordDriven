package com.practice.Keyword.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	//siva
	//rama
	//krishna
	
	public WebDriver init_driver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Sivaram\\Downloads\\chromedriver\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			driver=new ChromeDriver(options);
		}
		
		return driver;
	}
	
	public Properties init_properties()
	{
		prop=new Properties();
		
		try {
			FileInputStream ip=new FileInputStream("D:\\Sivaram_Selenium\\KeywordDriven\\src\\main\\java\\com\\practice\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
	}

}
