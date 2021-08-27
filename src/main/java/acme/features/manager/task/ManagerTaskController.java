package acme.features.manager.task;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Manager;
import acme.framework.entities.Task;

@Controller
@RequestMapping("/manager/task/")
public class ManagerTaskController extends AbstractController<Manager, Task>{

	// Internal state ---------------------------------------------------------
	
	@Autowired
	private ManagerTaskListService listService;
	
	@Autowired
	private ManagerTaskShowService showService;
	
	@Autowired
	private ManagerTaskCreateService createService;
	
	@Autowired
	private ManagerTaskDeleteService deleteService;
	
	@Autowired
	private ManagerTaskUpdateService updateService;
	
	// Constructors -----------------------------------------------------------

	@PostConstruct
	protected void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
	}
}
