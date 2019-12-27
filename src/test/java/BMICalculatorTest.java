import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class BMICalculatorTest {
    private WebDriver driver;
    private String link = "https://healthunify.com/bmicalculator/";

    @BeforeSuite
    public void initializeProperty() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

    }

    @BeforeMethod
    public void initialize() {
        driver = new ChromeDriver();
        driver.get(link);

    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void calculateKGCMsNormal() {
        driver.findElement(By.name("wg")).sendKeys("82");
        driver.findElement(By.name("ht")).sendKeys("185");
        driver.findElement(By.name("cc")).click();

        String actualMessage = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedMessage = "Your category is Normal";

        String actualISMetric = driver.findElement(By.name("si")).getAttribute("value");
        String actualUSMetric = driver.findElement(By.name("us")).getAttribute("value");
        String actualUKMetric = driver.findElement(By.name("uk")).getAttribute("value");
        String expectedISMetric = "23.96";
        String expectedUSMetric = "24.36";
        String expectedUKMetric = "152.15";

        assertEquals(actualMessage, expectedMessage, "Messages are not equal");
        assertEquals(actualISMetric, expectedISMetric, "IS Metric does not match the expected calculation");
        assertEquals(actualUSMetric, expectedUSMetric, "US Metric does not match the expected calculation");
        assertEquals(actualUKMetric, expectedUKMetric, "UK Metric does not match the expected calculation");

    }

    @Test
    public void calculateKGCMsSlim() {
        driver.findElement(By.name("wg")).sendKeys("40");
        driver.findElement(By.name("ht")).sendKeys("152");
        driver.findElement(By.name("cc")).click();

        String actualMessage = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedMessage = "Your category is Underweight";

        String actualISMetric = driver.findElement(By.name("si")).getAttribute("value");
        String actualUSMetric = driver.findElement(By.name("us")).getAttribute("value");
        String actualUKMetric = driver.findElement(By.name("uk")).getAttribute("value");

        String expectedISMetric = "17.31";
        String expectedUSMetric = "17.6";
        String expectedUKMetric = "109.92";

        assertEquals(actualMessage, expectedMessage, "Messages are not equal");
        assertEquals(actualISMetric, expectedISMetric, "IS Metric does not match the expected calculation");
        assertEquals(actualUSMetric, expectedUSMetric, "US Metric does not match the expected calculation");
        assertEquals(actualUKMetric, expectedUKMetric, "UK Metric does not match the expected calculation");

    }

    @Test
    public void calculateKGCMsFat() {
        driver.findElement(By.name("wg")).sendKeys("80");
        driver.findElement(By.name("ht")).sendKeys("152");
        driver.findElement(By.name("cc")).click();

        String actualMessage = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedMessage = "Your category is Obese";

        String actualISMetric = driver.findElement(By.name("si")).getAttribute("value");
        String actualUSMetric = driver.findElement(By.name("us")).getAttribute("value");
        String actualUKMetric = driver.findElement(By.name("uk")).getAttribute("value");

        String expectedISMetric = "34.63";
        String expectedUSMetric = "35.21";
        String expectedUKMetric = "219.9";

        assertEquals(actualMessage, expectedMessage, "Messages are not equal");
        assertEquals(actualISMetric, expectedISMetric, "IS Metric does not match the expected calculation");
        assertEquals(actualUSMetric, expectedUSMetric, "US Metric does not match the expected calculation");
        assertEquals(actualUKMetric, expectedUKMetric, "UK Metric does not match the expected calculation");

    }

    //HT Lesson 14
    @Test
    public void checkStarvationEquivalentValue() {
        driver.findElement(By.name("wg")).sendKeys("28");
        driver.findElement(By.name("ht")).sendKeys("142");
        driver.findElement(By.name("cc")).click();

        String actualMessage = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedMessage = "Your category is Starvation";

        assertEquals(actualMessage, expectedMessage, "Messages are not equal.");

    }

    @Test
    public void checkStarvationMaxBoundaryValue() {
        driver.findElement(By.name("wg")).sendKeys("34.19");
        driver.findElement(By.name("ht")).sendKeys("151");
        driver.findElement(By.name("cc")).click();

        String actualMessage = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedMessage = "Your category is Starvation";

        assertEquals(actualMessage, expectedMessage, "Messages are not equal");
    }

    @Test
    public void checkUnderweightEquivalentValue() {
        driver.findElement(By.name("wg")).sendKeys("50");
        driver.findElement(By.name("ht")).sendKeys("170");
        driver.findElement(By.name("cc")).click();

        String actualMessage = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedMessage = "Your category is Underweight";

        assertEquals(actualMessage, expectedMessage, "Messages are not equal.");

    }

    @Test
    public void checkUnderweightMaxBoundaryValue() {
        driver.findElement(By.name("wg")).sendKeys("53.45");
        driver.findElement(By.name("ht")).sendKeys("170");
        driver.findElement(By.name("cc")).click();

        String actualMessage = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedMessage = "Your category is Underweight";

        assertEquals(actualMessage, expectedMessage, "Messages are not equal.");
    }

    @Test
    public void checkUnderweightMinBoundaryValue() {
        driver.findElement(By.name("wg")).sendKeys("43.34");
        driver.findElement(By.name("ht")).sendKeys("170");
        driver.findElement(By.name("cc")).click();

        String actualMessage = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedMessage = "Your category is Underweight";

        assertEquals(actualMessage, expectedMessage, "Messages are not equal.");
    }

    @Test
    public void checkNormalEquivalentValue() {
        driver.findElement(By.name("wg")).sendKeys("82");
        driver.findElement(By.name("ht")).sendKeys("190");
        driver.findElement(By.name("cc")).click();

        String actualMessage = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedMessage = "Your category is Normal";

        assertEquals(actualMessage, expectedMessage, "Messages are not equal.");

    }

    @Test
    public void checkNormalMaxBoundaryValue() {
        driver.findElement(By.name("wg")).sendKeys("90.23");
        driver.findElement(By.name("ht")).sendKeys("190");
        driver.findElement(By.name("cc")).click();

        String actualMessage = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedMessage = "Your category is Normal";

        assertEquals(actualMessage, expectedMessage, "Messages are not equal.");
    }

    @Test
    public void checkNormalMinBoundaryValue() {
        driver.findElement(By.name("wg")).sendKeys("53.47");
        driver.findElement(By.name("ht")).sendKeys("170");
        driver.findElement(By.name("cc")).click();

        String actualMessage = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedMessage = "Your category is Normal";

        assertEquals(actualMessage, expectedMessage, "Messages are not equal.");
    }

    @Test
    public void checkOverweightEquivalentValue() {
        driver.findElement(By.name("wg")).sendKeys("75");
        driver.findElement(By.name("ht")).sendKeys("170");
        driver.findElement(By.name("cc")).click();

        String actualMessage = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedMessage = "Your category is Overweight";

        assertEquals(actualMessage, expectedMessage, "Messages are not equal.");

    }

    @Test
    public void checkOverweightMaxBoundaryValue() {
        driver.findElement(By.name("wg")).sendKeys("86.67");
        driver.findElement(By.name("ht")).sendKeys("170");
        driver.findElement(By.name("cc")).click();

        String actualMessage = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedMessage = "Your category is Overweight";

        assertEquals(actualMessage, expectedMessage, "Messages are not equal.");
    }

    @Test
    public void checkOverweightMinBoundaryValue() {
        driver.findElement(By.name("wg")).sendKeys("72.25");
        driver.findElement(By.name("ht")).sendKeys("170");
        driver.findElement(By.name("cc")).click();

        String actualMessage = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedMessage = "Your category is Overweight";

        assertEquals(actualMessage, expectedMessage, "Messages are not equal.");
    }

    @Test
    public void checkObeseEquivalentValue() {
        driver.findElement(By.name("wg")).sendKeys("100");
        driver.findElement(By.name("ht")).sendKeys("170");
        driver.findElement(By.name("cc")).click();

        String actualMessage = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedMessage = "Your category is Obese";

        assertEquals(actualMessage, expectedMessage, "Messages are not equal.");

    }

    @Test
    public void checkObeseMinBoundaryValue() {
        driver.findElement(By.name("wg")).sendKeys("86.69");
        driver.findElement(By.name("ht")).sendKeys("170");
        driver.findElement(By.name("cc")).click();

        String actualMessage = driver.findElement(By.name("desc")).getAttribute("value");
        String expectedMessage = "Your category is Obese";

        assertEquals(actualMessage, expectedMessage, "Messages are not equal.");
    }

    @Test
    public void emptyWeightFieldValidation() {
        driver.findElement(By.name("ht")).sendKeys("185");
        driver.findElement(By.name("cc")).click();

        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "Enter the value for weight";

        assertEquals(actualMessage, expectedMessage, "Empty weight validation returns incorrect message.");
    }

    @Test
    public void weightInputNotAcceptedCharacters() {
        driver.findElement(By.name("wg")).sendKeys("kdsv6hSzRO ");
        String actualMessage1 = driver.findElement(By.name("wg")).getAttribute("value"); //каким образом получить введенный текст?

        driver.findElement(By.name("wg")).clear();
        driver.findElement(By.name("wg")).sendKeys("!@#$%^&*~`(){}[];:'\"<>/\\_=+-");
        String actualMessage2 = driver.findElement(By.name("wg")).getAttribute("value");

        driver.findElement(By.name("wg")).clear();
        driver.findElement(By.name("wg")).sendKeys("¶«ª¨§¦¥¢¡£© ");
        String actualMessage3 = driver.findElement(By.name("wg")).getAttribute("value");

        driver.findElement(By.name("wg")).clear();
        driver.findElement(By.name("wg")).sendKeys(" булок бы тех французских");
        String actualMessage4 = driver.findElement(By.name("wg")).getAttribute("value");

        driver.findElement(By.name("wg")).clear();
        driver.findElement(By.name("wg")).sendKeys("园丁杀手");
        String actualMessage5 = driver.findElement(By.name("wg")).getAttribute("value");

        driver.findElement(By.name("wg")).clear();
        driver.findElement(By.name("wg")).sendKeys("  ");
        String actualMessage6 = driver.findElement(By.name("wg")).getAttribute("value");

        String expectedMessage = "";

        assertEquals(actualMessage1, expectedMessage, "Input of not-allowed characters is possible.");
        assertEquals(actualMessage2, expectedMessage, "Input of not-allowed characters is possible.");
        assertEquals(actualMessage3, expectedMessage, "Input of not-allowed characters is possible.");
        assertEquals(actualMessage4, expectedMessage, "Input of not-allowed characters is possible.");
        assertEquals(actualMessage5, expectedMessage, "Input of not-allowed characters is possible.");
        assertEquals(actualMessage6, expectedMessage, "Input of not-allowed characters is possible.");
    }

    @Test
    public void onTheGoWeightConversionToPounds() {
        new Select(driver.findElement(By.name("opt1"))).selectByVisibleText("kilograms");
        driver.findElement(By.name("wg")).sendKeys("57");
        new Select(driver.findElement(By.name("opt1"))).selectByVisibleText("pounds");
        String actualWeight = driver.findElement(By.name("wg")).getAttribute("value");
        String expectedWeight = String.valueOf(57 * 2.2046226).substring(0, String.valueOf(57 * 2.2046226).indexOf(".")+2);
        //just an option how it could be done - depends on requirements

        assertEquals(actualWeight, expectedWeight, "Conversion done does not meet the conversion rate.");
    }

    @Test
    public void onTheGoWeightConversionToKilograms() {
        new Select(driver.findElement(By.name("opt1"))).selectByVisibleText("pounds");
        driver.findElement(By.name("wg")).sendKeys("125.5");
        new Select(driver.findElement(By.name("opt1"))).selectByVisibleText("kilograms");
        String actualWeight = driver.findElement(By.name("wg")).getAttribute("value");
        String expectedWeight = String.valueOf(Math.round(125.5 / 2.2046226));
        //just an option how it could be done - depends on requirements

        assertEquals(actualWeight, expectedWeight, "Conversion done does not meet the conversion rate.");
    }

    @Test
    public void lessThanMinimalWeightInKilosValidation() {
        new Select(driver.findElement(By.name("opt1"))).selectByVisibleText("kilograms");
        driver.findElement(By.name("wg")).sendKeys("9.99");
        driver.findElement(By.name("ht")).sendKeys("100");
        driver.findElement(By.name("cc")).click();

        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "Weight should be greater than 10kgs";

        assertEquals(actualMessage, expectedMessage, "Empty weight validation returns incorrect message.");
    }

    @Test
    public void lessThanMinimalWeightInPoundsValidation() {
        new Select(driver.findElement(By.name("opt1"))).selectByVisibleText("pounds");
        driver.findElement(By.name("wg")).sendKeys("21.99");
        driver.findElement(By.name("ht")).sendKeys("100");
        driver.findElement(By.name("cc")).click();

        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "Weight should be greater than 22lbs";

        assertEquals(actualMessage, expectedMessage, "Empty weight validation returns incorrect message.");
    }

    @Test
    public void boundaryMinimalWeightInKilosValidation() {
        new Select(driver.findElement(By.name("opt1"))).selectByVisibleText("kilograms");
        driver.findElement(By.name("wg")).sendKeys("10");
        driver.findElement(By.name("ht")).sendKeys("100");
        driver.findElement(By.name("cc")).click();

        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "Weight should be greater than 10kgs";

        assertEquals(actualMessage, expectedMessage, "Empty weight validation returns incorrect message.");
    }

    @Test
    public void boundaryMinimalWeightInPoundsValidation() {
        new Select(driver.findElement(By.name("opt1"))).selectByVisibleText("pounds");
        driver.findElement(By.name("wg")).sendKeys("22");
        driver.findElement(By.name("ht")).sendKeys("100");
        driver.findElement(By.name("cc")).click();

        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "Weight should be greater than 22lbs";

        assertEquals(actualMessage, expectedMessage, "Empty weight validation returns incorrect message.");
    }
}

