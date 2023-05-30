package component;

import object.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Button extends PageObject {
    WebDriverWait wait;
    Duration duration = Duration.ofSeconds(10);
    public Button (WebDriver driver) {super(driver);}

    public void clickLoginButton(){
        wait = new WebDriverWait(webdriver,duration);

        wait.ignoring(WebDriverException.class);

        wait.ignoring(StaleElementReferenceException.class);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        Actions actions = new Actions(webdriver);
        actions.moveToElement(button).click().perform();
    }

    public  void clickAddtoCartButton(){
        wait = new WebDriverWait(webdriver,duration);

        wait.ignoring(WebDriverException.class);

        wait.ignoring(StaleElementReferenceException.class);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")));
        Actions actions = new Actions(webdriver);
        actions.moveToElement(button).click().perform();
    }

    public  void clickCartIcon(){
        wait = new WebDriverWait(webdriver,duration);

        wait.ignoring(WebDriverException.class);

        wait.ignoring(StaleElementReferenceException.class);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".shopping_cart_link")));
        Actions actions = new Actions(webdriver);
        actions.moveToElement(button).click().perform();
    }

    public  void clickCheckoutButton(){
        wait = new WebDriverWait(webdriver,duration);

        wait.ignoring(WebDriverException.class);

        wait.ignoring(StaleElementReferenceException.class);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
        Actions actions = new Actions(webdriver);
        actions.moveToElement(button).click().perform();
    }

    public  void clickContinueButton(){
        wait = new WebDriverWait(webdriver,duration);

        wait.ignoring(WebDriverException.class);

        wait.ignoring(StaleElementReferenceException.class);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
        Actions actions = new Actions(webdriver);
        actions.moveToElement(button).click().perform();
    }

    public  void clickFinishButton(){
        wait = new WebDriverWait(webdriver,duration);

        wait.ignoring(WebDriverException.class);

        wait.ignoring(StaleElementReferenceException.class);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("finish")));
        Actions actions = new Actions(webdriver);
        actions.moveToElement(button).click().perform();
    }

    public boolean cartIconIsDisplayed() throws Exception {
        try {
            WebElement cartIcon = webdriver.findElement(By.className("shopping_cart_link"));
            return cartIcon.isDisplayed();
        } catch (NoSuchElementException e) {
            throw new Exception("Cart icon is not displayed");
        }
    }
}
