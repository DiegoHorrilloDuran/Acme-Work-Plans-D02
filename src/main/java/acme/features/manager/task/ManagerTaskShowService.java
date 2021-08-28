package acme.features.manager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Manager;
import acme.framework.entities.Task;
import acme.framework.services.AbstractShowService;

@Service
public class ManagerTaskShowService implements AbstractShowService<Manager, Task>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected ManagerTaskRepository repository;

	@Override
	public boolean authorise(final Request<Task> request) {
		assert request != null;
		final int id = request.getModel().getInteger("id");
		final Task task = this.repository.findOneTaskById(id);
		final int idManager = task.getIdmanager();   //idManager es el Id del UsserAccount del manager que ha creado la tarea.
		final int currentId = request.getPrincipal().getAccountId();

		return currentId == idManager;
	}

	@Override
	public void unbind(final Request<Task> request, final Task entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "start", "end", "workload", "description","idmanager", "optionalLink", "privacy");
		
	}

	@Override
	public Task findOne(final Request<Task> request) {
		assert request != null;
		
		final Task res;
		
		int id;
		
		id = request.getModel().getInteger("id");
		
		res = this.repository.findOneTaskById(id);
		
		return res;
	}

}
