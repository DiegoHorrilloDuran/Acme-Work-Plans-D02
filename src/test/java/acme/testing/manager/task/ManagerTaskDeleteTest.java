package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

/*
 * En este test vamos a comprobar el caso positivo de borrar una task del manager.
 */
public class ManagerTaskDeleteTest extends AcmePlannerTest {
	
	/*
	 * CASO POSITIVO: Borramos una tarea correctamente
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/delete-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(47)
	public void deletePositive(final int recordIndex, final String title, final String start, final String end, final String workload, final String description, final String optionalLink, 
		final String newTitle, final String newStart, final String newEnd, final String newWorkload,
		final String newDescription, final String newOptionalLink) {
		
		//Iniciamos sesion con el usuario de manager01
		super.signIn("manager01", "manager01");
		
		//clicamos en la lista de tareas del manager
		super.clickOnMenu("Manager", "Manager tasks");
		
		//Comprueba en el listado la tarea que vamos a proceder a eliminar para comprobar que
		//todo está correctamente
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, start);
		super.checkColumnHasValue(recordIndex, 2, end);
		
		//Clicamos en la tarea especifica para ver los detalles de la tarea que vamos a borrar
		super.clickOnListingRecord(recordIndex);
	
		super.clickOnSubmitButton("Delete"); //le damos al boton para borrar la tarea
		
		super.clickOnMenu("Manager", "Manager tasks"); //nos vamos ahora al listado de todas las tareas del manager
		
		//Comprueba en el listado que ya no existe la tarea borrada y. en su lugar, la tarea siguiente a la borrada
		//ocupa ahora el lugar de la otra (por el número del índice). Comprobando que la tarea siguiente a la borrada
		//tiene el índice en i-1 sabríamos que se ha borrado correctamente
		super.checkColumnHasValue(recordIndex, 0, newTitle);
		super.checkColumnHasValue(recordIndex, 1, newStart);
		super.checkColumnHasValue(recordIndex, 2, newEnd);
		
		//Clicamos en la tarea especifica para ver los detalles de esa tarea
		super.clickOnListingRecord(recordIndex);
		
		//Vamos a comprobar que cada elemnto tiene el valor del csv
		super.checkInputBoxHasValue("title", newTitle);
		super.checkInputBoxHasValue("start", newStart);
		super.checkInputBoxHasValue("end", newEnd);
		super.checkInputBoxHasValue("workload", newWorkload);
		super.checkInputBoxHasValue("description", newDescription);
		super.checkInputBoxHasValue("optionalLink", newOptionalLink);
		
		//Salimos de la sesion
		super.signOut();
		
	}
	
	/*
	 * CASO NEGATIVO: Intentamos entrar en un enlace de manager sin estar autenticados e intentamos borrar la tarea de ese manager.
	 * Al no haber iniciado sesión, saltará un error de que no podemos acceder a esa tarea para borrarla siendo anonimo.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/delete-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(48)
	public void deleteNegative(final int recordIndex, final String path, final String query) {
		
		super.navigate(path, query);
		super.checkErrorsExist();
	}

}
