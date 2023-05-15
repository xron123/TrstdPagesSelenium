package TrustedShops.Pages;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.TrustedShops.BaseClass.TrustedShopsBase;

public class ProfilePage extends TrustedShopsBase {

	private By gradeElementLocator = By.xpath("//*[@id=\"top\"]/div/div[4]/div[2]/div[1]/div[1]/div[2]/span");
	private By additionalInfoLinkLocator = By.xpath("//*[@id=\"top\"]/div/div[4]/div[2]/div[1]/div[2]/a");
	private By modalWindowLocator = By.xpath("//*[@id=\"top\"]/div/div[4]/div[3]");
	private By contentRelevantLocator = By.xpath("//*[@id=\"top\"]/div/div[4]/div[4]/div[2]/div/h2[1]/pre");
	private By twoStarFilterLocator = By.xpath("//*[@id=\"top\"]/div/div[4]/div[2]/div[2]/div[1]/a[4]/div[2]/div[2]");
	private By reviewsLocator = By.xpath("//div[@class='sc-2e7612c5-0 sc-f836bc46-0 kyZgbN chcERM']");
	private By yellowStarsLocator = By.xpath(
			".//span[contains(@class, 'Iconstyles__Icon-sc-hltmf-0') and @style='display: inline; color: rgb(255, 220, 15);']");
	private By starRatingsLocator = By.xpath("//div[@class='sc-61f2e426-8 iMXstX']/span[1]");

	public ProfilePage() throws IOException {
		super();

	}

	public Boolean doesPageTitleExist() {
		String pageTitle = driver.getTitle();

		boolean isPageTitlePresent = pageTitle != null && !pageTitle.isEmpty();

		return isPageTitlePresent;
	}

	public boolean isGradeVisibleAndAboveZero() {

		WebElement gradeElement = driver.findElement(gradeElementLocator);
		boolean isGradePresent = gradeElement.isDisplayed(); // verifying presence of grade score..1st condition
		String count = gradeElement.getText().replace(",", "");
		System.out.println(count);
		int stringToInt = Integer.parseInt(count); // parsing string to int
		boolean isGradeGreaterThanZero = stringToInt > 0; // verifying 2nd condition if score is above zero

		return isGradePresent && isGradeGreaterThanZero;
	}

	public boolean isAdditionalInfoWindowRelevant() throws InterruptedException {

		driver.findElement(additionalInfoLinkLocator).click();// clicking on"Wie berechnet sich die Note?"

		WebElement isWindowOpen = driver.findElement(modalWindowLocator);
		if (isWindowOpen.isDisplayed()) {
			System.out.println("Modal Window Opened");

		} else {

			System.out.println("Modal Window Not Opened");
		}
		String isContentRelevantActual = driver.findElement(contentRelevantLocator).getText();

		boolean isContentRelevantExpected = isContentRelevantActual
				.equals(dataProp.getProperty("pageRelevantExpectedResult"));

		return isContentRelevantExpected;
	}

	public boolean filterAndVerifyTwoStarReviews() throws InterruptedException {

		// Clicking on 2 Stars filter....
		driver.findElement(twoStarFilterLocator).click();
		try {
			WebElement bannerAcceptButton = driver.findElement(By.id("uc-btn-accept-banner"));// accepting policy using
																								// try catch..
			bannerAcceptButton.click();
		} catch (NoSuchElementException e) {

		}

		Thread.sleep(3000);
		// fetch all the reviews of the page...
		List<WebElement> reviews = driver.findElements(reviewsLocator);
		// iterate through the reviews and check if only two yellow stars r present..
		for (WebElement review : reviews) {
			List<WebElement> yellowStars = review.findElements(yellowStarsLocator);
			// true only when both condition @class condition nd @style color matches which
			// is only 2 in this case..
			if (yellowStars.size() != 2) { // if not equal 2 then fail, debug by changing to 3,4 etc
				System.out.println("Failed-Not all reviews are two stars.");
				return false;
			}
		}

		System.out.println("All reviews are two stars.");
		return true;
	}

	public boolean CalculateSumOfStarRatingsPercentage() {
		List<WebElement> spanElements = driver.findElements(starRatingsLocator);

		int sum = 0;
		for (WebElement spanElement : spanElements) {
			String text = spanElement.getText().trim().replace("<", "").trim(); // last trim coz of space 7
			// System.out.println(text.getClass().getSimpleName());//to check data type

			int number = Integer.parseInt(text);
			System.out.println(number);
			sum = sum + number;
		}

		System.out.println("Sum of all values: " + sum);
		if (sum == 100 || sum < 100) { // test case says 100 or less than 100.
			return true;
		} else {
			return false;
		}

	}
}
