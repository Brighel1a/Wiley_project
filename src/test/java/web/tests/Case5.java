package web.tests;

//        5. Click on the Wiley logo at the top menu (left side of the top menu)
//        - Home page is opened


import org.testng.Assert;
import org.testng.annotations.Test;

public class Case5 extends TestBase{
  String expectUrl = "https://www.wiley.com/en-us";

  @Test
  public void checkClickToLogo(){
    app.header().clickToLogo();
    String currentUrl = app.header().getPageUrl();

    Assert.assertEquals(currentUrl,expectUrl);
  }

}
