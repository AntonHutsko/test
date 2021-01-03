package service;

public class PlaceOfDeliveryDataReader {
    private static final String TESTDATA_PLACE_OF_DELIVERY = "testdata.newPlaceOfDelivery";

    public static String getNewPlaceOfDelivery() {
        return TestDataReader.getTestData(TESTDATA_PLACE_OF_DELIVERY);
    }
}
