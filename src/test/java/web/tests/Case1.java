package web.tests;

//Part 1. Java and Selenium WebDriver
//        1. Open https://www.wiley.com/en-us
//        Check the following links are displayed in the top menu
//        - Who We Serve
//        - Subjects
//        - About


import org.testng.Assert;
import org.testng.annotations.Test;

public class Case1 extends TestBase{
  Boolean linkWhoWeServe;
  Boolean linkSubjects;
  Boolean linkAbout;

  @Test
  public void checkDisplayedLinks() {
    linkWhoWeServe = app.home().findLink("WHO WE SERVE");
    linkSubjects = app.home().findLink("SUBJECTS");
    linkAbout = app.home().findLink("ABOUT");

    Assert.assertTrue(linkWhoWeServe);
    Assert.assertTrue(linkSubjects);
    Assert.assertTrue(linkAbout);
  }


}
