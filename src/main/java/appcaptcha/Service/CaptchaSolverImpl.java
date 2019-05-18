package appcaptcha.Service;

import appcaptcha.util.GetCaptchaUtil;
import appcaptcha.util.GetWebDriverUtil;
import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;

import net.sourceforge.tess4j.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class CaptchaSolverImpl {

    public static void main(String[] args)throws IOException, TesseractException, Exception{

        WebDriver driver = GetWebDriverUtil.getWebDriver();
        for (int i = 0; i < 10; i++) {
            WebElement ele = driver.findElement(By.id("captcha"));

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage fullImg = ImageIO.read(screenshot);


            String CaptchaString = GetCaptchaUtil.getCaptchaString(ele, screenshot, fullImg);
            CaptchaString = CaptchaString.toLowerCase();
            System.out.println(CaptchaString);

            //Filling CIN
/*

            WebElement FillCaptcha = driver.findElement(By.id("userEnteredCaptcha"));

            FillCaptcha.sendKeys(CaptchaString);
*/

            //Checking if captcha suceeded or not

        }
    }
}
