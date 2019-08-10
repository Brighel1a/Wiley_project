package web.app_manager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageHelper extends HelperBase {
  WebDriverWait wait = new WebDriverWait(wd, 30);

  public HomePageHelper(WebDriver wd) {
    super(wd);
  }

  public void goTo(String element){
//    WebElement we = wd.findElement(By.cssSelector("a[title="+ element+ "]"));
//    ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", we);

    muveTo(By.cssSelector("a[title="+ element+ "]"));
    By loadingLink = By.cssSelector("a[title="+ element+ "]");
    wait.until(ExpectedConditions.elementToBeClickable(loadingLink));
    click(By.cssSelector("a[title="+ element+ "]")); //(By.xpath(".//a[@title='"+ element +"']"));
  }


}
