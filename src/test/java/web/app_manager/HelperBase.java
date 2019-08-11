package web.app_manager;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;

import java.util.concurrent.TimeUnit;

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

  protected boolean isElementDisplayed(By locator) {
    try {
      wd.findElement(locator).isDisplayed();
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  protected boolean isPageReloaded(By locator){
    try {
      wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
      return wd.findElements(locator).size() > 0;
    } finally {
      wd.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
  }

  public void type(By locator, String text) {
    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (!text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  protected void muveTo(By locator){
    Actions actions = new Actions(wd);
    actions.moveToElement(wd.findElement(locator)).build().perform();
  }

  public void click(By locator){
    wd.findElement(locator).click();
  }

  public String getCurrentUrl(){
    return wd.getCurrentUrl();
  }

  public Rectangle getLocationElement(By locator){
    WebElement textBox = wd.findElement(locator);
   // Point elementCoordinates = ((Locatable) textBox).getCoordinates().inViewPort();
    Rectangle elementCoordinatesRec = textBox.getRect();
    return elementCoordinatesRec;
  }



}
