package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchPage {
    WebDriver driver;
    public GoogleSearchPage(WebDriver driver){

        this.driver= driver;
    }
    public WebElement put_first_Key_Word_in_search_field(){
        WebElement firstKeyWord = driver.findElement(By.className("gLFyf"));
        return  firstKeyWord;
    }
    public WebElement put_second_Key_Word_in_search_field(){
        WebElement firstKeyWord = driver.findElement(By.name("q"));
        return  firstKeyWord;
    }
    public WebElement click_on_remove_icon(){
        WebElement X_icon = driver.findElement(By.className("ExCKkf"));
        return  X_icon;
    }

    public WebElement Second_Page_result_Number(){
        WebElement SecondPage_numberOfResult = driver.findElement(By.id("result-stats"));
        return SecondPage_numberOfResult;
    }
    public WebElement Third_Page_result_Number(){
        WebElement ThirdPage_numberOfResult = driver.findElement(By.id("result-stats"));
        return ThirdPage_numberOfResult;
    }

    public WebElement click_on_next_page(){
        WebElement nextPage = driver.findElement(By.xpath("//*[@aria-label=\"Page 2\"]"));
        return nextPage;
    }
    public WebElement click_on_third_page(){
        WebElement nextPage = driver.findElement(By.xpath("//*[@aria-label=\"Page 3\"]"));
        return nextPage;
    }

public List<WebElement> search_suggestion(){
        List<WebElement> searchSuggestion = driver.findElements(By.xpath("//*[@data-xbu=\"true\"]"));
        return searchSuggestion;
}
    public WebElement search_suggestion_data(){
        WebElement searchSuggestion = driver.findElement(By.xpath("//*[@data-xbu=\"true\"]"));
        return searchSuggestion;
    }

}
