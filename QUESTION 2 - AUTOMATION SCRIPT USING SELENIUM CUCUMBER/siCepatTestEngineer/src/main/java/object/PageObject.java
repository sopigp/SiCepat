package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected WebDriver webdriver;

        public PageObject(WebDriver driver){
        this.webdriver = driver;
        PageFactory.initElements(driver, this);
    }
}
