package Suace_Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class BaseClass {

public static WebDriver driver ;

    public static void screenshot(WebDriver driver, String fileName) throws IOException {

        TakesScreenshot tk = (TakesScreenshot) driver;
        File source = tk.getScreenshotAs(OutputType.FILE);
        File destin = new File("C:\\Users\\91984\\Downloads\\saucedemo-automation-testing-master\\saucedemo-automation-testing-master\\Suace_Onlinecart\\src\\test\\SauceScreeshot" + fileName + ".png");
        FileUtils.copyFile(source, destin);
    }

}
