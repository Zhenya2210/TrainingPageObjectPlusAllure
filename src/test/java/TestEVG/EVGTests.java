package TestEVG;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class EVGTests {

    private String expectedURL = "https://www.wrike.com/resend/";
    private String expectedMessageAfterSuccessfulSending = "Thanks for helping us out!";
    private String expectedStyleResendEmailButtonAfterClick = "transition: opacity 0.4s; opacity: 0;";
    private String expectedAddedItemInMassageAfterClickResendEmailButton = "again.";

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
    public void testScenario() throws InterruptedException {
        EVGSteps steps = new EVGSteps();
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
    }

    @AfterClass
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

    //*[@id="twitter"]

}
