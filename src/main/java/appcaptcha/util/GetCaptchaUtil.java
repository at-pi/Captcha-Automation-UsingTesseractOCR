package appcaptcha.util;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GetCaptchaUtil {
    public static String getCaptchaString(WebElement ele, File screenshot, BufferedImage fullImg) throws IOException, TesseractException {
        Point point = ele.getLocation();

        int eleWidth = ele.getSize().getWidth();
        int eleHeight = ele.getSize().getHeight();

        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);

        ImageIO.write(eleScreenshot, "png", screenshot);

        File screenshotLocation = new File("captcha.png");
        FileUtils.copyFile(screenshot, screenshotLocation);
        File image = new File("captcha.png");
        Tesseract tessInst = new Tesseract();
        tessInst.setDatapath("tessdata");

        return tessInst.doOCR(image);
    }
}
