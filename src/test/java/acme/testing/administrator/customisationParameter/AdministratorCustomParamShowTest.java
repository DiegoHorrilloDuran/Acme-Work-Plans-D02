package acme.testing.administrator.customisationParameter;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;


public class AdministratorCustomParamShowTest extends AcmePlannerTest {
	
	//Listing negative test case.
		@ParameterizedTest
		@CsvFileSource(resources = "/administrator/customisationParameter/show-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(22)
		public void listAllNegative(final int recordIndex, final String path, final String query) {
						
			super.navigate(path,query);
			super.checkErrorsExist();
		}
	
}
