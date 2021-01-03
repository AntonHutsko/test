package test;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import page.FavoritesPage;
import page.ProductPage;
import service.ProductPageDataReader;

public class FavoritesTest extends CommonConditions {

    @Test
    public void testAddToFavorites() {
        String expectedName = new ProductPage(ProductPageDataReader.getProductPageUrl())
                .openPage()
                .addToFavorites()
                .getProductName();
        String actualName = new FavoritesPage()
                .openPage()
                .getItemNameByIndex(0);
        assertThat(expectedName).isEqualTo(actualName);
    }
}
