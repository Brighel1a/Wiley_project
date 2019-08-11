package web.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.List;

//        8. Click “SEARCH” button
//        - Only titles containing “Java” are displayed
//        - There are 10 titles
//        - Each title has at least one “Add to Cart” button


public class Case8 extends TestBase {

  @Test
  public void checkTitlesInPageOfSearch(){
    app.search().typeText("Java");
    app.search().clickSerchButton();
    List<String> titlesName = app.search().getTitlesName();
    app.search().checkAllButtoms();
            //cheskEveryTitleHasButton();
    Assert.assertTrue(titlesName.size()==10);
    titlesName.stream().forEach(p->Assert.assertTrue(p.toLowerCase().contains("java")));
  }

  @AfterMethod
  public void returnToHome(){
    app.goToHomePage();
  }
}
