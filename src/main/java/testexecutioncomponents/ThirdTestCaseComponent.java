package testexecutioncomponents;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ThirdTestCaseComponent {

    WebDriver driver;
    JavascriptExecutor exec;

    @FindBy(xpath = "//span[contains(text(),'Amazon Brands')]")
    WebElement fromOurBrandCheckBox;
    @FindBy(xpath = "//span[normalize-space()='Freezer Gallon Bags, 90 Count (Previously Solimo)']")
    WebElement product;
    @FindBy(xpath = "//span[@class='a-size-base a-color-base'][normalize-space()='Clear']")
    WebElement clearBtn;
    @FindBy(id="productTitle")
    WebElement productTitle;


    public ThirdTestCaseComponent(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        exec = (JavascriptExecutor) driver;

    }

    public String productPageVerify() {

        product.click();
        String prodTitle = productTitle.getText();
        return prodTitle;



    }

    public boolean clearBtnCheck()  {


        exec.executeScript("window.scrollBy(0,1200)", "");
        fromOurBrandCheckBox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        exec.executeScript("window.scrollBy(0,300)", "");
        boolean btnFlag = clearBtn.isDisplayed();
        return btnFlag;


    }


}
