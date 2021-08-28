package acme.features.authenticated.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Task;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedTaskShowService implements AbstractShowService<Authenticated, Task>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected AuthenticatedTaskRepository repository;

	@Override
	public boolean authorise(final Request<Task> request) {
		assert request != null;
		final int taskId = request.getModel().getInteger("id");
		final Task task = this.repository.findOneTaskById(taskId);

		return !task.getPrivacy();
	}

	@Override
	public void unbind(final Request<Task> request, final Task entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "start", "end", "workload", "description", "optionalLink", "privacy");
		
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
