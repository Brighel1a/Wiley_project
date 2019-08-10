package web.app_manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SearchHelper extends HelperBase{
  WebDriverWait wait = new WebDriverWait(wd, 30);

  public SearchHelper(WebDriver wd) {
    super(wd);
  }

  public boolean checkReloadPegeAfterSeerch(){
    click(By.xpath(".//button[@type='submit']"));
    return pageNotReloaded(By.xpath(".//button[@type='submit']"));
  }

  public Rectangle getLocationSerchBox(){
    return getLocationElement(By.xpath(".//input[@type='search']"));
  }

  public Rectangle getLocationSerchButton() {
    return getLocationElement(By.xpath(".//button[text() ='Search']"));
  }

  public Rectangle getLocationFindContentBox() {
    WebElement loadingLink =wd.findElement(By.xpath(".//aside[@id='ui-id-2']"));
    wait.until(ExpectedConditions.visibilityOf(loadingLink));
    return getLocationElement(By.xpath(".//aside[@id='ui-id-2']"));
  }


  public void typeText(String text) {
    type(By.xpath(".//input[@type='search']"),text);
  }

  public List<String> getListDropDownOf(String element) {
    return wd.findElements(By.xpath(".//h3[contains(.,'"+ element +"')]/following-sibling::div/div[@class='searchresults-item ui-menu-item']"))
            .stream().map(p->p.getAttribute("innerText")).collect(Collectors.toList());
  }


}


