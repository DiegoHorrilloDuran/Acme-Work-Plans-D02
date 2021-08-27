
package acme.framework.entities;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	private static final long	serialVersionUID	= 1L;

	Integer						numberOfTasks;
	Integer						numberOfPrivateTasks;
	Integer						numberOfFinishedTasks;
	Integer						maxTaskExecutionPeriod;
	Integer						minTaskExecutionPeriod;
	Double						avgTaskExecutionPeriods;
	Double						stdDevTaskExecutionPeriods;
	Double						maxTaskWorkload;
	Double						minTaskWorkload;
	Double						avgTaskWorkloads;
	Double						stdDevTaskWorkloads;

	//Derived attributes ------------------------------------------------


	public Integer numberOfPublicTasks() {
		return this.numberOfTasks - this.numberOfPrivateTasks;
	}

	public Integer numberOfUnfinishedTasks() {
		return this.numberOfTasks - this.numberOfFinishedTasks;
	}
}
