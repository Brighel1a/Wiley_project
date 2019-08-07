package web.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import web.app_manager.ApplicationManager;

public class TestBase {
  protected static final ApplicationManager app = new ApplicationManager( BrowserType.CHROME);

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }


  @AfterMethod
  public void tearDown() {
    app.stop();
  }
}
