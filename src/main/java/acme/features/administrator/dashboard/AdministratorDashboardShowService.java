package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.entities.Dashboard;
import acme.framework.services.AbstractShowService;
import acme.framework.utilities.Duration;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	private AdministratorDashboardRepository repository;
	
	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final Integer pt = entity.numberOfPublicTasks();
		final Integer ut = entity.numberOfUnfinishedTasks();
		
		request.unbind(entity, model, "numberOfTasks", "numberOfPrivateTasks", "numberOfFinishedTasks","maxTaskExecutionPeriod","minTaskExecutionPeriod","avgTaskExecutionPeriods","stdDevTaskExecutionPeriods","maxTaskWorkload","minTaskWorkload","avgTaskWorkloads","stdDevTaskWorkloads");
		model.setAttribute("numberOfPublicTasks", pt);
		model.setAttribute("numberOfUnfinishedTasks", ut);
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		final Dashboard dashboard = new Dashboard();
		
		dashboard.setNumberOfTasks(this.repository.getNumberOfTasks());
		dashboard.setNumberOfPrivateTasks(this.repository.getNumberOfPrivateTasks());
		dashboard.setNumberOfFinishedTasks(this.repository.getNumberOfFinishedTasks());
		dashboard.setMaxTaskExecutionPeriod(this.repository.getMaxTaskExecutionPeriod());
		dashboard.setMinTaskExecutionPeriod(this.repository.getMinTaskExecutionPeriod());
		dashboard.setAvgTaskExecutionPeriods(this.repository.getAvgTaskExecutionPeriods());
		dashboard.setStdDevTaskExecutionPeriods(this.repository.getStdDevTaskExecutionPeriods());
		dashboard.setMaxTaskWorkload(Duration.correctPeriod(this.repository.getMaxTaskWorkload()));
		dashboard.setMinTaskWorkload(Duration.correctPeriod(this.repository.getMinTaskWorkload()));
		dashboard.setAvgTaskWorkloads(Duration.correctPeriod(this.repository.getAvgTaskWorkloads()));
		dashboard.setStdDevTaskWorkloads(Duration.correctPeriod(this.repository.getStdDevTaskWorkloads()));
		
		return dashboard;
	}

}
