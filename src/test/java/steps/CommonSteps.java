package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.Assert.assertTrue;

public class CommonSteps {
 public static WebDriver driver;

    @When("I go to {string}")
    public static void iGoToEntryPage(String configParameter) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ale\\IdeaProjects\\SeleniumCucumber\\webdrivers\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(configParameter);
    }

    @And("I fill {string} as a username and {string} as a password")
    public static void iFillAsAUsernameAndAsAPassword(String username, String password) {
        driver.findElement(By.xpath("(//*[contains(@class,'input text-sm border-2')])[1]")).sendKeys(username);
        driver.findElement(By.xpath("(//*[contains(@class,'input text-sm border-2')])[2]")).sendKeys(password);
    }

    @And("I accept coockie button")
    public void iAcceptCoockieButton() {
        WebElement elem = driver.findElement(By.xpath("//div[@class='artdeco-global-alert-action__wrapper']//button[contains(text(),'Accetta')]"));
        if (elem.isDisplayed()){
            elem.click();
        }
    }

    @And("I click accediButton if is present")
    public void iClickAccediButtonIfIsPresent() {
        WebElement elem = driver.findElement(By.xpath("(//button[@id='btn'])[1]"));
        elem.click();
    }

    @And("I fill {} in the search bar")
    public static void EntrySteps(String elementToSearch) {
        driver.findElement(By.xpath("//input[@placeholder='search-global-typeahead__input always-show-placeholder']")).sendKeys(elementToSearch);
        //elem;
        //elem.sendKeys(Keys.ENTER);
    }

    @And("I select {} in the filter bar for the city of {}")
    public void iSelectInTheFilterBar(String filterChoosed, String cityChoosed) throws InterruptedException {
        WebElement elem = driver.findElement(By.xpath("//div[@id='search-reusables__filters-bar']//..//li[@class='search-reusables__primary-filter']//button[@aria-label='" + filterChoosed + "']"));
        System.out.println(elem);
        driver.wait(5000);
        WebElement elem2 = driver.findElement(By.xpath("//input[@id='jobs-search-box-location-id-ember564']"));
        elem2.sendKeys("cityChoosed");
        elem2.sendKeys(Keys.ENTER);
    }

}
