package web.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import web.util.Headers;
import java.util.*;

//        2. Check items under Who We Serve for sub-header
//        - There are 11 items under resources sub-header
//        - Titles are “Students”, “Instructors”, “Book Authors”,
//          “Professionals”, “Researchers”, “Institutions”, “Librarians”,
//          “Corporations”, “Societies”, “Journal Editors”, “Government”

public class Case2 extends TestBase{

  Set<String> setExpectedItems = new HashSet<>(Arrays.asList("Students", "Instructors", "Book Authors", "Professionals", "Researchers", "Institutions", "Librarians",
          "Corporations", "Societies", "Journal Editors", "Government"));

  @Test
  public void checkSubHeadersWhoWeSerse(){
    app.header().showSubHeaderOf(Headers.WHO_WE_SERVE.getValue());
    List<String> subHeaderItems = app.header().getSubHeadersItems();
    Set<String> setOfSubHeaderItems = new HashSet<String>(subHeaderItems);

    Assert.assertEquals(subHeaderItems.size(),11);
    Assert.assertTrue(setExpectedItems.removeAll(setOfSubHeaderItems));
  }

  @AfterMethod
  public void returnToHome(){
    app.goToHomePage();
  }
}
