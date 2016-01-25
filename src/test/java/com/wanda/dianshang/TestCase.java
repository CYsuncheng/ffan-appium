package com.wanda.dianshang;

import org.testng.annotations.Test;

public class TestCase extends FFanAppiumDriver {

	@Test(groups = "SmokeTest")
	public void selectPlaza() throws Exception {
		Util.closeRedPocket();
		Util.runSteps(TestCaseName.selectPlaza);
	}

	@Test(groups = "SmokeTest")
	public void loginNormal() throws Exception {
		Util.closeRedPocket();
		Util.runSteps(TestCaseName.loginNormal);
	}

	@Test(groups = "SmokeTest", dependsOnMethods = "loginNormal")
	public void myTickets() throws Exception {
		this.loginNormal();
		Util.runSteps(TestCaseName.myTickets);
	}

	@Test(groups = "SmokeTest", dependsOnMethods = "loginNormal")
	public void myOrders() throws Exception {
		this.loginNormal();
		Util.runSteps(TestCaseName.myOrders);
	}

	@Test(groups = "SmokeTest", dependsOnMethods = "loginNormal")
	public void myRefund() throws Exception {
		this.loginNormal();
		Util.runSteps(TestCaseName.myRefund);
	}

}
