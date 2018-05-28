package TestEVG;

import UtilClasses.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static TestEVG.WrikeTests.driver;
import static TestEVG.WrikeTests.webDriverWait;

public class ResendPage {

    private By formQuestionnaire = By.xpath("//form[@class='survey-form']");
    private By resendEmailButton = By.xpath("//div[@class = 'wg-grid']//button[text()='Resend email']");
    private By submitResultsButton = By.xpath("//div[@class='survey']//button[@type='submit']");
    private By messageAfterSuccessfulSending = By.xpath("//div[@class='survey-success']//h3");
    private By addedItemInMassageAfterClickResendEmailButton = By.xpath("//div[@class='wg-cell wg-cell--order-1 wg-cell--md-5 wg-cell--md-5 wg-cell--md-offset-1 wg-cell--lg-4 wg-cell--lg-offset-1']//span[@class='again']");
    private String urlSVGIcons = "https://www.wrike.com/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v1";

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

    public void checkThatTheIconExistsInTheSectionFollowUs(String icon){
        int numberOfIcons = driver.findElements(By.xpath("//div[@class='wg-footer__social-block']//*[name()='use' and @*='/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v1#" + icon + "']")).size();
        if(numberOfIcons == 0){
            throw new NoSuchElementException("icon doesn't exist");
        }
        else if (numberOfIcons > 1){
            throw new AssertionError("icon isn't one");
        }

    }

    public String getLinkOfIconFollowUs(String icon){
        return driver.findElement(By.xpath("//a[child::*[name() = 'svg']/*[name()='use' and @*='/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v1#" + icon + "']]")).getAttribute("href");
    }

    public String getPathOfSVGIcon(String icon){
        driver.get(urlSVGIcons);
        return driver.findElement(By.xpath("//*[@id='" + icon + "']//*[name() = 'path']")).getAttribute("d");
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
