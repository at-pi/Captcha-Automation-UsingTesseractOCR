package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetWebDriverUtil {

    public static WebDriver getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "/home/tribe3/IdeaProjects/FINAL/chromedriver.exe");
        String url = "http://www.mca.gov.in/mcafoportal/viewCompanyMasterData.do";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }

}