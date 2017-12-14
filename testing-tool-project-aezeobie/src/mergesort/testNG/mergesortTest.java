package mergesort.testNG;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import mergesort.MergeSort;

public class mergesortTest {
  MergeSort ms1, ms2;	
  int seed1, seed2,seed3;
  int size1, size2, size3;
  int numThreads1, numThreads2, numThreads3;
	
  @BeforeTest
  public void beforeTest() {
	  seed1 = 10;
	  seed2 = 50;
	  size1 = 8;
	  size2 = 16;
	  numThreads1 = 2;
	  numThreads2 = 4;
	  ms1= new MergeSort(seed1, size1, numThreads1);
	  ms2 = new MergeSort(seed2, size2, numThreads2);
  }
  
  @Test
  public void testMergeSort() {
	  Assert.assertNotNull(ms1);
	  
  }
  
  //one example of the threading functionality
  //some code adjustments were made for the sake of the test method
  @Test(threadPoolSize = 4, invocationCount = 16, timeOut = 1000)
  public void testmergesort() {
	  ms2.mergesort(ms2.ints, 0, size2 - 1, numThreads2);	  
	  //for(int x: arr)
	  //System.out.print(x);
  }

}
