package Steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login {
    WebDriver driver;

    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev-lms-frontend.joacademy.tech/auth/signin");
    }

    @When("I enter the Email and password")
    public void IEnterTheEmailAndPassword() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("email")).sendKeys("owner@app.com");
        driver.findElement(By.name("password")).sendKeys("12345678");
    }


    @And("I click on login button")
    public void iClickOnLoginButton() {
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
    }

    @Then("I should see the home page")
    public void iShouldSeeTheHomePage() {
        driver.findElement(By.id("home")).isDisplayed();
        driver.quit();
    }
//===============================================================================================================

    @Given("I navigate to login page")
    public void iNavigateToLoginPage() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://dev-lms-frontend.joacademy.tech/auth/signin");
    }

    @When("I enter the email as {string} and password as {string}")
    public void iEnterTheEmailAsAndPasswordAs(String Email, String Password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("email")).sendKeys(Email);
        driver.findElement(By.name("password")).sendKeys(Password);

    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
    }

    @Then("Error message should appear")
    public void errorMessageShouldAppear() {
     driver.findElement(By.xpath("//div[contains(text(),'These credentials do not match our records.')]")).isDisplayed();
        System.out.println("Error message ");
        driver.quit();
    }


}