package stack.testNG;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import stack.Stack;

public class StackTest {
  Stack stack1, stack2, stack3;
  int size = 3;
  Object x, y, z;
  Object a,b,c;
 
  @BeforeTest
  public void beforeTest() {
	  stack1 = new Stack(size);
	  stack3 = new Stack(size);
	  stack3.push(c);
	  stack3.push(b);
  }
  
  @Test
  public void checkStack() {
	  Assert.assertNotNull(stack1);
	  Assert.assertNull(stack2);
  }
  
  @Test(groups = "empty")
  public void checkisEmpty() {
	 Assert.assertTrue(stack1.isEmpty());
	 stack1.push(x);
	 Assert.assertFalse(stack1.isEmpty());
	 stack1.push(y);
	 stack1.push(z);
  }
  
  @Test()
  public void checkisFull() {
	  Assert.assertTrue(stack1.isFull());	 
	  Assert.assertFalse(stack3.isFull());
  }
  
  @Test
  public void checkTop() {
	  stack3.push(a);
	  Assert.assertEquals(stack3.top(), a);
	  stack3.pop();
	  stack2 = new Stack(size);
	  Assert.assertNull(stack2.top());
  }
  
  @Test(dependsOnGroups= "empty")
  public void checkPop() {
	  stack1.pop();
	  stack1.pop();
	  stack1.pop();
	  Assert.assertTrue(stack1.isEmpty());
  }
  
}
