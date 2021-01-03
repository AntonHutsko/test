package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Utils;

import java.util.List;

public class PostNavBarPage extends AbstractPage {

    private static final By byNavBarCategoryProductsNames = By
            .xpath("//a[@class='c-preview-article__title-link c-link c-link_gray20']");

    @FindBy(xpath = "//a[@class='c-preview-article__title-link c-link c-link_gray20']")
    private List<WebElement> navBarCategoryProductsNames;

    public List<String> getListOfNavBarCategoryProductsNames(){
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byNavBarCategoryProductsNames));
        return Utils.parseListOfWebElementsToListOfStrings(navBarCategoryProductsNames);
    }

    public PostNavBarPage() {
        super();
        logger.info("Opened search results page " + driver.getCurrentUrl());
    }

    @Override
    public PostNavBarPage openPage() {
        logger.error("Cannot open PostNavBarPage by itself! Throwing exception");
        throw new RuntimeException("Cannot open PostNavBarPage by itself!");
    }
}
