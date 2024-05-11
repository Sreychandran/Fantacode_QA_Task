package testcasesuite;

import net.bytebuddy.build.Plugin;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testexecutioncomponents.*;

import java.io.IOException;

public class TestCases {


    WebDriver driver = new ChromeDriver();
    CaptchaReaderComponent tes = new CaptchaReaderComponent(driver);
    SoftAssert asrt = new SoftAssert();


    @Test(testName = "Make sure that user is properly taken to amazon.com", priority = 1)
    public void testcaseOne() throws TesseractException, IOException, InterruptedException {

        FirstTestCaseComponent obj = new FirstTestCaseComponent(driver);
        obj.goToAmazon("https://www.amazon.com/");
        tes.captchaSolver();
        String actualUrl = obj.currentUrlChecker();
        String expectedUrl = "https://www.amazon.com/";
        asrt.assertEquals(actualUrl, expectedUrl, "Url is not matched");
        String actualTitle = obj.titleChecker();
        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        asrt.assertEquals(actualTitle, expectedTitle, "Title is not matched");
        asrt.assertAll();


    }


    @Test(testName = "Search for amazon basics and verify the result", priority = 2)
    public void testcaseTwo() {

        SecondTestCaseComponent obj = new SecondTestCaseComponent(driver);
        String actualResult = obj.searchAmazonBasics();
        String expectedResult = "\"amazon basics\"";
        asrt.assertEquals(actualResult, expectedResult, "The search result not matching with amazon basics");
        asrt.assertAll();


    }

    @Test(testName = "Verify the amazon brand checkbox is checked", priority = 3)
    public void testcaseThree() {

        ThirdTestCaseComponent obj = new ThirdTestCaseComponent(driver);
        boolean btnCheck = obj.clearBtnCheck();
        asrt.assertTrue(btnCheck, "Amazon brands checkbox is not checked");
        asrt.assertAll();


    }


    @Test(testName = "Verify that product page is displayed", priority = 4)
    public void testcaseFour() {

        ThirdTestCaseComponent obj = new ThirdTestCaseComponent(driver);
        String actualProdName = obj.productPageVerify();
        String expectedProdName = "Amazon Basics Freezer Gallon Bags, 90 Count (Previously Solimo)";
        asrt.assertEquals(actualProdName, expectedProdName, "The product name is not matching");
        asrt.assertAll();

    }

    @Test(testName = "Verify that \"Gallon (90 Count)\" is selected under 'Size' section on the product page", priority = 5)
    public void testcaseFifth() {

        FourthTestCaseComponent obj = new FourthTestCaseComponent(driver);
        String actualSize = obj.sizeCheck();
        String expectedSize = "Gallon (90 Count)";
        asrt.assertEquals(actualSize, expectedSize, "The size is not matched");
        asrt.assertAll();


    }

    @Test(testName = " Click on Add to Cart button and Verify the item added to cart", priority = 6)
    public void testcaseSix() {

        FourthTestCaseComponent obj = new FourthTestCaseComponent(driver);
        String actualAddToCartConfirmationText = obj.addToCartClick();
        String expectedAddToCartConfirmationText = "Added to Cart";
        asrt.assertEquals(actualAddToCartConfirmationText, expectedAddToCartConfirmationText, "The product is not added");
        asrt.assertAll();


    }

    @Test(testName = "Verify cart shows Subtotal (1 item)", priority = 7)
    public void testcaseSeven() {

        FourthTestCaseComponent obj = new FourthTestCaseComponent(driver);
        obj.goToCartBtnAction();
        String actualSubTotal = obj.subTotalChecker();
        String expectedSubTotal = "Subtotal (1 item):";
        asrt.assertEquals(actualSubTotal, expectedSubTotal, "Subtotal is not matched");
        asrt.assertAll();


    }


}
