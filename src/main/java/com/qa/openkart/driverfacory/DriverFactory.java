package com.qa.openkart.driverfacory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	private WebDriver driver;
	private Properties prop;
	private FileInputStream ip;
	private OptionManager op;
	private ChromeOptions co;

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public WebDriver Launchbrowser(Properties prop) {

		op = new OptionManager(prop);
		String browsername = prop.getProperty("browser").trim().toLowerCase();
		System.out.println("Lanuched Browser is: " + browsername);
		switch (browsername) {
		case "chrome":
			co = op.browserOption();
			tldriver.set(new ChromeDriver(co));
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Please pass the valid browser..." + browsername);
			break;
		}

		getthreadlocal().manage().deleteAllCookies();
		getthreadlocal().manage().window().maximize();
		getthreadlocal().get(prop.getProperty("url"));
		return getthreadlocal();

	}

	public static synchronized WebDriver getthreadlocal() {
		return tldriver.get();
	}

	public Properties intiProp() {
		prop = new Properties();
		try {
			ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot)getthreadlocal()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		File desFile = new File(path);
		try {
			FileHandler.copy(srcFile,desFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		
		
	}
	
	
	

}
