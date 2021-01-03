package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CategoryPage extends AbstractPage {

    private static final By byItemsNames = By.xpath("//a[@class='product-title__text product-title--clamp']");

    public CategoryPage() {
        super();
        logger.info("Opened category page " + driver.getCurrentUrl());
    }

    @Override
    public CategoryPage openPage() {
        logger.error("Cannot open CategoryPage by itself! Throwing exception");
        throw new RuntimeException("Cannot open CategoryPage by itself!");
    }

    public List<String> getItemsNames() {
        List<String> toReturn = new ArrayList<>();
        List<WebElement> itemsNamesList = driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byItemsNames));
        for(WebElement item : itemsNamesList) {
            toReturn.add(item.getText());
        }
        return toReturn;
    }

    public CategoryPage applyFilter(String filter) {
        String firstItemName = driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byItemsNames)).get(0).getText();
        System.out.println(firstItemName);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//a[@class='ng-tns-c109-0 ng-star-inserted' and contains(text(), '" +
                filter
                + "')]"))).click();
        driverWait.until(driver -> !driver.findElement(byItemsNames).getText().equals(firstItemName));
        return this;
    }
}
