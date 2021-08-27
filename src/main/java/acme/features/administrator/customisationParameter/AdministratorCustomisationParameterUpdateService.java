package acme.features.administrator.customisationParameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.entities.CustomisationParameter;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorCustomisationParameterUpdateService implements AbstractUpdateService<Administrator, CustomisationParameter>{

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorCustomisationParameterRepository repository;

	// AbstractUpdateService<Administrator, CustomisationParameter> interface --------------
	@Override
	public boolean authorise(final Request<CustomisationParameter> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<CustomisationParameter> request, final CustomisationParameter entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<CustomisationParameter> request, final CustomisationParameter entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "spamWords", "threshold");
		
	}

	@Override
	public CustomisationParameter findOne(final Request<CustomisationParameter> request) {
		assert request != null;

		CustomisationParameter result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<CustomisationParameter> request, final CustomisationParameter entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		Double threshold;
		Boolean isPercentage;
		
		threshold = entity.getThreshold();
		isPercentage = threshold <= 100.00;
		
		if (!errors.hasErrors("threshold")) {
            errors.state(request, isPercentage, "threshold", "administrator.customisation-parameter.error.threshold");
        }

		
	}

	@Override
	public void update(final Request<CustomisationParameter> request, final CustomisationParameter entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
		
	}

	

}
