package prim.testNG;

import org.testng.annotations.Test;
import org.testng.Assert;

import prim.Node;
import prim.Path;

import org.testng.annotations.BeforeTest;

public class NodeTest {
  
  Node node1, node2, node3, node4, node5;
	Node destNode;
	Path path, path1, path2, path3;
	int weight;
	
	/* This method is run before running every 
	   test method (methods with @Test annotation) */
	@BeforeTest
	public void beforeTest(){
		weight = 5;
		destNode = new Node("dest");
	    path = new Path(weight, destNode);
	    path1 = new Path(weight, node1, node2);
	    path2 = new Path(weight, node2, node1);
	    path3 = new Path(weight, node1, node3);
		node1 = new Node("n1");
		node2 = new Node("n2", path);
		node3 = new Node("n3", path1);
		node4 = new Node("n3", path2);
		node5 = new Node("n5", path3);
	}

	/**
	 * Test method for {@link prim.Node#Node(java.lang.String, prim.Path[])}.
	 */
	@Test
	public void testNodeStringPathArray() {
		Assert.assertNotNull(node2);
	}

	/**
	 * Test method for {@link prim.Node#Node(java.lang.String)}.
	 */
	@Test
	public void testNodeString() {
		Assert.assertNotNull(node1);
	}

	/**
	 * Test method for {@link prim.Node#getPaths()}.
	 */
	@Test
	public void testGetPaths() {
		Assert.assertNotNull(node2.getPaths());
	}

	/**
	 * Test method for {@link prim.Node#addPathWithoutSource(prim.Path)}.
	 */
	@Test
	public void testAddPathWithoutSource() {
		node1.addPathWithoutSource(path); //adding path 
		Assert.assertNotNull(node1.getPaths()); //check that the path created is not null
	}

	/**
	 * Test method for {@link prim.Node#getName()}.
	 */
	@Test
	public void testGetName() {
		Assert.assertNotNull(node1.getName()); 
	}

	/**
	 * Test method for {@link prim.Node#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Assert.assertFalse(node1.equals(node2));
		Assert.assertTrue(node3.equals(node4));
		Assert.assertFalse(node3.equals(node5));
	}

}
