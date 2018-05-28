package TestEVG;

import UtilClasses.Helper;
import org.openqa.selenium.By;

import static TestEVG.WrikeTests.driver;

public class StartFreeTrialFormPage {

    private By emailField = By.xpath("//div[@class='wg-modal-overlay wg-modal--fade in']//input[@name='email']");
    private By createMyWrikeAccountButton = By.xpath("//button[text()='Create my Wrike account']");
    public String email = Helper.getRandomString() + "+wpt@wriketask.qaa";


    public void fillInTheEmailField(){
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickCreateMyWrikeAccountButton(){
        driver.findElement(createMyWrikeAccountButton).click();
    }

}
