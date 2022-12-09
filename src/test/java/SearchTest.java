import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.GoogleSearchPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchTest {
    WebDriver driver;
    GoogleSearchPage googleSearchPage ;
    @BeforeTest
    public void openBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        googleSearchPage= new GoogleSearchPage(driver);
    }
    @Test
    public void FirstSearch() throws InterruptedException {
        driver.get("https://google.com");
        googleSearchPage.put_first_Key_Word_in_search_field().clear();
        googleSearchPage.put_first_Key_Word_in_search_field().click();
        googleSearchPage.put_first_Key_Word_in_search_field().sendKeys("dog");
        googleSearchPage.put_first_Key_Word_in_search_field().sendKeys(Keys.ENTER);
        googleSearchPage.click_on_remove_icon().click();
        googleSearchPage.put_second_Key_Word_in_search_field().sendKeys("lion");
        googleSearchPage.put_second_Key_Word_in_search_field().sendKeys(Keys.ENTER);
        driver.navigate().refresh();
        Thread.sleep(1000);
        Boolean result_number= googleSearchPage.Second_Page_result_Number().isDisplayed();
       googleSearchPage.click_on_next_page().click();
        Thread.sleep(1000);
        String pageTwoResult= googleSearchPage.Second_Page_result_Number().getText();
        System.out.println(pageTwoResult);
        Thread.sleep(1000);
        googleSearchPage.click_on_third_page().click();
       Thread.sleep(1000);
        String pageThreeResult= googleSearchPage.Third_Page_result_Number().getText();
       System.out.println(pageThreeResult);
        Assert.assertTrue(result_number);
        Assert.assertTrue(googleSearchPage.search_suggestion_data().isDisplayed());
      // Assert.assertTrue(pageTwoResult.contains(pageThreeResult));





    }

    @AfterTest
   public void Close() throws InterruptedException {
       Thread.sleep(1000);
       driver.close();
    }
}
