package Oct_20;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleExtentReport 
{
  @Test
  public void A() 
  {
	  Assert.assertEquals("aaa", "aaa");
	  System.out.println("A.....");
  }
  
  @Test
  public void B() 
  {
	  Assert.assertEquals("aaa", "bbb");
	  System.out.println("B.....");
  }
}
