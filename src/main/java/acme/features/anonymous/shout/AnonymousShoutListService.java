package acme.features.anonymous.shout;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.entities.Shout;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousShoutListService implements AbstractListService<Anonymous, Shout>{
	//Internal State.............................
	@Autowired
	AnonymousShoutRepository repository;
	
	//AbstractListService<Administrator, Shout> interface.....
	@Override
	public boolean authorise(final Request<Shout> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Shout> request, final Shout entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "author", "text", "moment", "info");
		
	}

	@Override
	public Collection<Shout> findMany(final Request<Shout> request) {
		assert request != null;
		Collection<Shout> resultado;
		resultado = this.repository.findManyByLastMonthOrdened();
		return resultado;
	}
	
	
	
}
