package Appium;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    @BeforeTest
    public void  setup(){
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platfornName","");
        caps.setCapability(CapabilityType.PLATFORM_NAME,"ANDROID");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(CapabilityType.VERSION,"");
    }

    @AfterTest
    public  void teardown(){

    }
}
