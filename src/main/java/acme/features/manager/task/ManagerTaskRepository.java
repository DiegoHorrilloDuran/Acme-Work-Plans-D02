package acme.features.manager.task;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.CustomisationParameter;
import acme.framework.entities.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ManagerTaskRepository extends AbstractRepository {

	@Query("select t from Task t where t.idmanager = ?1 order by t.start, t.end, t.workload")
	Collection<Task> findTaskByManagerId(Integer id);
	
	@Query("select t from Task t where t.id = ?1")
	Task findOneTaskById(int id);
	
	@Query("select c from CustomisationParameter c")
	List<CustomisationParameter> findSpam();
}
