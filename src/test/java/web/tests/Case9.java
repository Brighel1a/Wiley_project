package web.tests;

//        9. Enter “Java” in the search input at the top and press “SEARCH” button
//        - Make sure there are same 10 titles shown (as in step 8)


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Case9 extends TestBase{

  @BeforeMethod
  public void goToSearchResultsPage (){
    app.search().typeText("Java");
    app.search().clickSerchButton();
  }

  @Test
  public void checkCountOfFoundTitles() {
    app.search().typeText("Java");
    app.search().clickSerchButton();
    List<String> titlesName = app.search().getTitlesName();
    Assert.assertTrue(titlesName.size()==10);
  }

}
