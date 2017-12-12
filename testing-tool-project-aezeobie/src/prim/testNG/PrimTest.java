package prim.testNG;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;


import prim.Node;
import prim.NodeNetwork;
import prim.Path;
import prim.Prim;

/**
 * Unit testing code for testing Prim class
 * @author Andrea
 * @version 1.0 9/20/2017
 *
 */

public class PrimTest { 
  	Node A, B, C, D;
  	Path path1, path2, path3, path4;
  	Path[] pathArray;
  	List<Node> list;
  	NodeNetwork nodeNet1, nodeNet2;
  	Prim prim1, prim2;
  	int weight1 = 10;
  	int weight2 = 20;
  	int weight3 = 15;
  	int weight4 = 44;
  	int size = 10;
  	/*
  	 @Test
  	  public void f() {
  	  }
  	  */
  	
  	/* This method is run before running every 
  	   test method (methods with @Test annotation) */
  	@BeforeTest 
  	public void runBeforeEveryTest(){
  		pathArray = new Path[size];  
  		A = new Node("A");
  		B = new Node("B");
  		C = new Node("C", path3);
  		D = new Node("D", pathArray);
  		path1 = new Path(weight1, B, C);
  		path2 = new Path(weight2, A, C);
  		path3 = new Path(weight3, B, D);
  		path4 = new Path(weight4, D, A);
          A.addPathWithoutSource(path2);	
          B.addPathWithoutSource(path1);
  		pathArray[0] = path3;   //populate path array
  		pathArray[1] = path2;
  		pathArray[2] = path4;
  		list = new ArrayList<>();
  		list.add(A);   //populate arrayList 
  		list.add(B);
  		list.add(C);
  		list.add(D);
  		nodeNet1 = new NodeNetwork(); //creating node networks
  		nodeNet2 = new NodeNetwork(list);
  		prim1 = new Prim(nodeNet1);  //creating prim objects	
  		prim2 = new Prim(nodeNet2);
  	}


  	/**
  	 * Test method for {@link prim.Prim#Prim(prim.NodeNetwork)}.
  	 */
  	@Test
  	public void testPrim() {
  		Assert.assertNotNull(prim1);
  	}

  	/**
  	 * Test method for {@link prim.Prim#findWholeCaravaneWithPrim()}.
  	 */
  	@Test
  	public void testFindWholeCaravaneWithPrim() {
  		Assert.assertNotNull(prim1.findWholeCaravaneWithPrim());
  		Assert.assertNotNull(prim2.findWholeCaravaneWithPrim());
  	}

  	/**
  	 * Test method for {@link prim.Prim#printWholeCaravaneWithPrim()}.
  	 */
  	@Test
  	public void testPrintWholeCaravaneWithPrim() {
  		prim1.printWholeCaravaneWithPrim();
  		prim2.printWholeCaravaneWithPrim();
  		
  	}
}


 

