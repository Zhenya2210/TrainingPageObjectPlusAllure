package TestEVG;

import org.openqa.selenium.By;

import static TestEVG.EVGTests.driver;

public class MainPage {

    private By loginButton = By.linkText("Login");
    private By loginButton2 = By.xpath("//a[text()='Login']");

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
}
