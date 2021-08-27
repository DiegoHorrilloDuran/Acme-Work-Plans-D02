
package acme.features.manager.task;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.CustomisationParameter;
import acme.framework.entities.Manager;
import acme.framework.entities.Task;
import acme.framework.services.AbstractCreateService;
import acme.framework.utilities.Duration;
import acme.framework.utilities.SpamDetect;

@Service
public class ManagerTaskCreateService implements AbstractCreateService<Manager, Task> {

	@Autowired
	protected ManagerTaskRepository repository;


	@Override
	public boolean authorise(final Request<Task> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Task> request, final Task entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Task> request, final Task entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "start", "end", "workload", "description", "optionalLink", "privacy", "idmanager");
	}

	@Override
	public Task instantiate(final Request<Task> request) {
		assert request != null;

		Task result;
		Integer manager;

		manager = request.getPrincipal().getAccountId();

		result = new Task();
		result.setIdmanager(manager);

		return result;
	}

	@Override
	public void validate(final Request<Task> request, final Task entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		final Date ahora = Date.from(Instant.now());
		Double wl = entity.getWorkload();
		if (wl != null) {
			wl = Duration.correctPeriod(wl);
		}

		if (!errors.hasErrors("start") && !errors.hasErrors("end")) {
			errors.state(request, !entity.getStart().before(ahora), "start", "manager.task.error.fechainicio");
			errors.state(request, entity.getStart().before(entity.getEnd()), "end", "manager.task.error.fechafin");
		}

		if (!errors.hasErrors("start") && !errors.hasErrors("end") && !errors.hasErrors("workload")) {
			errors.state(request, wl <= entity.getExecutionPeriod(), "workload", "manager.task.error.workload");
		}

		final CustomisationParameter params = this.repository.findSpam().get(0);

		if (!errors.hasErrors("title")) {
			errors.state(request, !SpamDetect.isSpamText(entity.getTitle(), params), "title", "anonymous.shout.error.spam");
		}

		if (!errors.hasErrors("description")) {
			errors.state(request, !SpamDetect.isSpamText(entity.getDescription(), params), "description", "manager.task.error.spam");
		}
		
		if (!errors.hasErrors("optionalLink")) {
			errors.state(request, !SpamDetect.isSpamText(entity.getOptionalLink(), params), "optionalLink", "manager.task.error.spam");
		}

	}

	@Override
	public void create(final Request<Task> request, final Task entity) {
		assert request != null;
		assert entity != null;

		final Double wl = request.getModel().getDouble("workload");

		entity.setWorkload(Duration.correctPeriod(wl));

		this.repository.save(entity);
	}

}
