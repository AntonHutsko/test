package test;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import page.CartPage;
import page.MainPage;
import service.PlaceOfDeliveryDataReader;

public class PlaceOfDeliveryTest extends CommonConditions {

    @Test
    public void testChangePlaceOfDelivery() {
        String expectedPlaceOfDelivery = PlaceOfDeliveryDataReader.getNewPlaceOfDelivery();
        new MainPage()
                .openPage()
                .changePlaceOfDelivery(expectedPlaceOfDelivery);
        String actualPlaceOfDelivery = new CartPage()
                .openPage()
                .getCurrentPlaceOfDelivery();
        assertThat(actualPlaceOfDelivery).isEqualTo(expectedPlaceOfDelivery);
    }
}
