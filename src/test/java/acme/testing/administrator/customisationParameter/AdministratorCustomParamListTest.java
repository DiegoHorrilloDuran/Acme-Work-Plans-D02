package acme.testing.administrator.customisationParameter;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;


public class AdministratorCustomParamListTest extends AcmeWorkPlansTest {

	//Listing positive test case.
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/customisationParameter/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void listAll(final int recordIndex, final String spamWords, final String threshold) {
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Customisation Parameters");
		super.checkColumnHasValue(recordIndex, 0, spamWords);
		super.checkColumnHasValue(recordIndex, 1, threshold);
		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("spamWords", spamWords);
		super.checkInputBoxHasValue("threshold", threshold);
		
		super.signOut();
	}
	
	//Listing negative test case.
		@ParameterizedTest
		@CsvFileSource(resources = "/administrator/customisationParameter/list-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(21)
		public void listAllNegative(final int recordIndex, final String path) {
						
			super.navigateTo(path);
			super.checkErrorsExist();
		}
	
}
