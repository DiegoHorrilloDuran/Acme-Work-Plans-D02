package acme.framework.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import acme.framework.utilities.Duration;
import lombok.Getter;
import lombok.Setter;



@Entity

@Getter
@Setter
public class Task extends DomainEntity {
	
	//Serialisation identifier 
	 protected static final long serialVersionUID = 1L;
	 
	 //Attributes
	 
	 @NotNull
	 @NotEmpty
	 @Size(max=79)
	 protected String 	title;
	 
	 @NotNull
	 @Temporal(TemporalType.TIMESTAMP)
	 protected LocalDate		start;
	 
	 @NotNull
	 @Temporal(TemporalType.TIMESTAMP)
	 protected LocalDate		end;
	 
	 @NotNull
	 @Digits(integer = 2, fraction = 2)
	 @Positive
	 protected Double	workload;
	 
	 @NotEmpty
	 @Size(max=499)
	 protected String 	description;
	 
	 @NotNull
	 protected Boolean 	privacy;
	 
	 @NotNull
	 protected Integer idmanager;
	 
	 @URL
	 protected String optionalLink;
	 
	 //Derived Attributes
	 
	 public Double getExecutionPeriod() {
		 return Duration.getDuration(this.start, this.end);
	 }
}
