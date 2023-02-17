package com.bah.mcc.day1.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REGISTRATIONS")
public class Registration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="EVENT_ID")
	private String eventId;
	
	@Column(name="CUSTOMER_ID")
	private String customerName;
	
	@Column(name="REGISTRATION_DATE")
	private Date registrationDate;
	
	@Column(name="NOTES")
	private String notes;
	
	public Registration() {
		
	}

	public Registration(long id, String eventId, String customerName, Date registrationDate, String notes) {
		super();
		this.id = id;
		this.eventId = eventId;
		this.customerName = customerName;
		this.registrationDate = registrationDate;
		this.notes = notes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}



	

}
