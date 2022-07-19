package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import cucumber.api.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.junit.Assert.assertTrue;

public class CommonSteps {
 public static WebDriver driver;

 /*Questo è il metodo che starebbe nella classe main di Java, in questo caso tramite il set property,
 * come parametri setto quale deve essere il driver di connessione per il browser indicato, ovvero chrome
 * e successivamente indicato il percorso nel quale si trova effettivamente il chrome driver per la versione
 * 103 di Chrome.
 * Per impostare funzionalità specifiche di chrome, utilizzo la class chrome driver. Desired Capabilities invece è una classe utilizzata
 * per dichiarare una serie di requisiti di base come combinazioni di browser, sistemi operativi, versioni di browser,
 * ad un'istanza di desired capabilities, applico il metodo */

    @When("I go to {string}")
    public static void iGoToEntryPage(String configParameter) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ale\\IdeaProjects\\SeleniumCucumber\\webdrivers\\chromedriver\\chromedriver.exe");
        ChromeOptions o= new ChromeOptions();
        o.addArguments("--incognito");
        DesiredCapabilities c = DesiredCapabilities.chrome();
        c.setCapability(ChromeOptions.CAPABILITY, o);
        driver = new ChromeDriver(c);
        driver.manage().window().maximize();
        driver.get(configParameter);
    }

    /*Attraverso questo metodo, gherkin*/
    @And("I fill {string} as a username and {string} as a password")
    public static void iFillAsAUsernameAndAsAPassword(String username, String password) {
        driver.findElement(By.xpath("(//*[contains(@class,'input text-sm border-2')])[1]")).sendKeys(username);
        driver.findElement(By.xpath("(//*[contains(@class,'input text-sm border-2')])[2]")).sendKeys(password);
    }

    @And("I accept coockie button")
    public void iAcceptCoockieButton() {
        /*WebElement elem = driver.findElement(By.xpath("(//div[@id='CybotCookiebotDialog']//*[contains(text(),'Accetta tutti i cookie')])[2]"));*/
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='CybotCookiebotDialog']//*[contains(text(),'Accetta tutti i cookie')])[2]"))).click();
    }

    @And("I click accediButton if is present")
    public void iClickAccediButtonIfIsPresent() {
        driver.findElement(By.xpath("(//button[@id='btn'])[1]")).click();
    }

    @And("I fill {} in the search bar")
    public static void EntrySteps(String elementToSearch) {
        driver.findElement(By.xpath("//div[@class='NewSearchBarComponent_searchBarText__3jDle']")).click();
        driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiInput-input MuiInputBase-inputAdornedStart']")).sendKeys(elementToSearch);
    }

    @Then("I select the first result of the searching")
    public static void searchElement(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class='MuiList-root NewSearchBarComponent_list__24Gdg MuiList-padding']//li)[1]"))).click();
    }


    @And("I select {} as an airport to departure")
    public void iSelectTheAirport(String airportChoosed) {
        if(airportChoosed.equals("MILANO MALPENSA")){
            //driver.findElement(By.xpath("//label[@class='NewSearchBarComponent_labelList__nk0k-']//span[contains(text(),'MILANO MALPENSA')]/following-sibling::span//input[@class='custom-input']")).click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@class='NewSearchBarComponent_labelList__nk0k-']//span[contains(text(),'MILANO MALPENSA')]/following-sibling::span//input[@class='custom-input']"))).click();
        }
        else if(airportChoosed.equals("BERGAMO")){
            driver.findElement(By.xpath("//label[@class='NewSearchBarComponent_labelList__nk0k-']//span[contains(text(),'BERGAMO')]/following-sibling::span//input[@class='custom-input']")).click();
        }
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained NewSearchBarComponent_footerButton__1vHTM false MuiButton-containedPrimary']")).click();
    }

    @And("I book for two people and i continue")
    public static void continuedToBook(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained NewSearchBarComponent_footerButton__1vHTM false MuiButton-containedPrimary']//span[@class='MuiButton-label']"))).click();
    }

    @And("I click 24 July and i go to the results page")
    public static void chooseTheDateAvailable(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='react-calendar__month-view__days']//child::button[@class='react-calendar__tile react-calendar__month-view__days__day react-calendar__month-view__days__day--weekend NewSearchBarComponent_tileContent__1OJ8J ']//abbr[contains(text(),'24')]"))).click();
        driver.findElement(By.xpath("//span[@class='MuiButton-label']//p[contains(text(),'vedi risultati')]")).click();
    }

    @Then("I scroll to the first result")
    public static void scrollToTheFirstResult(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='OfferContainerComponent_textWrapper__xYY_C OfferContainerComponent_horizontal__2apJh'])[1]")));
        Assert.assertTrue(driver.findElement(By.cssSelector("(//div[@class='OfferContainerComponent_textWrapper__xYY_C OfferContainerComponent_horizontal__2apJh'])[1]")).isSelected());
    }
}
