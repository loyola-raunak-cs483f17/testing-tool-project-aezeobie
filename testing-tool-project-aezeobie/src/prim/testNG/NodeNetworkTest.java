package prim.testNG;

import org.testng.annotations.Test;
import org.testng.Assert;

import prim.Node;
import prim.NodeNetwork;
import prim.Path;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeTest;

public class NodeNetworkTest { 
  NodeNetwork nodeNetwork1, nodeNetwork2, nodeNetwork3;
	Node node1, node2;
	Path p1;
	List<Node> list;
	Node [] array;
	int size = 10;
	int weight = 3;
	
	/* This method is run before running every 
	   test method (methods with @Test annotation) */
	@BeforeTest
	public void beforeTest(){
		node2 =  new Node("B");
		p1 = new Path(weight, node2);
		node1 = new Node("A", p1);
		list = new ArrayList<>();
		list.add(node1);
		list.add(node2);
		array = new Node [size];
		nodeNetwork1 = new NodeNetwork();	
		nodeNetwork2 = new NodeNetwork(list);
		nodeNetwork3 = new NodeNetwork(array);
	}


	/**
	 * Test method for {@link prim.NodeNetwork#NodeNetwork()}.
	 */
	@Test
	public void testNodeNetwork() {
		Assert.assertNotNull(nodeNetwork1);
	}

	/**
	 * Test method for {@link prim.NodeNetwork#NodeNetwork(java.util.List)}.
	 */
	@Test
	public void testNodeNetworkListOfNode() {
		Assert.assertNotNull(nodeNetwork2);
	}

	/**
	 * Test method for {@link prim.NodeNetwork#NodeNetwork(prim.Node[])}.
	 */
	@Test
	public void testNodeNetworkNodeArray() {
		Assert.assertNotNull(nodeNetwork3);
	}

	/**
	 * Test method for {@link prim.NodeNetwork#addNode(prim.Node)}.
	 */
	@Test
	public void testAddNode() {
		//addNode() is a protected method within the NodeNetwork class 
		//and is not accessed by any other methods in that class so I was
		// not able to test it
		
	}

	/**
	 * Test method for {@link prim.NodeNetwork#getNodes()}.
	 */
	@Test
	public void testGetNodes() {
		Assert.assertNotNull(nodeNetwork2.getNodes());
	}

	/**
	 * Test method for {@link prim.NodeNetwork#toString()}.
	 */
	@Test
	public void testToString() {
		Assert.assertNotNull(nodeNetwork1.toString());
		Assert.assertNotNull(nodeNetwork2.toString());
	}

}
