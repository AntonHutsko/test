package service;

public class ProductPageDataReader {

    private static final String TESTDATA_PRODUCT_PAGE_URL = "testdata.page.url";

    public static String getProductPageUrl(){
        return TestDataReader.getTestData(TESTDATA_PRODUCT_PAGE_URL);
    }

}
