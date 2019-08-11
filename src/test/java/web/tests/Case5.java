package web.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

//        5. Click on the Wiley logo at the top menu (left side of the top menu)
//        - Home page is opened

public class Case5 extends TestBase{
  String expectUrl = "https://www.wiley.com/en-us";

  @Test
  public void checkClickToLogo(){
    app.header().clickToLogo();
    String currentUrl = app.header().getPageUrl();

    Assert.assertEquals(currentUrl,expectUrl);
  }

  @AfterMethod
  public void returnToHome(){
    app.goToHomePage();
  }
}
