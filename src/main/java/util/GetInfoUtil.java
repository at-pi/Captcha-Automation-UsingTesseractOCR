package util;

import org.openqa.selenium.WebElement;

import java.util.List;

public class GetInfoUtil {
    public static String[] GetInfoArray(List<WebElement> ListElement){
        String[] InfoArray = new String[19];
        for(int i=0;i<19;i++){
            InfoArray[i] = ListElement.get(2*i+1).getText();
        }
        return InfoArray;
    }
}
