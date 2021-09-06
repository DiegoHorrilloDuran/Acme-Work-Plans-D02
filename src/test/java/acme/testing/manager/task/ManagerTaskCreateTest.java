package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

/*
 * En este test vamos a comprobar tanto el caso positivo de la creacion de una task del manager como los 
 * diferentes casos negativos que pueden ocurrir durante la creacion de una task.
 */
public class ManagerTaskCreateTest extends AcmeWorkPlansTest {
	
	/*
	 * CASO POSITIVO
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(40)
	public void createPositive(final int recordIndex, final String title, final String start, final String end, final String workload, final String description, final String optionalLink) {
		
		//Iniciamos sesion con el usuario de manager01
		super.signIn("manager01", "manager01");
		
		//clicamos en create task
		super.clickOnMenu("Manager", "Create task");
		
		//rellenamos los campos de la creacion de la tarea
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("start", start);
		super.fillInputBoxIn("end", end);
		super.fillInputBoxIn("workload", workload);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("optionalLink", optionalLink);
		
		super.clickOnSubmitButton("Create"); //creamos la tarea
		
		super.clickOnMenu("Manager", "Manager tasks"); //nos vamos ahora al listado de todas las tareas del manager
		
		//Comprueba en el listado que existe un objeto con dichos valores
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, start);
		super.checkColumnHasValue(recordIndex, 2, end);
		
		//Clicamos en la tarea especifica para ver los detalles de esa tarea
		super.clickOnListingRecord(recordIndex);
		
		//Vamos a comprobar que cada elemnto tiene el valor del csv
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("start", start);
		super.checkInputBoxHasValue("end", end);
		super.checkInputBoxHasValue("workload", workload);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		
		//Salimos de la sesion
		super.signOut();
		
	}
	
	/*
	 * CASOS NEGATIVOS: Contamos con los casos siguientes:
	 * 1-todos los campos estan vacios
	 * 2-en el titulo hay una palabra spam
	 * 3-en la descripcion hay una palabra spam
	 * 4-las fechas de start y end son del pasado
	 * 5-la fecha de end es anterior a la fecha de start
	 * 6-la carga de trabajo es mayor al periodo de ejecucion
	 * 7-la carga de trabajo es 0
	 * 8-la carga de trabajo es negativa
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(41)
	public void createNegative(final int recordIndex, final String title, final String start, final String end, final String workload, final String description, final String optionalLink) {
		
		//Iniciamos sesion con el usuario de manager01
		super.signIn("manager01", "manager01");
		
		//clicamos en create task
		super.clickOnMenu("Manager", "Create task");
		
		//rellenamos los campos de la creacion de la tarea, donde va a estar el error que debe saltar
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("start", start);
		super.fillInputBoxIn("end", end);
		super.fillInputBoxIn("workload", workload);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("optionalLink", optionalLink);
		
		
		super.clickOnSubmitButton("Create"); //creamos la tarea
		
		super.checkErrorsExist(); //comprobamos si hay algún error
		
		//Salimos de la sesion
		super.signOut();
		
	}

}
