package appium;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ScrollTo {


public static AndroidDriver<MobileElement> driver;
public static void main(String[] args) throws Exception {
DesiredCapabilities capabilities = new DesiredCapabilities();
System.out.println("test");
capabilities.setCapability("deviceName", "Android");
capabilities.setCapability("appPackage", "com.android.dialer");
capabilities.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	
	
	

}
}
