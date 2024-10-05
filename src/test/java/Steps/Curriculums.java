package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Curriculums {
WebDriver driver;
@Given("I navigate to Curriculum page from home page")
    public void iNavigateToCurriculumPage() {
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://dev-lms-frontend.joacademy.tech/auth/signin");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.findElement(By.name("email")).sendKeys("owner@app.com"); //Email
    driver.findElement(By.name("password")).sendKeys("12345678"); //Password
    driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click(); //SignIn button
    driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/aside[1]/div[1]/div[1]/div[1]/nav[1]/button[10]/div[1]/span[1]/*[1]")).click(); //sittings button
    driver.findElement(By.xpath("//a[contains(text(),'Curriculum')]")).click();
}


    @When("i enter on plus button should open create Curriculum page")
    public void iEnterOnPlusButtonShouldOpenCreateCurriculumPage() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/main[1]/div[1]/div[1]/button[1]")).click();

}

    @Then("i fill all info for Curriculum")
    public void iFillAllInfoForCurriculum() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.name("name.en")).sendKeys("new1233");// en name
        driver.findElement(By.name("name.ar")).sendKeys("new1233");// ar name
        driver.findElement(By.xpath("//body/div[@id='radix-:rq:']/div[2]/form[1]/div[1]/div[3]/button[1]")).click();// program
        driver.findElement(By.xpath("//div[contains(text(),'alaa')]")).click();
        WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.findElement(By.xpath("//body/div[@id='radix-:rq:']/div[2]/form[1]/div[1]/div[4]/button[1]")).click();//grade
        driver.findElement(By.xpath("//div[contains(text(),'Grade')]")).click();
        WebDriverWait wait2= new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.findElement(By.xpath("//body/div[@id='radix-:rq:']/div[2]/form[1]/div[1]/div[5]/button[1]")).clear();//subject
        driver.findElement(By.xpath("//div[contains(text(),'newtest')]")).click();
}
    @And("click on create button")
    public void clickOnCreateButton() {
    driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
    }
}
