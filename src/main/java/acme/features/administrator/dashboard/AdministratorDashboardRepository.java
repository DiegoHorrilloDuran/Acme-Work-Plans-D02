
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(t) from Task t")
	Integer getNumberOfTasks();
	
	@Query("select count(t) from Task t where t.privacy = true")
	Integer getNumberOfPrivateTasks();
	
	@Query("select count(t) from Task t where t.end < CURRENT_TIMESTAMP")
	Integer getNumberOfFinishedTasks();
	
	@Query("select max(DATEDIFF(t.end, t.start)) from Task t")
	Integer getMaxTaskExecutionPeriod();
	
	@Query("select min(DATEDIFF(t.end, t.start)) from Task t")
	Integer getMinTaskExecutionPeriod();
	
	@Query("select avg(DATEDIFF(t.end, t.start)) from Task t")
	Double getAvgTaskExecutionPeriods();
	
	@Query("select stddev(DATEDIFF(t.end, t.start)) from Task t")
	Double getStdDevTaskExecutionPeriods();
	
	@Query("select max(t.workload) from Task t")
	Double getMaxTaskWorkload();
	
	@Query("select min(t.workload) from Task t")
	Double getMinTaskWorkload();
	
	@Query("select avg(t.workload) from Task t")
	Double getAvgTaskWorkloads();
	
	@Query("select stddev(t.workload) from Task t")
	Double getStdDevTaskWorkloads();
}

