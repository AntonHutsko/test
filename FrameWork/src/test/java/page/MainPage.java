package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Utils;

import java.util.List;

public class MainPage extends AbstractPage {

	private static final String BASE_URL = "https://www.mvideo.ru/";

	private static final By bySuggestedItemsList = By
			.xpath("//span[@class='suggested-search-text ']");

	@FindBy (xpath = "//input[@id='header-search-input']")
	private WebElement searchInput;

	@FindBy (xpath = "//button[@class='c-text-field__search-button']")
	private WebElement searchButton;

	@FindBy(xpath = "//span[@class='suggested-search-text ']")
	private List<WebElement> suggestedItemsList;

	@FindBy (xpath = "//div[@class='header-main__catalog-btn']")
	private WebElement catalogButton;

	@FindBy (xpath = "//i[@class='i-icon i-icon-fl-location']")
	private WebElement changePlaceOfDeliveryButton;

	@FindBy (xpath = "//span[@class='c-btn_close font-icon icon-delete']")
	private WebElement closeChangePlaceOfDeliveryWindow;

	public MainPage()
	{
		super();
	}

	public PostNavBarPage clickOnNavBarOption(String option) {
		driverWait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//div[@class='header-collection__list-wrapper']" +
						"/div[@class='header-collection__list']" +
						"/a[@class='header-collection__item' and contains(text(), '"
						+ option + "')]"))).click();
		return new PostNavBarPage();
	}

	@Override
	public MainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Opened page " + BASE_URL);
		return this;
	}

	public MainPage enterSearchQuery(String query) {
		searchInput.sendKeys(query);
		return this;
	}

	public List<String> getSuggestedItemsList(){
		driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(bySuggestedItemsList));
		return Utils.parseListOfWebElementsToListOfStrings(suggestedItemsList);
	}

	public SearchResultsPage searchForQuery() {
		searchButton.click();
		return new SearchResultsPage();
	}

	public MainPage openCatalog() {
		catalogButton.click();
		return this;
	}

	public MainPage changePlaceOfDelivery(String newCity) {
		changePlaceOfDeliveryButton.click();
		driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//label[contains(text(), '" +
						newCity +
						"')]"))).click();
		return this;
	}

	public MainPage openCatalogCategory(String category) {
		WebElement categoryButton = driver.findElement(By.xpath(
				"//div[@class='header-catalog__category-name' and contains(text(), '"
						+ category
						+ "')]"));
		actions.moveToElement(categoryButton).perform();
		return this;
	}

	public CategoryPage openCatalogSubcategory(String subcategory) {
		WebElement subcategoryButton = driver.findElement(By.xpath("" +
				"//a[@class='c-link c-link_text header-catalog__subcategory']//span[contains(text(),'" +
				subcategory
				+ "')]"));
		subcategoryButton.click();
		return new CategoryPage();
	}

}
