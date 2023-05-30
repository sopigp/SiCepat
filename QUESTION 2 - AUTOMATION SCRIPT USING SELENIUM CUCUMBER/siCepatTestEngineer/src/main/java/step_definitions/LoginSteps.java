package step_definitions;

import component.Button;
import component.CardProduct;
import component.TextBox;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class LoginSteps {

    private TextBox textBox;
    private Button button;

    private CardProduct labelProductName;
    private WebDriver webdriver;

    public LoginSteps() {
        super();
        this.webdriver = Hooks.webdriver;
        this.textBox = new TextBox(Hooks.driver);
        this.button = new Button(Hooks.driver);
        this.labelProductName = new CardProduct(Hooks.driver);
    }


    @Given("User open the browser and navigate to www.saucedemo.com")
    public void userOpenTheWebpage() throws InterruptedException {
        Hooks.driver.manage().window().maximize();
        Hooks.driver.get(Utils.BASE_URL);
        Thread.sleep(3000);
    }

    @When("User login using {string} as username with {string} as password")
    public void userLoginAs(String username, String password) {
        textBox.enterTextUsername(username);
        textBox.enterTextPassword(password);
    }

    @And("I click Login button on login page")
    public void iClickLoginButton() {
        button.clickLoginButton();
    }

    @And("I choose Swag Labs product")
    public void iChooseProduct() {
        labelProductName.clickCardProduct();
    }

    @And("I click Add to cart button")
    public void iClickAddtoCart() {
        button.clickAddtoCartButton();
    }

    @And("I click the cart icon on header")
    public void iClickCartIcon() {
        button.clickCartIcon();
    }

    @And("I click Checkout button")
    public void iClickCheckoutButton() {
        button.clickCheckoutButton();
    }

    @And("I enter {string} into firstname field")
    public void iEnterFirstname(String firstName) {
        textBox.enterTextfirstName(firstName);
    }

    @And("I enter {string} into lastname field")
    public void iEnterLastname(String lastname) {
        textBox.enterTextlastName(lastname);
    }

    @And("I enter {string} into zip field")
    public void iEnterPostalcode(String postalCode) {

        textBox.enterTextpostalCode(postalCode);
    }

    @And("I click Continue button")
    public void iClickContinueButton() {

        button.clickContinueButton();
    }

    @When("I click Finish button")
    public void iClickFinishButton() {

        button.clickFinishButton();
    }

    @When("I retrieves the username and password values")
    public void userRetrievesTheUsernameAndPasswordValues() {
        textBox.getUsernameText();
        textBox.getPasswordText();
    }

    @And("I saves the values into variables")
    public void userSavesTheValuesIntoVariables() {
        textBox.saveCredentials();
    }

    @And("I logs in using the saved username and password")
    public void userLogsInUsingTheSavedUsernameAndPassword() {
        textBox.loginWithSavedCredentials();
        button.clickLoginButton();
    }

    @Then("I should be successfully logged in")
    public void userShouldBeSuccessfullyLoggedIn() throws Exception {
        button.cartIconIsDisplayed();
    }

    @And("I retrieves the price of Swag Labs product")
    public void iRetrievesThePriceOfSwagLabsProduct() {
        labelProductName.getPriceSwagLabsProduct();
    }

    @Then("the price of Swag Labs on checkout is same with the price from detail product page")
    public void thePriceOfSwagLabsOnCheckoutIsSameWithThePriceFromDetailProductPage() {
        labelProductName.verifyPriceOnCheckout();
    }
}
