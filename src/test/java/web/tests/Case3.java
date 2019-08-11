package web.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.List;


//        3. Click “Students” item
//        - Check that https://www.wiley.com/en-us/students url is opened
//        - Check that “Students” header is displayed
//        - Check that “Learn More” links are present on the page and direct to www.wileyplus.com site

public class Case3 extends TestBase{
  String expectedPageUrl = "https://www.wiley.com/en-us/students";
  String expectedDirectUrl = "www.wileyplus.com";

  @Test
  public void goToStudentsPage(){

    app.home().goTo("Students");
    String currentPageUrl = app.students().getPageUrl();
    app.students().checkHeaderIsDisplayed("Students");
    List<String> directUrls = app.students().getUrlsOfLinks("Learn More");
    Assert.assertEquals(currentPageUrl,expectedPageUrl);
    directUrls.stream().forEach(p->Assert.assertTrue(p.contains(expectedDirectUrl)));
    }

  @AfterMethod
  public void returnToHome(){
    app.goToHomePage();
  }
  }



