package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.time.Duration;
import java.time.Duration;
import java.util.Properties;

public class WebTestBase {

    public static WebDriver driver;
    public static Properties prop;

    public WebTestBase() {
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/properties/config.properties");
            prop = new Properties();
            prop.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("fixefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
            driver = new InternetExplorerDriver();
        } else {
            try {
                throw new Exception("pls add correct browser name");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        driver.navigate().to(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GenericUtility.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GenericUtility.IMPLICIT_WAIT));
        driver.manage().deleteAllCookies();
    }
}





