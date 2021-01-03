package test;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import page.MainPage;
import service.CatalogDataReader;

import java.util.List;

public class CatalogTest extends CommonConditions {

    @Test
    public void testCatalog() {
        List<String> actualItemNames = new MainPage()
                .openPage()
                .openCatalog()
                .openCatalogCategory(CatalogDataReader.getTestDataCatalogCategory())
                .openCatalogSubcategory(CatalogDataReader.getTestDataCatalogSubcategory())
                .getItemsNames();
        String expectedName = CatalogDataReader.getTestdataCatalogExpectedName();
        assertThat(actualItemNames).allMatch(item -> item.toLowerCase().contains(expectedName));
    }
}
