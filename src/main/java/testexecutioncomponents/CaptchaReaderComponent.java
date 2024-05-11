package testexecutioncomponents;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class CaptchaReaderComponent {

    WebDriver driver;
    @FindBy(xpath = "//div[@class = 'a-row a-text-center']//img")
    WebElement img;
    @FindBy(id = "captchacharacters")
    WebElement captchaField;

    public CaptchaReaderComponent(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void captchaSolver() throws TesseractException, IOException, InterruptedException {


        int maxOfAttempts = 50;
        int minOfattempt = 1;

        while (minOfattempt <= maxOfAttempts) {

            File src = img.getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "\\captchaimages\\captcha.png";
            FileHandler.copy(src, new File(path));

            ITesseract image = new Tesseract();
            image.setDatapath(System.getProperty("user.dir") + "\\tesseractdata");
            image.setLanguage("eng");
            /*
            tessaractdata path should be added into system environment variables
            here the path of the tessaractdata directory is "System.getProperty("user.dir") + "\\tesseractdata"
            system variable name should be TESSDATA_PREFIX
             */

            String captcha = image.doOCR(new File(path));
            captchaField.sendKeys(captcha);

            String match = driver.getTitle();


            if (Objects.equals(match, "Amazon.com. Spend less. Smile more.")) {

                break;


            }


            minOfattempt++;


        }


    }

}
