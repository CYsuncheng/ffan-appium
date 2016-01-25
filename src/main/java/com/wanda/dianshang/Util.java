package com.wanda.dianshang;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Util extends FFanAppiumDriver {

	private static Logger logger = Logger.getLogger(Util.class);

	private static String message; // 提示信息

	/**
	 * 封装截图方法
	 * 
	 * @throws Exception
	 */
	public static void captureScreenShot() throws Exception {
		Util.sleep(1);
		logger.info("capture the screenshot ");
		String name = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String path = Constant.ScreenShotPath;
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(path + name + ".jpg"));
		Util.sleep(1);
	}

	/**
	 * 根据控件类型不同，分别getElement
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */

	public static WebElement getElementByID(String value) throws Exception {
		WebElement element = driver.findElement(MobileBy.id(value));
		Util.sleep(1);
		return element;
	}

	public static WebElement getElementByName(String value) throws Exception {
		WebElement element = driver.findElement(MobileBy.name(value));
		Util.sleep(1);
		return element;
	}

	public static WebElement getElementByClassName(String value) throws Exception {
		WebElement element = driver.findElement(MobileBy.className(value));
		Util.sleep(1);
		return element;
	}

	public static WebElement getElementByXPath(String value) throws Exception {
		WebElement element = driver.findElement(MobileBy.xpath(value));
		Util.sleep(1);
		return element;
	}

	/**
	 * 根据控件类型获取元素列表
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static List<WebElement> getElementsByID(String value) throws Exception {
		List<WebElement> elements = driver.findElements(MobileBy.id(value));
		Util.sleep(1);
		return elements;
	}

	public static List<WebElement> getElementsByName(String value) throws Exception {
		List<WebElement> elements = driver.findElements(MobileBy.name(value));
		Util.sleep(1);
		return elements;
	}

	public static List<WebElement> getElementsByClassName(String value) throws Exception {
		List<WebElement> elements = driver.findElements(MobileBy.className(value));
		Util.sleep(1);
		return elements;
	}

	public static List<WebElement> getElementsByXPath(String value) throws Exception {
		List<WebElement> elements = driver.findElements(MobileBy.xpath(value));
		Util.sleep(1);
		return elements;
	}

	/**
	 * 获取控件后进行点击操作
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static void clickByID(String value) throws Exception {
		getElementByID(value).click();
		Util.sleep(1);
	}

	public static void clickByName(String value) throws Exception {
		getElementByName(value).click();
		Util.sleep(1);
	}

	public static void clickByClassName(String value) throws Exception {
		getElementByClassName(value).click();
		Util.sleep(1);
	}

	public static void clickByXPath(String value) throws Exception {
		getElementByXPath(value).click();
		Util.sleep(1);
	}

	/**
	 * 根据index点击列表中的一项
	 * 
	 * @param value
	 * @param index
	 * @throws Exception
	 */
	public static void clickOneOfListByID(String value, int index) throws Exception {
		List<WebElement> list = Util.getElementsByID(value);
		list.get(index).click();
		Util.sleep(1);
	}

	public static void clickOneOfListByName(String value, int index) throws Exception {
		List<WebElement> list = Util.getElementsByName(value);
		list.get(index).click();
		Util.sleep(1);
	}

	public static void clickOneOfListByClassName(String value, int index) throws Exception {
		List<WebElement> list = Util.getElementsByClassName(value);
		list.get(index).click();
		Util.sleep(1);
	}

	/**
	 * 点击遍历列表中的每一项，并截图
	 * 
	 * @param value
	 * @throws Exception
	 */
	public static void clickEachByID(String value) throws Exception {
		List<WebElement> list = Util.getElementsByID(value);
		for (Iterator<WebElement> i = list.iterator(); i.hasNext();) {
			WebElement item = i.next();
			item.click();
			Util.sleep(2);
			Util.captureScreenShot();
			Util.sleep(1);
			Util.back();
			Util.sleep(1);
		}
	}

	public static void clickEachByName(String value) throws Exception {
		List<WebElement> list = Util.getElementsByName(value);
		for (Iterator<WebElement> i = list.iterator(); i.hasNext();) {
			WebElement item = i.next();
			item.click();
			Util.sleep(2);
			Util.captureScreenShot();
			Util.sleep(1);
			Util.back();
			Util.sleep(1);
		}
	}

	public static void clickEachByClassName(String value) throws Exception {
		List<WebElement> list = Util.getElementsByClassName(value);
		for (Iterator<WebElement> i = list.iterator(); i.hasNext();) {
			WebElement item = i.next();
			item.click();
			Util.sleep(2);
			Util.captureScreenShot();
			Util.sleep(1);
			Util.back();
			Util.sleep(1);
		}
	}

	/**
	 * 根据控件进行输入操作
	 * 
	 * @param value
	 * @param inputvalue
	 * @throws Exception
	 */
	public static void inputByID(String value, String s) throws Exception {
		Util.getElementByID(value).sendKeys(s);
		Util.sleep(1);
	}

	public static void inputByClassName(String value, String s) throws Exception {
		Util.getElementByID(value).sendKeys(s);
		Util.sleep(1);
	}

	public static void inputByXPath(String value, String s) throws Exception {
		Util.getElementByXPath(value).sendKeys(s);
		Util.sleep(1);
	}

	/**
	 * 等待元素出现，时间为60s
	 * 
	 * @param value
	 * @param sec
	 * @throws Exception
	 */
	public static void waitByID(String value) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(value)));
		Util.sleep(1);
	}

	public static void waitByName(String value) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(value)));
		Util.sleep(1);
	}

	public static void waitByClassName(String value) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(value)));
		Util.sleep(1);
	}

	public static void waitElementByXPath(String value) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
		Util.sleep(1);
	}

	/**
	 * 获取目标元素的文本
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static String getTextByID(String value) throws Exception {
		String text = Util.getElementByID(value).getText();
		Util.sleep(1);
		return text;
	}

	public static String getTextByName(String value) throws Exception {
		String text = Util.getElementByName(value).getText();
		Util.sleep(1);
		return text;
	}

	public static String getTextByClassName(String value) throws Exception {
		String text = Util.getElementByClassName(value).getText();
		Util.sleep(1);
		return text;
	}

	public static String getTextByXPath(String value) throws Exception {
		String text = Util.getElementByXPath(value).getText();
		Util.sleep(1);
		return text;
	}

	/**
	 * 返回键
	 * 
	 * @throws InterruptedException
	 */
	public static void back() throws Exception {
		logger.info("tap the back key");
		driver.pressKeyCode(4);
		Util.sleep(1);
	}

	/**
	 * 输入完成后隐藏键盘
	 * 
	 * @throws Exception
	 */
	public static void hideKeyboard() throws Exception {
		driver.hideKeyboard();
		Util.sleep(1);
	}

	/**
	 * 线程睡眠
	 * 
	 * @param sec
	 * @throws Exception
	 */
	public static void sleep(int sec) throws Exception {
		Thread.sleep(sec * 1000);
	}

	/**
	 * 封装根据坐标点击的方法，此方法适用于context 切换到webview时 x,y 分别是屏幕的坐标值
	 * 
	 * @param x
	 * @param y
	 * @param duration
	 * @param driver
	 */
	public static void clickScreen(int x, int y, int duration, AndroidDriver<?> driver) throws Exception {
		logger.info("tap the screen at " + "X : " + x + " " + "Y : " + y + " duration : " + duration);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Integer> tapObject = new HashMap<String, Integer>();
		tapObject.put("x", x);
		tapObject.put("y", y);
		tapObject.put("duration", duration);
		js.executeScript("mobile: tap", tapObject);
		Util.sleep(1);
	}

	/**
	 * 封装切换context到native方法
	 * 
	 * @throws Exception
	 */
	public void switchContextsToNative() throws Exception {
		logger.info("switch context from webview to native");
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName);
			if (contextName.contains("NATIVE")) {
				driver.context(contextName);
			} else {
				System.out.println("no NATIVE");
			}
		}
		Util.sleep(1);
	}

	/**
	 * 封装切换context到webview方法
	 * 
	 * @throws Exception
	 */
	public void switchContextsToWebview() throws Exception {
		logger.info("switch context from native to webview");
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName);
			if (contextName.contains("WEBVIEW")) {
				driver.context(contextName);
			} else {
				System.out.println("no WEBVIEW");
			}
		}
		Util.sleep(1);
	}

	/**
	 * 验证元素是否存在
	 * 
	 * @param actual
	 * @throws Exception
	 */
	public static void assertNullByID(String actual) throws Exception {
		org.testng.Assert.assertNull(Util.getElementByID(actual));
	}

	public static void assertNullByName(String actual) throws Exception {
		org.testng.Assert.assertNull(Util.getElementByName(actual));
	}

	public static void assertNotNullByName(String actual) throws Exception {
		org.testng.Assert.assertNotNull(Util.getElementByName(actual));
	}

	public static void assertNotNullByID(String actual) throws Exception {
		org.testng.Assert.assertNotNull(Util.getElementByID(actual));
	}

	/**
	 * 根据方法名调用
	 * 
	 * @param method
	 * @param value
	 * @throws Exception
	 */
	public static void invokeMethod(String method, String value) throws Exception {
		Method m = Util.class.getMethod(method, String.class);
		m.invoke(null, value);
		Util.sleep(1);
	}

	/**
	 * 根据读取的Excel文件数据遍历运行脚本
	 * 
	 * @throws Exception
	 */
	public static void runSteps(String casename) throws Exception {
		int steps = GetData.getSteps(Constant.ExcelDataPath, casename);
		for (int j = 1; j < steps; j++) {
			String m = GetData.getMethods(Constant.ExcelDataPath, casename).get(j - 1);
			String v = GetData.getValues(Constant.ExcelDataPath, casename).get(j - 1);
			Util.invokeMethod(m, v);
		}
	}

	/**
	 * 用户关闭App开启时的红包选项
	 */
	public static void closeRedPocket() {
		try {
			Util.sleep(3);
			WebElement element = Util.getElementByID("com.wanda.app.wanhui:id/iv_back_red_packet");
			element.click();
			Util.sleep(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 临时方法，输入用户名密码，待后续找到方法后可以删除
	 * 
	 * @param s
	 * @throws Exception
	 */
	public static void inputUN(String s) throws Exception {
		Util.sleep(1);
		Util.inputByID(Constant.UN, s);
		Util.sleep(1);
	}

	public static void inputPW(String s) throws Exception {
		Util.sleep(1);
		Util.inputByID(Constant.PW, s);
		Util.sleep(1);
	}

}
