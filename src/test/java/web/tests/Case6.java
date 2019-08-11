package web.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

//        6. Do not enter anything in the search input and press search button
//        - Nothing happens, header page is still displayed

public class Case6 extends TestBase{

  @Test
  public void checkPageDisplayedAfterSerch(){
    app.search().clickSerchButton();
    Assert.assertTrue(app.search().getIsPageReloaded());
  }

  @AfterMethod
  public void returnToHome(){
    app.goToHomePage();
  }
}
