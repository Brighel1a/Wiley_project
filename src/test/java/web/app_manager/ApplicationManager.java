package web.app_manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;
  String browser;
  Boolean popup;

  private SearchHelper search;
  private SubjectsHelper subjects;
  private HeaderHelper home;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init(){
    if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    }  else if(browser.equals(BrowserType.IE))  {
      wd = new InternetExplorerDriver();
    }
    wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    wd.get("https://www.wiley.com/en-us");
    closePopup();
    search = new SearchHelper(wd);
    subjects = new SubjectsHelper(wd);
    home = new HeaderHelper(wd);
  }

  private void closePopup() {
    popup = wd.findElement(By.xpath(".//form[@id='country-location-form']")).isDisplayed();
    if(popup){
      wd.findElement(By.xpath(".//form[@id='country-location-form']//button[contains(text(),'NO')]")).click();
    }
  }

  public void stop(){
    wd.quit();
  }

  public SearchHelper search(){
    return search;
  }

  public SubjectsHelper subjects() {
    return subjects;
  }

  public HeaderHelper header(){
    return home;
  }
}
