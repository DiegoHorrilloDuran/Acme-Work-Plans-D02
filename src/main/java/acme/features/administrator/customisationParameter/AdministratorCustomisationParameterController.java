package acme.features.administrator.customisationParameter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;
import acme.framework.entities.CustomisationParameter;

@Controller
@RequestMapping("/administrator/customisation-parameter/")
public class AdministratorCustomisationParameterController extends AbstractController<Administrator, CustomisationParameter>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorCustomisationParameterShowService	showService;

	@Autowired
	protected AdministratorCustomisationParameterUpdateService	updateService;
	
	@Autowired
	protected AdministratorCustomisationParameterListService	listService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
	}


}
