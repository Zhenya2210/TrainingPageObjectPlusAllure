package TestEVG;

import UtilClasses.Helper;
import junit.framework.AssertionFailedError;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static TestEVG.EVGTests.driver;
//import static TestEVG.EVGTests.executor;
import static TestEVG.EVGTests.executor;
import static TestEVG.EVGTests.webDriverWait;

public class ResendPage {

    private By formQuestionnaire = By.xpath("//form[@class='survey-form']");
    private By resendEmailButton = By.xpath("//div[@class = 'wg-grid']//button[text()='Resend email']");
    private By submitResultsButton = By.xpath("//div[@class='survey']//button[@type='submit']");
    private By messageAfterSuccessfulSending = By.xpath("//div[@class='survey-success']//h3");
    private By addedItemInMassageAfterClickResendEmailButton = By.xpath("//div[@class='wg-cell wg-cell--order-1 wg-cell--md-5 wg-cell--md-5 wg-cell--md-offset-1 wg-cell--lg-4 wg-cell--lg-offset-1']//span[@class='again']");
    private By iconsOfOtherServices = By.xpath("//div[@class='wg-footer__social-block']//ul[@class='wg-footer__social-list']/li");
    private String linkTwitterWrike = "https://twitter.com/wrike";
    private String expectedPathOfSVGTwitter = "M14.2 3.2v.42A9.23 9.23 0 0 1-.01 11.39a6.66 6.66 0 0 0 .78 0 6.5 6.5 0 0 0 4-1.38 3.25 3.25 0 0 1-3-2.25 4.21 4.21 0 0 0 .61 0 3.42 3.42 0 0 0 .85-.11 3.24 3.24 0 0 1-2.6-3.18 3.27 3.27 0 0 0 1.47.41 3.25 3.25 0 0 1-1-4.34 9.22 9.22 0 0 0 6.69 3.39 3.66 3.66 0 0 1-.08-.74A3.25 3.25 0 0 1 13.32.97a6.39 6.39 0 0 0 2.06-.78 3.23 3.23 0 0 1-1.43 1.79 6.5 6.5 0 0 0 1.87-.5A7 7 0 0 1 14.2 3.2z";

    public String getCurrentURL(){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(formQuestionnaire));
        return driver.getCurrentUrl();
    }

    public void fillOutTheQAFormWithRandomOptions(){
        int answerIndexForQuestion = 1 + (int)Math.round(Math.random() * 1);
        driver.findElement(By.xpath("//div[@data-code='interest_in_solution']/label[" + answerIndexForQuestion + "]/button")).click();
        answerIndexForQuestion = 1 + (int)Math.round(Math.random() * 4);
        driver.findElement(By.xpath("//div[@data-code='team_members']/label[" + answerIndexForQuestion + "]/button")).click();
        answerIndexForQuestion = 1 + (int)Math.round(Math.random() * 2);
        driver.findElement(By.xpath("//div[@data-code='primary_business']/label[" + answerIndexForQuestion + "]/button")).click();
            if (answerIndexForQuestion == 3){
                driver.findElement(By.xpath("//div[@data-code='primary_business']/label[3]/button//input")).sendKeys(Helper.getRandomString());
            }
        driver.findElement(submitResultsButton).click();
    }

    public String getMessageAfterSuccessfulSending(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(messageAfterSuccessfulSending));
        return driver.findElement(messageAfterSuccessfulSending).getText();
    }

    public void clickResendEmailButton(){
        driver.findElement(resendEmailButton).click();

    }

    public String getAddedItemInMassageAfterClickResendEmailButton(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(addedItemInMassageAfterClickResendEmailButton));
        return driver.findElement(addedItemInMassageAfterClickResendEmailButton).getText();
    }

    public String getStyleResendEmailButtonAfterClick(){
        return driver.findElement(resendEmailButton).getAttribute("style");
    }

    public void checkThatTwitterIconExists(){
        int numberOfIcons = driver.findElements(iconsOfOtherServices).size();
        boolean b = false;
        for(int i = 1; i <= numberOfIcons; i++){
            String linkSVG = driver.findElement(By.xpath("//div[@class='wg-footer__social-block']//li[" + i + "]//*[name() = 'use']")).getAttribute("xlink:href");
            String lastWordOfLink = Helper.getlastWordOfLink(linkSVG);
            if (lastWordOfLink == "twitter"){
                String linkOfIcon = driver.findElement(By.xpath("//ul[@class='wg-footer__social-list']/li[" + i + "]/a")).getAttribute("href");
                if (!linkOfIcon.equals(linkTwitterWrike)){
                    throw new AssertionError("Ссылка не соответствует иконке твиттера");
                }
                driver.get("https://www.wrike.com" + linkSVG);
                String actualPathOfSVG = driver.findElement(By.xpath("//*[@id='twitter']//*[name() = 'path']")).getAttribute("d");
                if (!actualPathOfSVG.equals(expectedPathOfSVGTwitter)){
                    throw new AssertionError("ого не соответствует логотипу Твиттера");
                }
                break;
            }

        }
    }

//    public void checkThatTwitterIconExists(){
//        int numberOfIcons = driver.findElements(iconsOfOtherServices).size();
//        boolean b = false;
//        for (int i = 1; i <= numberOfIcons; i++){
//            WebElement root = driver.findElement(By.xpath("//div[@class='wg-footer__social-block']//li[" + i + "]//*[name() = 'use']"));
//            WebElement shadowRoot = expandRootElement(root);
//            String nameIcon = shadowRoot.findElement(By.xpath("//*[name()='svg']")).getAttribute("id");
//            if (nameIcon.equals("twitter")){
//                b = true;
//                break;
//            }
//        }
//        if (!b){
//            throw new AssertionError("Лого твиттера не найдено");
//        }
//    }
//
//    public WebElement expandRootElement(WebElement element) {
//        WebElement ele = (WebElement)executor.executeScript("return arguments[0].shadowRoot", element);
//        return ele;
//    }
}
