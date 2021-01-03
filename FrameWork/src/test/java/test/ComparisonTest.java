package test;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import page.ComparisonPage;
import page.ProductPage;
import service.ProductPageDataReader;

public class ComparisonTest extends CommonConditions {

    @Test
    public void testAddToComparison() {
        String expectedName = new ProductPage(ProductPageDataReader.getProductPageUrl())
                .openPage()
                .addToComparison()
                .getProductName();
        String actualName = new ComparisonPage()
                .openPage()
                .getProductNameByIndex(0);
        assertThat(expectedName).isEqualTo(actualName);
    }
}
