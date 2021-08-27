package acme.features.manager.task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Manager;
import acme.framework.entities.Task;
import acme.framework.services.AbstractDeleteService;

@Service
public class ManagerTaskDeleteService implements AbstractDeleteService<Manager, Task>{

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

	@Override
	public void validate(final Request<Task> request, final Task entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;		
	}

	@Override
	public void delete(final Request<Task> request, final Task entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);
	}




	/*
	
	@Service
	public class ManagerWorkPlanDeleteService implements AbstractDeleteService<Manager, WorkPlan> {

		// Internal state ---------------------------------------------------------

		@Autowired
		protected ManagerWorkPlanRepository repository;

		@Override
		public boolean authorise(final Request<WorkPlan> request) {
			assert request != null;

			boolean result;
			int jobId;
			final WorkPlan workplan;
			Manager owner;
			Principal principal;

			jobId = request.getModel().getInteger("id");
			workplan = this.repository.findOneWorkPlanById(jobId);
			owner = workplan.getOwner();
			principal = request.getPrincipal();
			result = owner.getUserAccount().getId() == principal.getAccountId();

			return result;
		}

		@Override
		public void bind(final Request<WorkPlan> request, final WorkPlan entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;

			request.bind(entity, errors);
		}

		@Override
		public void unbind(final Request<WorkPlan> request, final WorkPlan entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "isPublic", "executionStart", "executionEnd");
		}

		@Override
		public WorkPlan findOne(final Request<WorkPlan> request) {
			assert request != null;

			WorkPlan result;
			int id;

			id = request.getModel().getInteger("id");
			result = this.repository.findOneWorkPlanById(id);

			return result;
		}

		@Override
		public void validate(final Request<WorkPlan> request, final WorkPlan entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;
		}

		@Override
		public void delete(final Request<WorkPlan> request, final WorkPlan entity) {
			assert request != null;
			assert entity != null;

			this.repository.delete(entity);
		}

	}*/
}
