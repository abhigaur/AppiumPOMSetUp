package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;

public class TestBase {

	public static AndroidDriver driver;
	DesiredCapabilities capabilities;
	public static WebDriverWait wait;

	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");

	@BeforeSuite
	public void setUp() throws MalformedURLException {

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			try {
				Config.load(fis);
				System.out.println("test");

				System.out.println("config file loaded");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (Config.getProperty("device.name").equalsIgnoreCase("Android")) {

			capabilities = new DesiredCapabilities();

			capabilities.setCapability("deviceName", Config.getProperty("device.name"));
			capabilities.setCapability("appPackage", Config.getProperty("app.package"));
			capabilities.setCapability("appActivity", Config.getProperty("app.activity"));
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		}
	}

	@AfterSuite
	public void tearDown() {

		driver.quit();
	}

}
