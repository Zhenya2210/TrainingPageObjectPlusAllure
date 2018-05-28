package TestEVG;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class WrikeTests {

    private String expectedURL = "https://www.wrike.com/resend/";
    private String expectedMessageAfterSuccessfulSending = "Thanks for helping us out!";
    private String expectedStyleResendEmailButtonAfterClick = "transition: opacity 0.4s; opacity: 0;";
    private String expectedAddedItemInMassageAfterClickResendEmailButton = "again.";
    private String expectedLinkOfTheTwitterIcon = "https://twitter.com/wrike";
    private String expectedSVGPathOfTheTwitterIcon = "M14.2 3.2v.42A9.23 9.23 0 0 1-.01 11.39a6.66 6.66 0 0 0 .78 0 6.5 6.5 0 0 0 4-1.38 3.25 3.25 0 0 1-3-2.25 4.21 4.21 0 0 0 .61 0 3.42 3.42 0 0 0 .85-.11 3.24 3.24 0 0 1-2.6-3.18 3.27 3.27 0 0 0 1.47.41 3.25 3.25 0 0 1-1-4.34 9.22 9.22 0 0 0 6.69 3.39 3.66 3.66 0 0 1-.08-.74A3.25 3.25 0 0 1 13.32.97a6.39 6.39 0 0 0 2.06-.78 3.23 3.23 0 0 1-1.43 1.79 6.5 6.5 0 0 0 1.87-.5A7 7 0 0 1 14.2 3.2z";


    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static JavascriptExecutor executor;


    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "ForChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        executor = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    @Test
    public void testScenario(){
        WrikeSteps steps = new WrikeSteps();
        steps.openMainPage();
        steps.clickLoginButton();
        steps.clickCreateAccountLink();
        steps.clickGetStartedForFreeButton();
        steps.fillInTheEmailField();
        steps.clickCreateMyWrikeAccountButton();
        String currentURL = steps.getCurrentURL();
        assertEquals(expectedURL, currentURL);
        steps.fillOutTheQAFormWithRandomOptions();
        String actualMessage = steps.getMessageAfterSuccessfulSending();
        assertEquals(expectedMessageAfterSuccessfulSending, actualMessage);
        steps.clickResendEmailButton();
        String actualAddedItemInMassageAfterClickResendEmailButton = steps.getAddedItemInMassageAfterClickResendEmailButton();
        assertEquals(expectedAddedItemInMassageAfterClickResendEmailButton, actualAddedItemInMassageAfterClickResendEmailButton);
        String actualStyleResendEmailButtonAfterClick = steps.getStyleResendEmailButtonAfterClick();
        assertEquals(expectedStyleResendEmailButtonAfterClick, actualStyleResendEmailButtonAfterClick);
        steps.checkThatTwitterIconExists();
        String actualLinkOfTwitterIcon = steps.getLinkOfTwitterIcon();
        assertEquals(expectedLinkOfTheTwitterIcon, actualLinkOfTwitterIcon);
        String actualSVGPathOfTwitterIcon = steps.getSVGPathOfTwitterIcon();
        assertEquals(expectedSVGPathOfTheTwitterIcon, actualSVGPathOfTwitterIcon);
    }

    @AfterClass
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

}
