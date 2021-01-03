package service;

public class CatalogDataReader {
    private static final String TESTDATA_CATALOG_CATEGORY = "testdata.catalog.category";
    private static final String TESTDATA_CATALOG_SUBCATEGORY = "testdata.catalog.subcategory";
    private static final String TESTDATA_CATALOG_EXPECTED_NAME = "testdata.catalog.expectedName";

    public static String getTestDataCatalogCategory() {
        return TestDataReader.getTestData(TESTDATA_CATALOG_CATEGORY);
    }

    public static String getTestDataCatalogSubcategory() {
        return TestDataReader.getTestData(TESTDATA_CATALOG_SUBCATEGORY);
    }

    public static String getTestdataCatalogExpectedName() {
        return TestDataReader.getTestData(TESTDATA_CATALOG_EXPECTED_NAME);
    }
}
