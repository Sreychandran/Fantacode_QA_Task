package testexecutioncomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecondTestCaseComponent {

    WebDriver driver;
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement amazonSearchBox;
    @FindBy(id = "nav-search-submit-button")
    WebElement amazonSearchButton;
    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    WebElement amazonBasicsLabel;

    public SecondTestCaseComponent(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public String searchAmazonBasics() {


        amazonSearchBox.sendKeys("amazon basics");
        amazonSearchButton.click();
        String labelText = amazonBasicsLabel.getText();
        return labelText;


    }


}
