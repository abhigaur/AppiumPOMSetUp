package appium;

import java.net.URL;

import javax.swing.plaf.synth.SynthScrollBarUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LanuchMyntra {

	public static AndroidDriver driver;
public static void main(String[] args) throws Exception {
DesiredCapabilities capabilities = new DesiredCapabilities();
System.out.println("test");
capabilities.setCapability("deviceName", "Android");
capabilities.setCapability("appPackage", "com.myntra.android");
capabilities.setCapability("appActivity", "com.myntra.android.activities.LoginRegisterActivity");
driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);


Thread.sleep(3000);



try {
	driver.findElementById("com.myntra.android:id/btn_signup").isDisplayed();
	//driver.findElementByAndroidUIAutomator("com.myntra.android:id/btn_signup").click();
} catch (Exception e) {
	// TODO Auto-generated catch block
	System.out.println("nnot presenet");
}

	}

}
