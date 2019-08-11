package web.app_manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class EducationHelper extends HelperBase {
  public EducationHelper(WebDriver wd) {
    super(wd);
  }


  public void checkHeaderIsDisplayed(String element) {
    Assert.assertTrue(isElementDisplayed(By.xpath(".//span[contains(.,'"+ element +"')]")));
  }

  public List<String> getElementOfLeftMenu() {
    return wd.findElements(By.xpath(".//div[@class='side-panel']//ul/li")).stream().map(e->e.getAttribute("innerText")).collect(Collectors.toList());

  }
}
