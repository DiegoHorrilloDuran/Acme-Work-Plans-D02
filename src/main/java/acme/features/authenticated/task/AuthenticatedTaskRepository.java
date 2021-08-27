package acme.features.authenticated.task;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedTaskRepository extends AbstractRepository {

	@Query("select t from Task t where (t.privacy = false and t.end < CURRENT_TIMESTAMP) order by t.start, t.end, t.workload")
	Collection<Task> findManyPublic();
	
	@Query("select t from Task t where t.id = ?1")
	Task findOneTaskById(int id);
}
