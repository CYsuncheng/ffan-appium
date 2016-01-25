package com.wanda.dianshang;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class FFanAppiumDriver {
	static AndroidDriver<WebElement> driver;
	static AppiumDriverLocalService service;

	/*
	 * 开启Appium服务
	 * 
	 */
	@BeforeClass(alwaysRun = true)
	public void launchAppium() throws Exception {
		try {
			String cmdStr = "cmd.exe /k start appium";
			Runtime.getRuntime().exec(cmdStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Util.sleep(5);
	}

	// @AfterClass(alwaysRun = true)
	// public void closeAppium() throws Exception {
	// try {
	// String cmdStr = "cmd /c start wmic process where name='cmd.exe' call
	// terminate";
	// Runtime.getRuntime().exec(cmdStr);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// Util.sleep(10);
	// }

	// @BeforeClass
	// public static void beforeClass() throws Exception {
	// service = AppiumDriverLocalService.buildDefaultService();
	// service.start();
	// }

	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception {
		// if (service == null || !service.isRunning())
		// throw new RuntimeException("An appium server node is not started!");
		File appDir = new File(Constant.AppPath);
		File app = new File(appDir, Constant.AppName);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		// driver = new AndroidDriver<WebElement>(service.getUrl(),
		// capabilities);
		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");
		driver = new AndroidDriver<WebElement>(new URL(Constant.SessionURL), capabilities);
		driver.resetApp();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}
}