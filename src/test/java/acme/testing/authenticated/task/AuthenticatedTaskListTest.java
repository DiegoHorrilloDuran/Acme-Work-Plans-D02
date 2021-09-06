package acme.testing.authenticated.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;
//Aquí vamos a testear el mostrar el listado de todas las tasks authenticated casos positivos
public class AuthenticatedTaskListTest extends AcmeWorkPlansTest {

	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/task/listAll.csv", encoding = "utf-8", numLinesToSkip = 1)
  @Order(30)
  public void listAllTasks(final int recordIndex, final String Title, final String Start,final String End,final String Workload, final String Description, final String OptionalLink) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Authenticated", "Finished public tasks");
		
		super.checkColumnHasValue(recordIndex, 0, Title);
		super.checkColumnHasValue(recordIndex, 1, Start);
		super.checkColumnHasValue(recordIndex, 2, End);
		
		
		
		//Aquí vamos a testear el show de las tasks authenticated
		
		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("title", Title);
		super.checkInputBoxHasValue("start", Start);
		super.checkInputBoxHasValue("end", End);
		super.checkInputBoxHasValue("workload", Workload);
		super.checkInputBoxHasValue("description", Description);
		super.checkInputBoxHasValue("optionalLink", OptionalLink);
		
		super.signOut();
	}
	
	//Listing negative test case.
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/task/list-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(31)
	public void listAllNegative(final int recordIndex, final String path) {
					
		super.navigateTo(path);
		super.checkErrorsExist();
	}
}

