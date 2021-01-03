package test;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import page.MainPage;
import service.CatalogDataReader;
import service.FilterDataReader;

import java.util.List;

public class FilterTest extends CommonConditions {

    @Test
    public void TestApplyFilter() {
        String filter = FilterDataReader.getFilter();
        List<String> itemsNamesAfterFilter = new MainPage()
                .openPage()
                .openCatalog()
                .openCatalogCategory(CatalogDataReader.getTestDataCatalogCategory())
                .openCatalogSubcategory(CatalogDataReader.getTestDataCatalogSubcategory())
                .applyFilter(filter)
                .getItemsNames();
        assertThat(itemsNamesAfterFilter).allMatch(item -> item.toLowerCase().contains(filter.toLowerCase()));
    }
}
