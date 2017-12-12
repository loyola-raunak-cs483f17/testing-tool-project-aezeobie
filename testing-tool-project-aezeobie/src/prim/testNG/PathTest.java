package prim.testNG;

import org.testng.annotations.Test;
import org.testng.Assert;

import prim.Node;
import prim.Path;

import org.testng.annotations.BeforeTest;

public class PathTest {
   Node dest1, dest2, dest3;
	Path path1, path2, path3, path4, path5;
	int weight;
	
	/* This method is run before running every 
	   test method (methods with @Test annotation) */
	@BeforeTest
	public void beforeTest(){
		weight = 5;
		dest1 = new Node("dest1");
		dest2 = new Node("dest2");
		dest3 = new Node("dest3");
	    path1 = new Path(weight, dest1, dest2);
		path2 = new Path(weight, dest2, dest1);
		path3 = new Path(weight, dest1, dest3);
		path4 = new Path(weight, dest2, dest1);
		path5 = new Path(weight, dest3);
	}

	/**
	 * Test method for {@link prim.Path#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Assert.assertTrue(path1.equals(path2));
		Assert.assertFalse(path1.equals(path3));
		Assert.assertTrue(path2.equals(path4));
	}
	
	//Test constructor that takes weight and destination node as parameters
	@Test
	public void testPathIntNode() {
		Assert.assertNotNull(path5);
	}
	
	//Test getWeight()
	@Test
	public void testGetWeight() {
		Assert.assertEquals(5, path1.getWeight());		
	}
	
	//Test setSrcNode()
	@Test
	public void testSetSrcNode() {
		path5.setSrcNode(dest2);  //set the source node
		Assert.assertNotNull(path5.getSrcNode()); //check that the node was set by returning it
	}
	

}
