package acme.testing.authenticated.manager;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;


public class AuthenticatedManagerTest extends AcmePlannerTest {

	//Aquí vamos a testear si esta un administrador autenticado como manager caso positivo
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/manager/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(33)
	public void listAllTasks(final int recordIndex, final String Username, final String Name,final String Surname,final String Email, final String Roles, final String Status) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Account", "Become a manager");
		super.clickOnSubmitButton("Accept");
		super.clickOnMenu("Administrator", "User accounts");
		
		super.clickOnListingRecord(recordIndex);

		super.checkInputBoxHasValue("roleList", Roles);
		super.signOut();
	}
//Create negative test case.
		@ParameterizedTest
		@CsvFileSource(resources = "/authenticated/manager/show-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(34)
		public void listAllNegative(final int recordIndex, final String path) {
			super.navigateTo(path);
			super.checkErrorsExist();
		}
}