package prim.testNG;

import org.testng.annotations.Test;
import org.testng.Assert;

import prim.NodeNetFactory;

public class NodeNetFactoryTest {
NodeNetFactory nFactory;
	
	/**
	 * Test method for {@link prim.NodeNetFactory#buildNetwork()}.
	 */
	@Test
	public void testBuildNetwork() {
		nFactory = new NodeNetFactory();
		nFactory.buildNetwork();
		Assert.assertNotNull(nFactory);
	}

}
