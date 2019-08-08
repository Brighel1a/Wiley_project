package web.app_manager;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator).isEnabled();
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  protected void muveTo(By locator){
    Actions actions = new Actions(wd);
    actions.moveToElement(wd.findElement(locator)).build().perform();
  }

}
