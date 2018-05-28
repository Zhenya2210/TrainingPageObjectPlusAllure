package TestEVG;

import org.openqa.selenium.By;

import static TestEVG.WrikeTests.driver;

public class HeaderPage {

    private By loginButton = By.linkText("Login");
    private By getStartedForFreeButton = By.xpath("//header//button[@class='wg-header__free-trial-button wg-btn wg-btn--green ']");


    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void clickGetStartedForFreeButton(){
        driver.findElement(getStartedForFreeButton).click();
    }

}
