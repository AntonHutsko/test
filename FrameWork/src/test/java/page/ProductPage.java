package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Utils;

public class ProductPage extends AbstractPage {

    @FindBy (xpath = "//input[@data-init='addToBasket']")
    private WebElement addToBasketButton;

    @FindBy (xpath = "//span[@class='c-btn__text c-blinking-text__unchecked']")
    private WebElement addToFavoritesButton;

    @FindBy (xpath = "//span[@class='c-btn__text c-blinking-text__checked']")
    private WebElement addToBasketButtonAfterClick;

    @FindBy (xpath = "//div[@class='o-pdp-topic__title']")
    private WebElement productName;

    @FindBy (xpath = "//span[@class='c-btn__text c-blinking-text__checked' and contains(text(), 'В сравнении')]")
    private WebElement addToComparisonButtonAfterClick;

    @FindBy (xpath = "//div[@class='fl-pdp-price__current']")
    private WebElement productPrice;

    @FindBy (xpath = "//span[@class='c-btn__text c-blinking-text__unchecked' and contains(text(), 'В сравнение')]")
    private WebElement addToComparisonButton;

    private String productPageUrl;

    public ProductPage(String pageUrl) {
        super();
        this.productPageUrl = pageUrl;
    }

    public ProductPage() {
        super();
    }

    @Override
    public ProductPage openPage() {
        driver.navigate().to(productPageUrl);
        logger.info("Opened page " +  productPageUrl);
        return this;
    }

    public ProductPage addToBasket() {
        addToBasketButton.click();
        driverWait.until(ExpectedConditions.attributeToBe(addToBasketButton, "value", "Перейти в корзину"));
        return this;
    }

    public ProductPage addToFavorites() {
        addToFavoritesButton.click();
        driverWait.until(ExpectedConditions.visibilityOf(addToBasketButtonAfterClick));
        return this;
    }

    public ProductPage addToComparison() {
        addToComparisonButton.click();
        driverWait.until(ExpectedConditions.visibilityOf(addToComparisonButtonAfterClick));
        return this;
    }

    public String getProductName() {
        return productName.getText();
    }

    public int getProductPrice() {
        return Utils.convertPriceStringToInt(productPrice.getText());
    }

}
