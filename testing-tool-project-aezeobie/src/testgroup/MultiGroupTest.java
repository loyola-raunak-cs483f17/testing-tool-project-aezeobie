package testgroup;

//retrieved from: http://easybix.com/test-groups-testng/

import org.testng.annotations.Test;

public class MultiGroupTest {


	@Test(groups = "Regression")
	public void firstTest() {
		System.out.println("Regression - First Test");
	}

	// Declare multiple Groups
	@Test(groups = { "Regression", "Smoke" })
	public void secondTest() {
		System.out.println("Regression + Smoke - Second Test");
	}

	// Declare multiple Groups
	@Test(groups = { "Regression", "Sanity" })
	public void thirdTest() {
		System.out.println("Regression + Sanity - Third Test");
	}

	// Declare multiple Groups
	@Test(groups = { "Smoke", "Sanity" })
	public void forthTest() {
		System.out.println("Smoke + Sanity - Forth Test");
	}
}
