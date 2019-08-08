package web.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

//Part 1. Java and Selenium WebDriver
//        1. Open https://www.wiley.com/en-us
//        Check the following links are displayed in the top menu
//        - Who We Serve
//        - Subjects
//        - About

public class Case1 extends TestBase{
  Boolean linkWhoWeServe;
  Boolean linkSubjects;
  Boolean linkAbout;

  @Test
  public void checkDisplayedLinks() {
    linkWhoWeServe = app.header().findLink("WHO WE SERVE");
    linkSubjects = app.header().findLink("SUBJECTS");
    linkAbout = app.header().findLink("ABOUT");

    Assert.assertTrue(linkWhoWeServe);
    Assert.assertTrue(linkSubjects);
    Assert.assertTrue(linkAbout);
  }


}
