package web.app_manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class HeaderHelper extends HelperBase{
  WebDriverWait wait = new WebDriverWait(wd, 30);
  public HeaderHelper(WebDriver wd) {
    super(wd);
  }

  public void checkLinkIsDisplayed(String name) {
    boolean isLinkDisplayed = isElementDisplayed(By.xpath(".//a[@class='collapsed' and contains (text(),'"+ name +"')]"));
    Assert.assertTrue(isLinkDisplayed);
  }


  public List<String> getSubHeadersItems() {
    List<String> elements = wd.findElements(By.xpath(".//li[@class='dropdown-submenu hover']//li[@class='dropdown-item ']"))
            .stream().map((p)->p.getText()).collect(Collectors.toList());
    return elements;
  }

  public HeaderHelper showSubHeaderOf(String headerName){
    muveTo(By.xpath(".//a[@class='collapsed' and contains (text(),'"+ headerName +"')]"));
    return this;
  }

  public void clickSubHeaderOf(String headerName, String subHeader){
    muveTo(By.xpath(".//a[@class='collapsed' and contains (text(),'"+ headerName +"')]"));
    click(By.xpath(".//a[@title='with submenu' and contains(.,'"+ subHeader +"')]"));
  }

  public void goTo(String element){
    click(By.xpath(".//a[@class='collapsed' and contains (text(),'"+ element +"')]"));
  }

  public String getPageUrl(){
    return getCurrentUrl();
  }

  public void clickToLogo() {
//    isElementPresent(By.cssSelector("img[title=Wiley]"));
    By loadingLink = By.cssSelector("img[title=Wiley]");
    wait.until(ExpectedConditions.elementToBeClickable(loadingLink));
    click(By.xpath(".//div[@class='yCmsContentSlot logo']"));
  }
}
