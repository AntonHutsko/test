package util;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> parseListOfWebElementsToListOfStrings(List<WebElement> webElements) {
        List<String> listOfInnerTextsFromWebElements = new ArrayList<>();
        for (WebElement element :
                webElements) {
            if(!element.getText().equals("")) {
                listOfInnerTextsFromWebElements.add(element.getText());
            }
        }
        return listOfInnerTextsFromWebElements;
    }

    public static List<String> convertStringToListOfStrings(String line){
        List<String> listOfStrings = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < line.length(); i++){
            if(line.charAt(i) != ' '){
                if(line.charAt(i) == '_'){
                    word.append(' ');
                }else {
                    word.append(line.charAt(i));
                }

            }else {
                listOfStrings.add(word.toString());
                word = new StringBuilder();
            }
        }
        return listOfStrings;
    }

    public static int convertPriceStringToInt(String priceString) {
        return Integer
                .parseInt(priceString.replaceAll("[^0-9]", ""));
    }
}
