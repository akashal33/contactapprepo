package com.akashk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="contact_info")
public class Contact {
	
	@Id
	@GeneratedValue
	@Column(name = "contact_id")
	private Integer contactId;
	@Column(name = "contact_name")
	private String contactName;
	@Column(name = "contact_email")
	private String contactEmail;
	@Column(name = "contact_number")
	private Long contactNumber;
	private boolean activeFlag;
	
	

}
