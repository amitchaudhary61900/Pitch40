package com.pitch40.TestUtils;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.pitch40.utlities.AppiumUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidBaseTest extends AppiumUtils {


	public AndroidDriver driver;
	public AppiumDriverLocalService service;


	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws InterruptedException, IOException {
			
			Properties prop= new Properties();
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//pitch40//resources//data.properties");
			//ipAddress from cmd
			String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
			prop.load(fis);
//			String ipAddress= prop.getProperty("ipAddress");
			String port= prop.getProperty("port");
		
			service= startAppiumServer(ipAddress, Integer.parseInt(port));

			   //AdroidDriver, IOSDriver
				UiAutomator2Options options =new UiAutomator2Options();
				options.setDeviceName(prop.getProperty("AndroidEmulatorName"));
			//	options.setDeviceName("Android device");
				options.setApp(System.getProperty("user.dir")+"//src//test//java//com//pitch40//resources//app-release.apk");
				options.setCapability("autoGrantPermissions", true);
				options.setCapability("permissions", "location,camera");

				driver = new AndroidDriver(service.getUrl(), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Thread.sleep(3000);
				
				
	}	

				
				
				

	
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {

		driver.quit();
		service.stop();
	}

}
