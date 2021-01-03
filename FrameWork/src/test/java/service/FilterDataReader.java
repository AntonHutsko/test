package service;

public class FilterDataReader {
    private static final String TESTDATA_FILTER_MANUFACTURER = "testdata.filter.manufacturer";

    public static String getFilter() {
        return TestDataReader.getTestData(TESTDATA_FILTER_MANUFACTURER);
    }
}
