package com.wanda.dianshang;

public class Constant {
	/**
	 * 记录待测试App的路径,名称,URL端口等
	 */
	public static String AppPath = "C:\\Users\\CYsuncheng\\Downloads";
	public static String AppName = "ffan.apk";
	public static String SessionURL = "http://127.0.0.1:4723/wd/hub";

	/**
	 * 记录截图存放路径
	 */
	public static String ScreenShotPath = "G:\\Apptest\\test-output\\Screenshot\\";

	/**
	 * 记录数据存储的路径
	 */
	public static String XMLDataPath = "G:\\Apptest\\data\\TestData.xml";
	public static String ExcelDataPath = "G:\\Apptest\\data\\TestCaseData.xls";

	/**
	 * 登录页面用户名和密码resourceid
	 */
	public static String UN = "com.wanda.app.wanhui:id/edit_login_name";
	public static String PW = "com.wanda.app.wanhui:id/widget_input";

	/*
	 * public enum tpye { id, name, xpath, classname; }
	 */
}
