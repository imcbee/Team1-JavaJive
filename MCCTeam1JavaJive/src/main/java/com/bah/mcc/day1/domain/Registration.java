package com.bah.mcc.day1.domain;

import java.util.Date;

public class Registration {
	private long id;
	private String eventId;
	private String customerName;
	private Date registrationDate;
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
