package com.TrustedShops.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TrustedShopsBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Properties dataProp;
	
	
	public  TrustedShopsBase () throws IOException {
		FileInputStream fissource = new FileInputStream(
				"C:\\Users\\Thahir\\eclipse-workspaceNew\\TrustedShopsProj\\src\\main\\java\\com\\TrustedShops\\config\\config.properties");
		prop = new Properties();
		prop.load(fissource);
		
		FileInputStream fissource2 = new FileInputStream("C:\\Users\\Thahir\\eclipse-workspaceNew\\TrustedShopsProj\\src\\main\\java\\TrustedShops\\TestData\\TestData.properties");
			
		dataProp = new Properties();
		dataProp.load(fissource2);
	}

	@BeforeMethod
	public static void launchBrowser() throws IOException {

		String browserName = prop.getProperty("browser");

		{
			if (browserName.equalsIgnoreCase("chrome")) {

				driver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("edge")) {

				driver = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
}

	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}

