package TestEVG;

import org.openqa.selenium.By;

import static TestEVG.WrikeTests.driver;

public class AuthorizationPage {

    private By createAccountLink = By.linkText("Create account");

    public void clickCreateAccountLink(){
        driver.findElement(createAccountLink).click();
    }
}
