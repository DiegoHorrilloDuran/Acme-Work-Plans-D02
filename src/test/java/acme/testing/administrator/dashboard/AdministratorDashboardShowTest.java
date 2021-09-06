package acme.testing.administrator.dashboard;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;


public class AdministratorDashboardShowTest extends AcmeWorkPlansTest {

	//Show positive test case.
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/dashboard/show.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(25)
	public void show(final int recordIndex, final String numberOfPrivateTasks, final String numberOfPublicTasks,
		final String numberOfFinishedTasks, final String numberOfUnfinishedTasks, final String maxTaskExecutionPeriod, final String minTaskExecutionPeriod, 
		final String avgTaskExecutionPeriods, final String stdDevTaskExecutionPeriods, final String maxTaskWorkload, 
		final String minTaskWorkload, final String avgTaskWorkloads, final String stdDevTaskWorkloads) {
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Dashboard");

		super.checkInputBoxHasValue("numberOfPrivateTasks", numberOfPrivateTasks);
		super.checkInputBoxHasValue("numberOfPublicTasks", numberOfPublicTasks);
		super.checkInputBoxHasValue("numberOfFinishedTasks", numberOfFinishedTasks);
		super.checkInputBoxHasValue("numberOfUnfinishedTasks", numberOfUnfinishedTasks);
		super.checkInputBoxHasValue("maxTaskExecutionPeriod", maxTaskExecutionPeriod);
		super.checkInputBoxHasValue("minTaskExecutionPeriod", minTaskExecutionPeriod);
		super.checkInputBoxHasValue("avgTaskExecutionPeriods", avgTaskExecutionPeriods);
		super.checkInputBoxHasValue("stdDevTaskExecutionPeriods", stdDevTaskExecutionPeriods);
		super.checkInputBoxHasValue("maxTaskWorkload", maxTaskWorkload);
		super.checkInputBoxHasValue("minTaskWorkload", minTaskWorkload);
		super.checkInputBoxHasValue("avgTaskWorkloads", avgTaskWorkloads);
		super.checkInputBoxHasValue("stdDevTaskWorkloads", stdDevTaskWorkloads);

		super.signOut();
	}
	
	//Listing negative test case.
		@ParameterizedTest
		@CsvFileSource(resources = "/administrator/dashboard/show-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(26)
		public void listAllNegative(final int recordIndex, final String path) {
						
			super.navigateTo(path);
			super.checkErrorsExist();
		}
		
}
