package testexecutioncomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testlaunchcomponents.BaseComponent;

import java.time.Duration;

public class FirstTestCaseComponent {

    WebDriver driver;

    public FirstTestCaseComponent(WebDriver driver) {

        this.driver = driver;

    }


    public void goToAmazon(String url) {

        BaseComponent.browserLauch();
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().window().maximize();

    }

    public String currentUrlChecker() {

        String url = driver.getCurrentUrl();
        return url;

    }

    public String titleChecker() {

        String title = driver.getTitle();
        return title;


    }


}
