package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends AbstractPage {

    private static final By byItemName = By.xpath("//a[@class='sel-product-tile-title']");

    @FindBy (xpath = "//div[@class='fl-product-tile c-product-tile ']")
    private List<WebElement> itemsList;

    public SearchResultsPage() {
        super();
        logger.info("Opened search results page " + driver.getCurrentUrl());
    }

    @Override
    public SearchResultsPage openPage() {
        logger.error("Cannot open SearchResultsPage by itself! Throwing exception");
        throw new RuntimeException("Cannot open SearchResultsPage by itself!");
    }

    public List<String> getItemsNames() {
        List<String> toReturn = new ArrayList<>();
        for(WebElement item : itemsList) {
            toReturn.add(item.findElement(byItemName).getText());
        }
        return toReturn;
    }
}
