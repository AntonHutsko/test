package test;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import page.MainPage;
import service.SearchDataReader;

import java.util.List;

public class SearchTest extends CommonConditions {

    @Test
    public void testSearchForQuery() {
        String query = SearchDataReader.getSearchQuery();
        List<String> searchResultingNames = new MainPage()
                .openPage()
                .enterSearchQuery(query)
                .searchForQuery()
                .getItemsNames();
        assertThat(searchResultingNames).allMatch(item -> item.toLowerCase().contains(query.toLowerCase()));
    }

    @Test
    public void testSearchLine(){
        String queryPart = SearchDataReader.getPartOfSearchQuery();

        List<String> suggestedItemsList = new MainPage()
                .openPage()
                .enterSearchQuery(queryPart)
                .getSuggestedItemsList();

        assertThat(suggestedItemsList).allMatch(item -> item.toLowerCase().contains(queryPart.toLowerCase()));
    }
}
