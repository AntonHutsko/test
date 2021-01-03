package test;

import org.testng.annotations.Test;
import page.MainPage;
import service.NavBarPageDataReader;
import util.Utils;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class NavBarTest extends CommonConditions {

    @Test
    public void testNavBar(){
        List<String> appleProductsNames = Utils
                .convertStringToListOfStrings(NavBarPageDataReader
                        .getTestDataNavBarAppleProducts());

        List<String> expectedAppleProductsNames = new MainPage()
                .openPage()
                .clickOnNavBarOption("Apple")
                .getListOfNavBarCategoryProductsNames();

        assertThat(expectedAppleProductsNames).allMatch(item -> appleProductsNames.stream().anyMatch(item::contains));

    }

}
