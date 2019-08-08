package web.app_manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeaderHelper extends HelperBase{
  Boolean linkExist;
  public HeaderHelper(WebDriver wd) {
    super(wd);
  }

  public Boolean findLink(String link) {
    linkExist = isElementPresent(By.xpath(".//a[@class='collapsed' and contains (text(),'"+ link +"')]"));
           // ".//span[@class='dropdown-item-title' and contains (text(),'"+link+"')]"));
    return linkExist;
  }


  public List<String> listOfElements() {
    List<String> elements = wd.findElements(By.xpath(".//li[@class='dropdown-submenu hover']//li[@class='dropdown-item ']"))
            .stream().map((p)->p.getText()).collect(Collectors.toList());
    return elements;
  }

  public void showSubHeaderOf(String element){
    muveTo(By.xpath(".//a[@class='collapsed' and contains (text(),'"+ element +"')]"));
  }




}
