package acme.features.anonymous.shout;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.CustomisationParameter;
import acme.framework.entities.Shout;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousShoutRepository extends AbstractRepository {
	@Query("select s from Shout s")
	Collection<Shout> findMany();
	
	@Query("select s from Shout s where DATEDIFF(CURRENT_TIMESTAMP,s.moment)<=31 order by s.moment")
	Collection<Shout>findManyByLastMonthOrdened();
	
	@Query("select c from CustomisationParameter c")
	List<CustomisationParameter> findSpam();
}
