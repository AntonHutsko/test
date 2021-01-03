package test;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import page.CartPage;
import page.ProductPage;
import service.ProductPageDataReader;

public class CartTest extends CommonConditions {

    @Test
    public void testAddToCart() {
        ProductPage productPage = new ProductPage(ProductPageDataReader.getProductPageUrl())
                .openPage()
                .addToBasket();
        String expectedName = productPage.getProductName();
        int expectedPrice = productPage.getProductPrice();

        CartPage cartPage = new CartPage()
                .openPage();
        String actualName = cartPage.getItemNameByIndex(0);
        int actualPrice = cartPage.getItemPriceByIndex(0);
        assertThat(actualName).isEqualTo(expectedName);
        assertThat(actualPrice).isEqualTo(expectedPrice);
    }

    @Test
    public void testMoneyChange(){
        ProductPage productPage = new ProductPage(ProductPageDataReader.getProductPageUrl())
                .openPage();
        int expectedDoublePrice = productPage
                .getProductPrice() * 2;
        productPage.addToBasket();
        CartPage cartPage = new CartPage()
                .openPage();
        int cartPrice = cartPage
                .clickOnPlusButton()
                .getCartPrice();

        assertThat(cartPrice).isEqualTo(expectedDoublePrice);
    }
}
