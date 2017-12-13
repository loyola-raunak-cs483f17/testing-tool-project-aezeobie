package testgroup;

//retrieved from: http://easybix.com/test-groups-testng/

import org.testng.annotations.Test;

public class TestGroup {

	// Add the test group using group keyword
	@Test(groups = "Smoke")
	public void firstSmokeTest() {
		System.out.println("Smoke - First Test");
	}

	@Test(groups = "Sanity")
	public void firstSanityTest() {
		System.out.println("Sanity - Second Test");
	}
}