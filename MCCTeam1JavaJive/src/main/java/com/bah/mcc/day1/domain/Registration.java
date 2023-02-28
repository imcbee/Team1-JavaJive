package com.bah.mcc.day1.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="registrations")
public class Registration {
	
	@Id
	private long id;
	
	private String event_id;
	
	private String customer_id;
	
	private Date registration_date;
	
	private String notes;
	
//	public Registration() {
//		
//	}
//
//	public Registration(long id, String event_id, String customer_id, Date registration_date, String notes) {
//		super();
//		this.id = id;
//		this.event_id = event_id;
//		this.customer_id = customer_id;
//		this.registration_date = registration_date;
//		this.notes = notes;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEventId() {
		return event_id;
	}

	public void setEventId(String eventId) {
		this.event_id = eventId;
	}

	public String getCustomerName() {
		return customer_id;
	}

	public void setCustomerName(String customer_id) {
		this.customer_id = customer_id;
	}

	

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}



	

}
