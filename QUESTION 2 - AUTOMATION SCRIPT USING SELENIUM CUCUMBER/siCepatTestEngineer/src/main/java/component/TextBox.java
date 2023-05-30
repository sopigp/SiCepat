package component;

import object.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBox extends PageObject {
    private String savedUsername;
    private String savedPassword;
    public TextBox(WebDriver driver) {
        super(driver);
    }

    public void enterTextUsername(String username) {
        WebElement textBox = webdriver.findElement(By.id("user-name"));
        textBox.clear();
        textBox.sendKeys(username);
    }

    public void enterTextPassword(String password) {
        WebElement textBox = webdriver.findElement(By.id("password"));
        textBox.clear();
        textBox.sendKeys(password);
    }

    public void enterTextfirstName(String firstName) {
        WebElement textBox = webdriver.findElement(By.id("first-name"));
        textBox.clear();
        textBox.sendKeys(firstName);
    }

    public void enterTextlastName(String lastName) {
        WebElement textBox = webdriver.findElement(By.id("last-name"));
        textBox.clear();
        textBox.sendKeys(lastName);
    }

    public void enterTextpostalCode(String postalCode) {
        WebElement textBox = webdriver.findElement(By.id("postal-code"));
        textBox.clear();
        textBox.sendKeys(postalCode);
    }

    public String getUsernameText() {
        WebElement getUserName = webdriver.findElement(By.id("login_credentials"));
        String username = getUserName.getText();

        // Periksa jika nilai username adalah salah satu dari accepted usernames
        if (username.contains("standard_user")) {
            return "standard_user";
        }

        // Kembalikan nilai username asli jika tidak ada yang cocok dengan accepted usernames
        return username;
    }

    public String getPasswordText() {
        WebElement getPassword = webdriver.findElement(By.className("login_password"));
        String password = getPassword.getText();

        if (password.contains("secret_sauce")) {
            return "secret_sauce";
        }

        return password;
    }

    // Metode untuk menyimpan nilai username dan password ke dalam variabel
    public void saveCredentials() {
        savedUsername = getUsernameText();
        savedPassword = getPasswordText();

        // Cetak nilai untuk memastikan berhasil tersimpan
        System.out.println("Username: " + savedUsername);
        System.out.println("Password: " + savedPassword);
    }

    public void loginWithSavedCredentials() {
        enterTextUsername(savedUsername);
        enterTextPassword(savedPassword);
    }



}
