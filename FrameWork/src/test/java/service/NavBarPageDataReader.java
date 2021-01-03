package service;

public class NavBarPageDataReader {

    private static final String TESTDATA_NAVBAR_APPLE_PRODUCTS = "testdata.navbar.apple.products";

    public static String getTestDataNavBarAppleProducts(){
        return TestDataReader.getTestData(TESTDATA_NAVBAR_APPLE_PRODUCTS);
    }

}
