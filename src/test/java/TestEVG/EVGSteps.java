package TestEVG;

import io.qameta.allure.Step;

import static TestEVG.EVGTests.driver;

public class EVGSteps {

    @Step("Открытие Wrike")
    public void openMainPage() {
        driver.get("https://www.wrike.com");
    }

    @Step("Клик Login")
    public void clickLoginButton() {
//        MainPage mainPage = new MainPage();
//        mainPage.clickLoginButton();
        HeaderPage headerPage = new HeaderPage();
        headerPage.clickLoginButton();
    }

    @Step("Клик Create account")
    public void clickCreateAccountLink() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.clickCreateAccountLink();
    }

    @Step("Клик Get started for free")
    public void clickGetStartedForFreeButton() {
//        StartFreeTrialFormPage freeTrialPage = new StartFreeTrialFormPage();
//        freeTrialPage.clickGetStartedForFreeButton();
        HeaderPage headerPage = new HeaderPage();
        headerPage.clickGetStartedForFreeButton();
    }

    @Step("Ввод email")
    public void fillInTheEmailField() {
        StartFreeTrialFormPage startFreeTrialFormPage = new StartFreeTrialFormPage();
        startFreeTrialFormPage.fillInTheEmailField();
    }

    @Step("Клик Create my Wrike account")
    public void clickCreateMyWrikeAccountButton() {
        StartFreeTrialFormPage startFreeTrialFormPage = new StartFreeTrialFormPage();
        startFreeTrialFormPage.clickCreateMyWrikeAccountButton();
    }

    @Step("Получить текущий URL страницы")
    public String getCurrentURL() {
        ResendPage resendPage = new ResendPage();
        return resendPage.getCurrentURL();
    }

    @Step("Заполнить анкету случайными вариантами ответа")
    public void fillOutTheQAFormWithRandomOptions() {
        ResendPage resendPage = new ResendPage();
        resendPage.fillOutTheQAFormWithRandomOptions();
    }

    @Step("Получить сообщение после отправки ответов")
    public String getMessageAfterSuccessfulSending(){
        ResendPage resendPage = new ResendPage();
        return resendPage.getMessageAfterSuccessfulSending();
    }

    @Step("Клик Resend email")
    public void clickResendEmailButton(){
        ResendPage resendPage = new ResendPage();
        resendPage.clickResendEmailButton();
    }

    @Step("Получить добавленный фрагмент в сообщении после клика Resend email")
    public String getAddedItemInMassageAfterClickResendEmailButton(){
        ResendPage resendPage = new ResendPage();
        return resendPage.getAddedItemInMassageAfterClickResendEmailButton();
    }

    @Step("Получить стиль кнопки после её нажатия")
    public String getStyleResendEmailButtonAfterClick(){
        ResendPage resendPage = new ResendPage();
        return resendPage.getStyleResendEmailButtonAfterClick();
    }

    @Step("Проверить, что иконка твиттера существует")
    public void checkThatTwitterIconExists(){
        ResendPage resendPage = new ResendPage();
        resendPage.checkThatTwitterIconExists();
    }






}
