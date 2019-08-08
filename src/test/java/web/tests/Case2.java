package web.tests;

//        2. Check items under Who We Serve for sub-header
//        - There are 11 items under resources sub-header
//        - Titles are “Students”, “Instructors”, “Book Authors”,
//          “Professionals”, “Researchers”, “Institutions”, “Librarians”,
//          “Corporations”, “Societies”, “Journal Editors”, “Government”
// !without click! check that there are only 11 items and the List consists this names

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Case2 extends TestBase{

  Set<String> setExpectedItems = new HashSet<>(Arrays.asList("Students", "Instructors", "Book Authors", "Professionals", "Researchers", "Institutions", "Librarians",
          "Corporations", "Societies", "Journal Editors", "Government"));

  @Test
  public void checkSubelementsWhoWeSerse(){
    app.header().showSubHeaderOf("WHO WE SERVE");
    List<String> subHeaderElements = app.header().listOfElements();
    Set<String> setOfFoundElements = new HashSet<String>(subHeaderElements);

    Assert.assertEquals(subHeaderElements.size(),11);
    Assert.assertTrue(setExpectedItems.removeAll(setOfFoundElements));
  }

}
