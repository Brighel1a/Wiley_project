package web.tests;


//        6. Do not enter anything in the search input and press search button
//        - Nothing happens, header page is still displayed


import org.testng.Assert;
import org.testng.annotations.Test;

public class Case6 extends TestBase{

  @Test
  public void checkPageDisplayedAfterSerch(){
    boolean pageDisplayed = app.search().checkReloadPegeAfterSeerch();

    Assert.assertTrue(pageDisplayed);
  }


}
