package web.app_manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class SearchHelper extends HelperBase{
  WebDriverWait wait = new WebDriverWait(wd, 30);

  public SearchHelper(WebDriver wd) {
    super(wd);
  }

  public void clickSerchButton(){
    try {
      WebElement loadingLink = wd.findElement(By.xpath(".//div[@class='modal-backdrop fade']"));
      wait.until(ExpectedConditions.invisibilityOf(loadingLink));
    } catch (NoSuchElementException ex){}
    click(By.xpath(".//button[@type='submit']"));
  }

  public boolean getIsPageReloaded(){
    return isPageReloaded(By.xpath(".//button[@type='submit']"));
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


  public List<String> getTitlesName() {
    return wd.findElements(By.xpath(".//h3[@class='product-title']")).stream()
            .map(p->p.getAttribute("InnerText")).collect(Collectors.toList());
  }

  public void checkAllButtoms() {
    List<WebElement> listWeb = wd.findElements(By.cssSelector("section.product-item"));
    listWeb.forEach(p->Assert.assertTrue(p.findElements(
            By.cssSelector("button.add-to-cart-button")).size()>0,"There is no current Button for book:" + p.getText()));
  }
}


