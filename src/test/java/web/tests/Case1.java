package web.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import web.util.Headers;

//Part 1. Java and Selenium WebDriver
//        1. Open https://www.wiley.com/en-us
//        Check the following links are displayed in the top menu
//        - Who We Serve
//        - Subjects
//        - About

public class Case1 extends TestBase{

  @Test
  public void checkDisplayedLinks() {
    app.header().checkLinkIsDisplayed(Headers.WHO_WE_SERVE.getValue());
    app.header().checkLinkIsDisplayed(Headers.SUBJECTS.getValue());
    app.header().checkLinkIsDisplayed(Headers.ABOUT.getValue());
  }

  @AfterMethod
  public void returnToHome(){
    app.goToHomePage();
  }
}
