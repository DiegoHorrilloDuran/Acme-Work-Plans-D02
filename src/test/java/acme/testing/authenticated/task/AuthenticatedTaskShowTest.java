package acme.testing.authenticated.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AuthenticatedTaskShowTest extends AcmePlannerTest {
	
	//Listing negative test case.
			@ParameterizedTest
			@CsvFileSource(resources = "/authenticated/task/show-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
			@Order(32)
			public void listAllNegative(final int recordIndex, final String path, final String query) {
							
				super.navigate(path,query);
				super.checkErrorsExist();
			}
}

