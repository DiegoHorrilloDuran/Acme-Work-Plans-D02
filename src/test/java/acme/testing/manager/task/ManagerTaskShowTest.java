package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;


public class ManagerTaskShowTest extends AcmeWorkPlansTest{
	
	/*
	TEST SHOW NEGATIVO
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/show-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(44)
	public void listAllNegative(final int recordIndex, final String path, final String query) {
		
		super.navigate(path,query);
		super.checkErrorsExist();
	}

}