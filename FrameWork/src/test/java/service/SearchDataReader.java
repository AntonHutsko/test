package service;

public class SearchDataReader {

    private static final String TEST_DATA_QUERY = "testdata.search.tvQuery";
    private static final String TESTDATA_PART_QUERY = "testdata.search.part.query";

    public static String getSearchQuery() {
        return TestDataReader.getTestData(TEST_DATA_QUERY);
    }

    public static String getPartOfSearchQuery(){
        return TestDataReader.getTestData(TESTDATA_PART_QUERY);
    }
}
