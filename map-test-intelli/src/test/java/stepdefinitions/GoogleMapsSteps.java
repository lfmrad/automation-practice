package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.TimeoutException;

public class GoogleMapsSteps {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }

    @Given("I open Google Maps")
    public void iOpenGoogleMaps() {
        driver.get("https://www.google.com/maps");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//span[contains(text(),'Aceptar todo')]]")
            ));
            acceptButton.click();
        } catch (TimeoutException e) {
            System.out.println("Element not found!");
        }
    }

    @When("I search for {string}")
    public void iSearchFor(String location) {
        WebElement searchBox = driver.findElement(By.id("searchboxinput"));
        searchBox.sendKeys(location);
        WebElement searchButton = driver.findElement(By.id("searchbox-searchbutton"));
        searchButton.click();
    }


    @Then("the location {string} should be displayed")
    public void theLocationShouldBeDisplayed(String location) {
        String title = driver.getTitle();
        // test
        Assert.assertTrue("Failed: specified location not found.", title.contains(location));
    }
}