package web.tests;
import org.openqa.selenium.Rectangle;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;

//        7. Enter “Java” and do not press search button
//        - Area with related content is displayed right under the search header
//        - On the “Suggestions” section, it has 4 words starting with “Java”
//        - On the “Products” section, there are 5 titles and each title contain “Java” word

public class Case7 extends TestBase{

  @Test
  public void checkAreaRelatedContent(){
    Rectangle serchBoxCoordinate = app.search().getLocationSerchBox();
    Rectangle serchButtonCoordinate = app.search().getLocationSerchButton();
    app.search().typeText("Java");
    Rectangle findContentCoordinate = app.search().getLocationFindContentBox();
    List<String> suggestions = app.search().getListDropDownOf("Suggestions");
    List<String> products = app.search().getListDropDownOf("Products");

    assertEquals(serchBoxCoordinate.x, findContentCoordinate.x );
    assertEquals((serchBoxCoordinate.y+serchBoxCoordinate.height), findContentCoordinate.y);
    assertEquals(findContentCoordinate.width, (serchBoxCoordinate.width + serchButtonCoordinate.width));
    suggestions.stream().forEach(p->Assert.assertTrue(p.matches("^[Jj]ava.*?(\\s|\\B|$|\\Z|\\-)")));
    assertEquals(suggestions.size(),4);
    products.stream().forEach(p->Assert.assertTrue(p.toLowerCase().contains("java")));
    assertEquals(products.size(), 5);
  }

  @AfterMethod
  public void returnToHome(){
    app.goToHomePage();
  }
}
