package trustedShops.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TrustedShops.BaseClass.TrustedShopsBase;
import TrustedShops.Pages.ProfilePage;

public class ProfilePageTestCases extends TrustedShopsBase {

	ProfilePage profilePage = new ProfilePage();

	public ProfilePageTestCases() throws IOException {
		super();

	}

	@Test
	public void verifyTitleExistence() {
		Boolean status = profilePage.doesPageTitleExist();

		Assert.assertTrue(status);
	}

	@Test
	public void verifyIsGradeVisibleAndAboveZero() {
		boolean status = profilePage.isGradeVisibleAndAboveZero();
		Assert.assertTrue(status);
	}

	@Test
	public void verifyIsAdditionalInfoWindowRelevant() throws InterruptedException {

		boolean status = profilePage.isAdditionalInfoWindowRelevant();
		Assert.assertTrue(status);
	}
	
	@Test
	public void verifyFilterAndVerifyTwoStarReviews () throws InterruptedException {
		
		boolean status = profilePage.filterAndVerifyTwoStarReviews();
		Assert.assertTrue(status);
	}
	
	@Test
	public void verifyCalculateSumOfStarRatingsPercentage() {
		boolean status =profilePage.CalculateSumOfStarRatingsPercentage();
		Assert.assertTrue(status);
		
	}
}
