package acme.testing.anonymous.task;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;


public class AnonymousTaskShowTest extends AcmeWorkPlansTest{
	
	//Listing negative test case.
			@ParameterizedTest
			@CsvFileSource(resources = "/anonymous/task/show-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
			@Order(17)
			public void listAllNegative(final int recordIndex, final String path, final String query) {
							
				super.navigate(path,query);
				super.checkErrorsExist();
			}

}
