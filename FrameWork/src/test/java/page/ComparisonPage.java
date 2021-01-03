package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComparisonPage extends AbstractPage {
    private static final String BASE_URL = "https://www.mvideo.ru/product-comparison";

    private static final By byItemName = By.xpath("//a[@class='sel-product-tile-title']");

    @FindBy (xpath = "//div[@class='c-compare-cell c-compare-cell_border c-compare-cell__pinable-product-tile']")
    private List<WebElement> addedItems;

    public ComparisonPage()
    {
        super();
    }

    @Override
    public ComparisonPage openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Opened page " + BASE_URL);
        return this;
    }

    public String getProductNameByIndex(int index) {
        return addedItems.get(index).findElement(byItemName).getText();
    }
}
