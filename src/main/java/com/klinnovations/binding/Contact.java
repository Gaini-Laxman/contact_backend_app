package com.klinnovations.binding;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTACT_DTLS")
public class Contact {

	@Id
	@GeneratedValue
	
	@Column(unique = true)
	private Integer contactId;
	
	@Column(unique = true)
	private String contactName;
	
	@Column(unique = true)
	private String contactEmail;
	
	@Column(unique = true)
	private Long contactNum;
	

}
