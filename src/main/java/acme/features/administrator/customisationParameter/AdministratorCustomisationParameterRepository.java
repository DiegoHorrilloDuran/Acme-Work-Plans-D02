package acme.features.administrator.customisationParameter;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.CustomisationParameter;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorCustomisationParameterRepository extends AbstractRepository{

	@Query("select cp from CustomisationParameter cp where cp.id=?1")
    CustomisationParameter findOneById(int id);

    @Query("select cp from CustomisationParameter cp")
    Collection<CustomisationParameter> findMany();
}
