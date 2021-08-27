package acme.features.manager.task;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Manager;
import acme.framework.entities.Task;
import acme.framework.services.AbstractListService;

@Service
public class ManagerTaskListService implements AbstractListService<Manager, Task>{


	// Internal state ---------------------------------------------------------

	@Autowired
	protected ManagerTaskRepository repository;
		
	@Override
	public boolean authorise(final Request<Task> request) {
		assert request != null;

		return true;
	}


	@Override
	public void unbind(final Request<Task> request, final Task entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "start", "end");
		
	}

	@Override
	public Collection<Task> findMany(final Request<Task> request) {
		assert request != null;
		
		final Collection<Task> res;
		Integer manager;
		
		manager = request.getPrincipal().getAccountId();
		res = this.repository.findTaskByManagerId(manager);  //.stream().filter(x-> x.getIdmanager().equals(manager));
		
		return res;
	}


}
