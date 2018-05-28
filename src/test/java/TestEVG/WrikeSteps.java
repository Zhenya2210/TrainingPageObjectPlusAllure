package TestEVG;

import io.qameta.allure.Step;

import static TestEVG.WrikeTests.driver;

public class WrikeSteps {

    @Step("Open Wrike")
    public void openMainPage() {
        driver.get("https://www.wrike.com");
    }

    @Step("Click Login")
    public void clickLoginButton() {
        HeaderPage headerPage = new HeaderPage();
        headerPage.clickLoginButton();
    }

    @Step("Click Create account")
    public void clickCreateAccountLink() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.clickCreateAccountLink();
    }

    @Step("Click Get started for free")
    public void clickGetStartedForFreeButton() {
        HeaderPage headerPage = new HeaderPage();
        headerPage.clickGetStartedForFreeButton();
    }

    @Step("Enter email")
    public void fillInTheEmailField() {
        StartFreeTrialFormPage startFreeTrialFormPage = new StartFreeTrialFormPage();
        startFreeTrialFormPage.fillInTheEmailField();
    }

    @Step("Click Create my Wrike account")
    public void clickCreateMyWrikeAccountButton() {
        StartFreeTrialFormPage startFreeTrialFormPage = new StartFreeTrialFormPage();
        startFreeTrialFormPage.clickCreateMyWrikeAccountButton();
    }

    @Step("Get current URL page")
    public String getCurrentURL() {
        ResendPage resendPage = new ResendPage();
        return resendPage.getCurrentURL();
    }

    @Step("Fill in the questionnaire with random answers")
    public void fillOutTheQAFormWithRandomOptions() {
        ResendPage resendPage = new ResendPage();
        resendPage.fillOutTheQAFormWithRandomOptions();
    }

    @Step("Get message after sending replies")
    public String getMessageAfterSuccessfulSending(){
        ResendPage resendPage = new ResendPage();
        return resendPage.getMessageAfterSuccessfulSending();
    }

    @Step("Click Resend email")
    public void clickResendEmailButton(){
        ResendPage resendPage = new ResendPage();
        resendPage.clickResendEmailButton();
    }

    @Step("Get the added fragment in the message after click Resend email")
    public String getAddedItemInMassageAfterClickResendEmailButton(){
        ResendPage resendPage = new ResendPage();
        return resendPage.getAddedItemInMassageAfterClickResendEmailButton();
    }

    @Step("Get the style of the button after clicking it")
    public String getStyleResendEmailButtonAfterClick(){
        ResendPage resendPage = new ResendPage();
        return resendPage.getStyleResendEmailButtonAfterClick();
    }

    @Step("Check that the Twitter icon exists")
    public void checkThatTwitterIconExists(){
        ResendPage resendPage = new ResendPage();
        resendPage.checkThatTheIconExistsInTheSectionFollowUs("twitter");
    }

    @Step("Get link of the Twitter icon")
    public String getLinkOfTwitterIcon(){
        ResendPage resendPage = new ResendPage();
        return resendPage.getLinkOfIconFollowUs("twitter");
    }

    @Step("Get SVG path of the Twitter icon")
    public String getSVGPathOfTwitterIcon(){
        ResendPage resendPage = new ResendPage();
        return resendPage.getPathOfSVGIcon("twitter");
    }


}
