package com.qa.openkart.driverfacory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.openkart.Exception.FrameWorkException;

public class DriverFactory {

	private WebDriver driver;
	private Properties prop;
	private FileInputStream ip;
	private OptionManager op;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public WebDriver Launchbrowser(Properties prop) {

		op = new OptionManager(prop);
		String browsername = prop.getProperty("browser").trim().toLowerCase();
		System.out.println("Lanuched Browser is: " + browsername);
		switch (browsername.toLowerCase().trim()) {
		case "chrome":

			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("chrome");
				System.out.println("Driver created ");
			} else {
				tldriver.set(new ChromeDriver(co));
			}
			break;
		case "edge":
			eo = op.edgeopt();
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("edge");
			} else {
				tldriver.set(new EdgeDriver(eo));
				System.out.println("Driver created ");
			}
			break;

		case "safari":
			driver = new SafariDriver();
			break;
		case "firefox":
			fo = op.firefoxopt();
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("firefox");
			} else {
				tldriver.set(new FirefoxDriver(fo));
				System.out.println("Driver created ");
			}
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

	private void init_remoteDriver(String browser) {
		try {
		switch (browser.toLowerCase().trim()) {
		case "chrome":
			tldriver.set(new RemoteWebDriver(new URL(prop.getProperty("cloudhub")), op.browserOption()));
			break;
		case "edge":
			tldriver.set(new RemoteWebDriver(new URL(prop.getProperty("cloudhub")), op.edgeopt()));
			break;
		case "firefox":
			tldriver.set(new RemoteWebDriver(new URL(prop.getProperty("cloudhub")), op.firefoxopt()));
			break;
			
		default:
			System.out.println("Please pass the valid browser..."+ browser);
			throw new  FrameWorkException("NOREMOTEWEBDRIVEREXCEPTION");
		}
		}catch (MalformedURLException e ) {
			// TODO: handle exception
		}

	}

	

	
	public static synchronized WebDriver getthreadlocal() {
		return tldriver.get();
	}

	public Properties intiProp() {
		FileInputStream ip = null;
		prop = new Properties();
		String envName = System.getProperty("env");
		System.out.println("Execution Evnrionment is: " + envName);
		try {
			if (envName == null) {
				ip = new FileInputStream("src/test/resources/config/config.properties");
			} else {
				switch (envName.toLowerCase().trim()) {
				case "qa":
					ip = new FileInputStream("src/test/resources/config/qa.config.properties");
					break;
				case "prod":
					ip = new FileInputStream("src/test/resources/config/config.properties");
					break;
				default:
					System.out.println("Please Enter the valid Environment!....");
					throw new FrameWorkException("WRONG ENVIRONMENT HAS BEEN USED");
//				break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	public static String getScreenshot() {

		File srcFile = ((TakesScreenshot) getthreadlocal()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File distination = new File(path);

		try {
			FileUtil.copyFile(srcFile, distination);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;

	}

}
