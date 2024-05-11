package testlaunchcomponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BaseComponent {


    public static void browserLauch() {

        WebDriverManager.chromedriver().setup();

    }


}
