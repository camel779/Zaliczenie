import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class accReg {

    private WebDriver driver;


    @Given("^an open browser with https://tester\\.codersguru\\.pl/$")
    public void anOpenBrowserWithHttpsTesterCodersguruPl() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");
        driver = new ChromeDriver();


        driver.manage().window().maximize();

        driver.get("https://tester.codersguru.pl/");


    }

    @When("^user click on \"([^\"]*)\" button$")
    public void userClickOnButton(String arg0) throws Throwable {
        WebElement button = driver.findElement(By.xpath("/html/body/section[3]/div/form/input[2]"));
        button.submit(); //find and clikc button "Załóż konto"
        throw new PendingException();




    }

    @Then("^fill registration form, log in$")
    public void fillRegistrationFormLogIn() {

        fillText("input#fos_user_registration_form_email", "camtest57@gmail.com");

        fillText("input#fos_user_registration_form_name", "Janusz");

        fillText("input#fos_user_registration_form_lastname", "Kowalski");

        fillText("input#fos_user_registration_form_plainPassword_first", "Jogurt111");

        fillText("input#fos_user_registration_form_plainPassword_second", "Jogurt111");

        fillText("input#form_city", "Wroclaw");

        fillText("input#form_postal_code", "50-001");

        fillText("input#form_street", "Krótka");

        fillText("input#form_number", "3");

        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"registration-main-form\"]/div[12]/input"));

        checkbox.submit();

        WebElement registry = driver.findElement(By.cssSelector("button#register-submit-btn"));

        registry.submit();
    }

    private void fillText(String css, String value) {

        WebElement element = driver.findElement(By.cssSelector(css));

        element.clear();

        element.sendKeys(value);
    }

    @And("^close browser$")
    public void closeBrowser() {

            driver.quit();


        }
    }
