package acme.framework.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Shout extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	protected LocalDate				moment;

	@NotBlank
	@Size(min=5,max=25)
	protected String			author;

	@NotBlank
	@Size(max=100)
	protected String			text;
	
	@URL
	protected String			info;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}