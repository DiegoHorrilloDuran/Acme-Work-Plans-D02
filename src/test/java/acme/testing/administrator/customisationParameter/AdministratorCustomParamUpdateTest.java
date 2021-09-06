package acme.testing.administrator.customisationParameter;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;


public class AdministratorCustomParamUpdateTest extends AcmeWorkPlansTest {

	//Positive update test case. Adds a new spamword and a new threshold.
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/customisationParameter/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(23)
	public void updatePositive(final int recordIndex, final String spamWords, final String threshold) {
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Customisation Parameters");
		super.clickOnListingRecord(recordIndex);
		
		super.fillInputBoxIn("spamWords", spamWords);
		super.fillInputBoxIn("threshold", threshold);
		super.clickOnSubmitButton("Update");
		
		super.clickOnMenu("Administrator", "Customisation Parameters");
		super.checkColumnHasValue(recordIndex, 0, spamWords);
		super.checkColumnHasValue(recordIndex, 1, threshold);
		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("spamWords", spamWords);
		super.checkInputBoxHasValue("threshold", threshold);
		
		super.signOut();
	}
	
	//Negative Update test case. Tries to update three invalid thresholds (a negative, a four decimals and a greater than 100 one)
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/customisationParameter/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(24)
	public void updateNegative(final int recordIndex, final String spamWords, final String threshold) {
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Customisation Parameters");
		super.clickOnListingRecord(recordIndex);
		
		super.fillInputBoxIn("spamWords", spamWords);
		super.fillInputBoxIn("threshold", threshold);
		super.clickOnSubmitButton("Update");
		
		super.checkErrorsExist();
		
		super.signOut();
	}
}
