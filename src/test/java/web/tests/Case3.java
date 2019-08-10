package web.tests;

//        3. Click “Students” item
//        - Check that https://www.wiley.com/en-us/students url is opened
//        - Check that “Students” header is displayed
//        - Check that “Learn More” links are present on the page and direct to www.wileyplus.com site


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Case3 extends TestBase{
  String expectedPageUrl = "https://www.wiley.com/en-us/students";
  String expectedDirectUrl = "www.wileyplus.com";

  @Test
  public void goToStudentsPage(){

    app.home().goTo("Students");
    String currentPageUrl = app.students().getPageUrl();
    Boolean headerOfPageIsDisplayed = app.students().headerIsDisplayed("Students");
    List<String> directUrls = app.students().getUrlsOfLinks("Learn More");
    Assert.assertEquals(currentPageUrl,expectedPageUrl);
    Assert.assertTrue(headerOfPageIsDisplayed);
    directUrls.stream().forEach(p->Assert.assertTrue(p.contains(expectedDirectUrl)));
    }


  }



