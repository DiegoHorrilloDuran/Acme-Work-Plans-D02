package acme.testing;

import org.junit.jupiter.api.BeforeAll;

import acme.framework.helpers.StringHelper;

public abstract class AcmeWorkPlansTest extends AcmeTest{

	@Override
	@BeforeAll
	public void beforeAll() {
		super.setHeadless(true);
		super.beforeAll();
		
		super.setBaseCamp("http", "localhost", "8080", "/Acme-Work-Plans", "/master/welcome", "?language=en&debug=true");
		super.setAutoPausing(false);
		
		this.navigateHome();
		this.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Populate DB (samples)");
		super.checkAlertExists(true);
		this.signOut();
	}

	protected void signIn(final String username, final String password) {
		assert !StringHelper.isBlank(username);
		assert !StringHelper.isBlank(password);
		
		super.navigateHome();
		super.clickOnMenu("Sign in", null);
		super.fillInputBoxIn("username", username);
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("remember", "true");
		super.clickOnSubmitButton("Sign in");
		super.checkSimplePath("/master/welcome");
		super.checkLinkExists("Account");
	}
	
	protected void signOut() {
		super.navigateHome();
		super.clickOnMenu("Sign out", null);
		super.checkSimplePath("/master/welcome");
		
	}
	
	protected void signUp(final String username, final String password, final String name, final String surname, final String email, final String phone) {
		assert !StringHelper.isBlank(username);
		assert !StringHelper.isBlank(password);
		assert !StringHelper.isBlank(name);
		assert !StringHelper.isBlank(surname);
		assert !StringHelper.isBlank(email);
		//phone is nullable
		
		super.navigateHome();
		super.clickOnMenu("Sign in", null);
		super.fillInputBoxIn("username", username);
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("password", name);
		super.fillInputBoxIn("password", surname);
		super.fillInputBoxIn("password", email);
		super.fillInputBoxIn("password", phone);
		super.fillInputBoxIn("remember", "true");
		super.clickOnSubmitButton("Sign in");
		super.checkSimplePath("/master/welcome");
		super.checkLinkExists("Account");
	}
	
	protected void navigateTo(final String path) {
		assert this.isSimplePath(path);

		this.navigate(() -> {
			String url;

			url = String.format("%s%s", this.baseUrl, path);
			this.driver.get(url);
			this.longSleep();
		});
	}
	
}
