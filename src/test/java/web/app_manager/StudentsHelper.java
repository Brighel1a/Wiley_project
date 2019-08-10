package web.app_manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class StudentsHelper extends HelperBase {
  public StudentsHelper(WebDriver wd) {
    super(wd);
  }

  public String getPageUrl(){
    return getCurrentUrl();
  }

  public boolean headerIsDisplayed(String element) {
    boolean linkExist = isElementDisplayed(By.xpath(".//span[contains(.,'"+ element +"')]"));
    return linkExist;
  }

  public String getUrlOfLink(String element){
    return wd.findElement(By.xpath(""+ element +"")).getAttribute("href");
  }


  public List<String> getUrlsOfLinks(String link) {
    List<String> linksUrls = wd.findElements(By.xpath(".//span[contains(.,'"+ link +"')]/ancestor::a")).stream().map((e)->e.getAttribute("href")).collect(Collectors.toList());
    return linksUrls;
  }
}
