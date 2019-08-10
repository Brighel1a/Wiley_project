package web.tests;

//        4. Go to “Subjects” top menu, select “Education”
//        - Check “Education” header is displayed

//        - 13 items are displayed under “Subjects” on the left side of the screen and the texts are
//        - "Information & Library Science",
//        - "Education & Public Policy",
//        - "K-12 General",
//        - "Higher Education General",
//        - "Vocational Technology",
//        - "Conflict Resolution & Mediation (School settings)",
//        - "Curriculum Tools- General",
//        - "Special Educational Needs",
//        - "Theory of Education",
//        - "Education Special Topics",
//        - "Educational Research & Statistics",
//        - "Literacy & Reading",
//        - "Classroom Management"


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Case4 extends TestBase {
  Set<String> setExpectedItems = new HashSet<>(Arrays.asList("Information & Library Science", "Education & Public Policy",
          "K-12 General", "Higher Education General", "Vocational Technology",
          "Conflict Resolution & Mediation (School settings)", "Curriculum Tools- General",
          "Special Educational Needs", "Theory of Education", "Education Special Topics",
          "Educational Research & Statistics", "Literacy & Reading", "Classroom Management"));

  @Test
  public void checkLeftMenuUnderHeader(){
    app.header().clickSubHeaderOf("SUBJECTS","Education");
    boolean headerIsDisplayed = app.education().headerIsDisplayed("Education");
    List<String> listOfFoundElements = app.education().getElementOfLeftMenu();
    Set<String> setOfFoundElements = new HashSet<String>(listOfFoundElements);


    Assert.assertTrue(headerIsDisplayed);
    Assert.assertEquals(listOfFoundElements.size(),13);
    Assert.assertEquals(setOfFoundElements, setExpectedItems);
  }
}
