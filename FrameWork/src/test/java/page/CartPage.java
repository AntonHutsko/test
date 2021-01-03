package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Utils;

import java.util.List;

public class CartPage extends AbstractPage {
    private static final String BASE_URL = "https://www.mvideo.ru/cart";

    private static final By byItemName = By.xpath("//a[@class='c-link c-cart-item__title']");
    private static final By byItemPrice = By.xpath("//span[@class='c-cart-item__price']");

    @FindBy (xpath = "//div[@class='c-cart-item__wrapper ']")
    private List<WebElement> addedItems;

    @FindBy(xpath = "//button[@class='c-btn c-btn_white c-counter-input__plus-btn c-counter-input__btn    ']")
    private WebElement plusButton;

    private static final By byPlusButton = By.xpath("//div[@class='c-counter-input c-cart-item__counter-input']" +
            "/button[@data-ga-content='plus']");

    private static final By byCartPrice = By.xpath("//span[@class='c-cost-line__text']");

    @FindBy(xpath = "//span[@class='c-cost-line__text']")
    private WebElement cartPrice;

    @FindBy (xpath = "//a[@class='c-link c-header-checkout__choose-city c-link_pseudo']")
    private WebElement currentPlaceOfDelivery;

    public CartPage()
    {
        super();
    }

    @Override
    public CartPage openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Opened page " + BASE_URL);
        return this;
    }

    public String getItemNameByIndex(int index) {
        return addedItems.get(index).findElement(byItemName).getText();
    }

    public int getItemPriceByIndex(int index) {
        return Utils.convertPriceStringToInt(addedItems.get(index).findElement(byItemPrice).getText());
    }

    public CartPage clickOnPlusButton(){
        String currentCartPrice = this.cartPrice.getText();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(byPlusButton)).click();
        driverWait.until(driver -> !driver.findElement(byCartPrice).getText().equals(currentCartPrice));
        return this;
    }

    public int getCartPrice(){
        return Utils.convertPriceStringToInt(this.cartPrice.getText());
    }
  
    public String getCurrentPlaceOfDelivery() {
        return currentPlaceOfDelivery.getText();
    }

}
