package component;

import object.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CardProduct extends PageObject {

    WebDriverWait wait;

    private Double price;

    Duration duration = Duration.ofSeconds(10);
    public CardProduct(WebDriver driver){super(driver);}

    public void clickCardProduct(){
        wait = new WebDriverWait(webdriver,duration);

        wait.ignoring(WebDriverException.class);

        wait.ignoring(StaleElementReferenceException.class);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[.='Sauce Labs Backpack']")));
        Actions actions = new Actions(webdriver);
        actions.moveToElement(button).click().perform();
    }

    public Double getPriceSwagLabsProduct() {
        WebElement getElement = webdriver.findElement(By.className("inventory_details_price"));
        String getPrice = getElement.getText().replace("$", "");
        price = Double.parseDouble(getPrice);

        System.out.println("Price: " + price);
        // Kembalikan nilai username asli jika tidak ada yang cocok dengan accepted usernames
        return price;
        // Cetak nilai untuk memastikan berhasil tersimpan
    }

    public void verifyPriceOnCheckout() {
        try {
            WebElement getElement = webdriver.findElement(By.className("inventory_item_price"));
            String getPrice = getElement.getText().replace("$", "");
            Double priceOnCheckout = Double.parseDouble(getPrice);
            assertTrue(price.equals(priceOnCheckout));
        } catch (NoSuchElementException e) {
            fail("Test failed due to: " + e.getMessage());
        }
    }
}
