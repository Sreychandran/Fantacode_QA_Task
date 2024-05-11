package testexecutioncomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class FourthTestCaseComponent {

    WebDriver driver;

    @FindBy(xpath = "//span[@class='selection']")
    WebElement size;

    @FindBy(id = "add-to-cart-button")
    WebElement addToCartButton;

    @FindBy(xpath = "//h1[normalize-space()='Added to Cart']")
    WebElement addedToCartText;

    @FindBy(xpath = "//a[@href='/cart?ref_=sw_gtc']")
    WebElement goToCartBtn;

    @FindBy(id = "sc-subtotal-label-buybox")
    WebElement subTotalLabel;


    public FourthTestCaseComponent(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public String sizeCheck() {

        String sizeText = size.getText();
        return sizeText;


    }

    public String addToCartClick() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        addToCartButton.click();
        String addToCartLabel = addedToCartText.getText();
        return addToCartLabel;

    }

    public void goToCartBtnAction() {

        goToCartBtn.click();


    }

    public String subTotalChecker() {

        String subTotalItemText = subTotalLabel.getText();
        return subTotalItemText;


    }


}
