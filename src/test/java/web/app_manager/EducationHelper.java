package web.app_manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class EducationHelper extends HelperBase {
  public EducationHelper(WebDriver wd) {
    super(wd);
  }
  public Boolean headerIsDisplayed(String element) {
    Boolean linkExist = isElementDisplayed(By.xpath(".//span[contains(.,'"+ element +"')]"));
    return linkExist;
  }

  public List<String> getElementOfLeftMenu() {
    return wd.findElements(By.xpath(".//div[@class='side-panel']//ul/li")).stream().map(e->e.getAttribute("innerText")).collect(Collectors.toList());

  }
}
