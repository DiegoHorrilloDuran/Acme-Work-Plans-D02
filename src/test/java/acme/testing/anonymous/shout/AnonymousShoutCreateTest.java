package acme.testing.anonymous.shout;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class AnonymousShoutCreateTest extends AcmeWorkPlansTest {
	
	/*CASO POSITIVO
	1. Todo relleno correctamente
	2. Todo relleno excepto Información
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(13)
    public void createPositive(final int recordIndex, final String author, final String text, final String info) {
		
		super.clickOnMenu("Anonymous", "New shout");
		
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		
		super.clickOnSubmitButton("Shout!");
		
		super.clickOnMenu("Anonymous", "Shouts");
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);
		
		
	}
	
	/*CASO NEGATIVO
	1. Longitud de Nombre incorrecto
	2. Información rellenada incorrectamente
	3. Texto rellenado con Spam
	4. Texto superior al 10% de Spam
	5. Todos los errores a la vez
	 */		
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(14)
	public void createNegative(final int recordIndex, final String author, final String text, final String info) {
			
		super.clickOnMenu("Anonymous", "New shout");
			
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
			
		super.clickOnSubmitButton("Shout!");
		super.checkErrorsExist();
			
	}
}
