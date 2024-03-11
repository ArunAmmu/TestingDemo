package RunnerClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\feature\\Sauce.feature",glue = "",dryRun = false,
publish = true ,plugin = { "pretty",
        "html:CucumberReports",
        "json:reports/result.json",
        "junit:reports/result.xml"	})

//plugin = { "pretty",
//        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//        "html:CucumberReports",
//        "json:reports/result.json",
//        "junit:reports/result.xml"	})
public class RunnerClass {

    public static WebDriver driver;

@BeforeClass

public static void start () {
    driver = new ChromeDriver();
}


}
