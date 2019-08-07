package web.app_manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends HelperBase{
  Boolean linkExist;
  public HomePageHelper(WebDriver wd) {
    super(wd);
  }

  public Boolean findLink(String link) {
    linkExist = wd.findElement(By.xpath(".//span[@class='dropdown-item-title' and contains (text(),'"+link+"')]")).isEnabled();
    return linkExist;
  }


}
